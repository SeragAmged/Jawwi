package com.sergio.jawwi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.sergio.jawwi.presentation.viewmodel.navigation.NavigationViewModel
import com.sergio.jawwi.presentation.viewmodel.weather.WeatherViewModel


class MainActivity : ComponentActivity() {
    private lateinit var weatherViewModel: WeatherViewModel
    private lateinit var navigationViewModel: NavigationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
        navigationViewModel = ViewModelProvider(this)[NavigationViewModel::class.java]
        enableEdgeToEdge()
        setContent {

            App(weatherViewModel, navigationViewModel)
        }
    }
}