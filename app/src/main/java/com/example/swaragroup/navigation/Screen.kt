package com.example.swaragroup.navigation

sealed class Screen(val route: String) {
    object OnBoarding: Screen(route = "onboarding_screen")
    object Home: Screen(route = "home_screen")
    object Login: Screen(route = "login_Screen")
    object SignUp: Screen(route = "sign_up_Screen")
    object OTPScreen: Screen(route = "OTP_Screen")
    object SelectSociety: Screen(route = "SelectSociety_Screen")

}