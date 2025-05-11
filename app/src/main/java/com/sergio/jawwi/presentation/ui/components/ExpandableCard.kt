package com.sergio.jawwi.presentation.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * A composable function that creates an expandable card with animated content size.
 *
 * The card can expand or collapse when clicked, and its state can be controlled
 * externally or internally. It supports custom content and provides a callback
 * when the expanded state changes.
 *
 * @param modifier Modifier to be applied to the card.
 * @param expandedState Optional external state to control the expanded state of the card.
 * @param onExpanded Callback invoked when the expanded state changes.
 * @param content The content to display inside the card, which depends on the expanded state.
 */
@Composable
fun ExpandableCard(
    modifier: Modifier = Modifier,
    expandedState: MutableState<Boolean>? = null,
    onExpanded: (Boolean) -> Unit = {},
    content: @Composable (Boolean) -> Unit,
) {
    // Fallback to rememberSaveable if no external state is passed
    val internalExpanded = rememberSaveable { mutableStateOf(false) }
    val currentExpandedState = expandedState ?: internalExpanded

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.White.copy(alpha = 0.2f))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                currentExpandedState.value = !currentExpandedState.value
                onExpanded(currentExpandedState.value)
            }
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            )
    ) {
        content(currentExpandedState.value)
    }
}

