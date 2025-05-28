package com.sergio.jawwi.core.utils

import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

/**
 * A utility object for formatting dates and times into user-friendly strings.
 */
object DateFormatter {

    /**
     * Formats a given [LocalDate] into a user-friendly string.
     * 
     * - If the date is today, it returns "Today".
     * - If the date is tomorrow, it returns "Tomorrow".
     * - Otherwise, it formats the date as "EEEE, MMMM d" (e.g., "Monday, January 1").
     *
     * @param date The [LocalDate] to format.
     * @return A formatted string representing the date.
     */
    fun formatDateEMD(date: LocalDate): String {
        val today = LocalDate.now()
        val tomorrow = today.plusDays(1)

        return when (date) {
            today -> "Today"
            tomorrow -> "Tomorrow"
            else -> date.format(DateTimeFormatter.ofPattern("EEEE, MMMM d"))
        }
    }

    /**
     * Formats a given [LocalTime] into a user-friendly string.
     * 
     * - If the time is within one hour of the current time, it returns "Now".
     * - Otherwise, it formats the time based on the provided pattern:
     *   - If [hoursOnly] is true, it uses the "h a" pattern (e.g., "3 PM").
     *   - Otherwise, it uses the "h:mm a" pattern (e.g., "3:15 PM").
     *
     * @param time The [LocalTime] to format.
     * @param hoursOnly Whether to display only the hour and period (AM/PM).
     * @return A formatted string representing the time.
     */
    fun formatTime(time: LocalTime, hoursOnly: Boolean = false): String {
        val now = LocalTime.now()

        return if (now.hour == time.hour) {
            "Now"
        } else {
            time.format(DateTimeFormatter.ofPattern( if (hoursOnly) "h a" else "h:mm a"))
        }
    }
}
