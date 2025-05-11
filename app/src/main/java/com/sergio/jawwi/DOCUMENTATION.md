# Jawwi Weather App Documentation

This document provides a comprehensive overview of the Jawwi Weather App codebase, including all files, classes, functions, and components.

## Table of Contents
1. [Application Structure](#application-structure)
2. [Data Layer](#data-layer)
3. [Presentation Layer](#presentation-layer)
4. [Core Components](#core-components)

## Application Structure

### App.kt
The main application composable that handles screen navigation and theme application.

**Classes/Components:**
- `App`: Main composable function that sets up the app's UI and navigation.
  - Parameters:
    - `weatherViewModel`: Provides weather data
    - `navigationViewModel`: Manages navigation between screens
  - Functionality:
    - Sets up back button handling
    - Applies the appropriate weather theme based on current conditions
    - Handles screen transitions with animations
    - Renders the appropriate screen based on navigation state

### MainActivity.kt
The main activity that serves as the entry point for the application.

**Classes/Components:**
- `MainActivity`: Main Android activity class.
  - Properties:
    - `weatherViewModel`: ViewModel for weather data
    - `navigationViewModel`: ViewModel for navigation
  - Methods:
    - `onCreate()`: Initializes ViewModels and sets up the UI

## Data Layer

### Models

#### WeatherDataModel.kt
Main data model representing weather information.

**Classes/Components:**
- `WeatherDataModel`: Data class representing comprehensive weather information.
  - Properties:
    - `timezone`: String representing the timezone
    - `description`: String describing the weather
    - `alerts`: List of weather alerts
    - `currentConditions`: Current weather conditions
    - `days`: List of forecast days
  - Methods:
    - `fromJson()`: Companion object method to parse JSON data into the model

#### WeatherForecastDataModel.kt
Data model representing weather forecast for a specific time period.

**Classes/Components:**
- `WeatherForecastDataModel`: Data class representing weather forecast data.
  - Properties:
    - `datetime`: Date/time of the forecast (can be LocalDate or LocalTime)
    - `tempMax`: Maximum temperature
    - `tempMin`: Minimum temperature
    - `temp`: Current temperature
    - `feelsLike`: "Feels like" temperature
    - `humidity`: Humidity percentage
    - `precipitationProb`: Precipitation probability
    - `windSpeed`: Wind speed
    - `windDir`: Wind direction in degrees
    - `pressure`: Atmospheric pressure
    - `cloudCoverPercentage`: Cloud cover percentage
    - `visibilityKm`: Visibility in kilometers
    - `snow`: Snow amount
    - `snowDepth`: Snow depth
    - `solarRadiation`: Solar radiation level
    - `solarEnergy`: Solar energy level
    - `uvIndex`: UV index
    - `severeRisk`: Severe weather risk level
    - `sunrise`: Sunrise time
    - `sunset`: Sunset time
    - `conditions`: Weather conditions description
    - `description`: Detailed weather description
    - `icon`: Icon identifier for the weather condition
    - `hours`: Hourly forecast data (if applicable)
  - Methods:
    - `fromJson()`: Companion object method to parse JSON data into the model

#### AlertDataModel.kt
Data model representing weather alerts.

**Classes/Components:**
- `AlertDataModel`: Data class representing weather alerts.
  - Properties:
    - `event`: Alert event type
    - `description`: Alert description
  - Methods:
    - `fromJson()`: Companion object method to parse JSON data into the model

### Repository

#### WeatherRepository.kt
Repository class that handles data operations for weather information.

**Classes/Components:**
- `WeatherRepository`: Repository for handling weather data operations.
  - Properties:
    - `context`: Application context
  - Methods:
    - `getCurrentLocation()`: Gets the current device location
    - `fetchWeatherData()`: Fetches weather data based on location
    - `fetchWeatherDataFromApi()`: Fetches weather data from the remote API
    - `fetchWeatherDataFromCache()`: Retrieves cached weather data

## Presentation Layer

### ViewModels

#### Weather ViewModel

##### WeatherViewModel.kt
ViewModel that handles weather data operations and state management.

**Classes/Components:**
- `WeatherViewModel`: ViewModel for managing weather data and state.
  - Properties:
    - `weatherRepository`: Repository for weather data
    - `state`: Current state of the weather data (Loading, DataLoaded, Error)
    - `weatherData`: Current weather data
    - `location`: Current location coordinates
  - Methods:
    - `loadWeatherData()`: Loads weather data based on current location
    - `loadWeatherFromLocation()`: Loads weather data for a specific location

##### State.kt
Defines the state management for the weather data.

**Classes/Components:**
- `State`: Sealed class representing the different states of weather data.
  - Subclasses:
    - `Loading`: Loading state
    - `DataLoaded`: Data successfully loaded state
    - `Error`: Error state with message and type
- `ErrorType`: Enum defining different types of errors.
  - Values:
    - `NoInternet`: No internet connection
    - `LocationPermissionDenied`: Location permission not granted
    - `DataError`: Error in data processing
    - `LocationDisabled`: Location services disabled

#### Navigation ViewModel

##### NavigationViewModel.kt
ViewModel that handles navigation between screens.

**Classes/Components:**
- `NavigationViewModel`: ViewModel for managing navigation.
  - Properties:
    - `currentScreen`: Current screen being displayed
    - `previousScreen`: Previously displayed screen
    - `isBack`: Boolean indicating if navigation is going backward
  - Methods:
    - `navigateToNext5Days()`: Navigate to the 5-day forecast screen
    - `navigateBack()`: Navigate back to the previous screen

##### Screen.kt
Defines the available screens in the application.

**Classes/Components:**
- `Screen`: Enum defining the different screens in the app.
  - Values:
    - `Home`: Home screen
    - `Next5Days`: 5-day forecast screen

### UI Screens

#### Home Screen

##### HomeScreen.kt
Main screen displaying current weather information.

**Classes/Components:**
- `HomeScreen`: Composable function for the home screen.
  - Parameters:
    - `viewModel`: Weather ViewModel
    - `goToNext5Days`: Function to navigate to the 5-day forecast
  - Functionality:
    - Requests location permission if needed
    - Displays appropriate UI based on state (loading, data loaded, error)
    - Provides refresh functionality

#### Next Week Forecast Screen

##### NextWeekForeCastScreen.kt
Screen displaying the forecast for the next week.

**Classes/Components:**
- `NextWeekForecastScreen`: Composable function for the next week forecast screen.
  - Parameters:
    - `weatherData`: Weather data to display
    - `onBack`: Function to handle back navigation
  - Functionality:
    - Displays a list of daily forecasts for the next week
    - Provides back navigation
- `NextWeekForecastScreenPreview`: Preview composable for the next week forecast screen.

##### NextWeekForecastList.kt
Component displaying a list of daily forecasts.

**Classes/Components:**
- `NextWeekForecastList`: Composable function for displaying a list of daily forecasts.
  - Parameters:
    - `days`: List of forecast days to display
  - Functionality:
    - Displays a vertically scrolling list of day forecast cards
    - Manages expanded state of cards

##### NextWeekForecastScreenTopBar.kt
Top app bar for the next week forecast screen.

**Classes/Components:**
- `NextWeekForecastScreenTopBar`: Composable function for the top app bar.
  - Parameters:
    - `onBack`: Function to handle back navigation
  - Functionality:
    - Displays screen title
    - Provides back navigation button

##### DayForecastCard.kt
Card component displaying forecast for a single day.

**Classes/Components:**
- `DayForecastCard`: Composable function for displaying a day's forecast.
  - Parameters:
    - `day`: Forecast data for the day
    - `expandedState`: State controlling whether the card is expanded
    - `onExpanded`: Function to handle expansion state changes
  - Functionality:
    - Displays date, conditions, and temperature
    - Expands to show detailed weather information when tapped

## Core Components

The application includes various core components for themes, utilities, and common UI elements that support the main functionality described above.

### Theme Components
- `JawwiTheme`: Main application theme
- `WeatherTheme`: Theme variations based on weather conditions
- `LocalWeatherTheme`: CompositionLocal for accessing the current weather theme

### Utility Components
- `DateFormatter`: Utility for formatting dates
- `JsonParserHelper`: Utility for parsing JSON data
- `LocationHelper`: Utility for accessing device location
- `SystemServiceHelper`: Utility for accessing system services

### UI Components
- `ExpandableCard`: Reusable expandable card component
- `LoadingIndicator`: Loading animation component
- `RequestLocationPermission`: Component for requesting location permissions
- `WeatherDetailsList`: Component for displaying detailed weather information
