package com.example.swaragroup.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.swaragroup.screens.HomeScreen
import com.example.swaragroup.screens.LoginScreen
import com.example.swaragroup.screens.OTPScreen
import com.example.swaragroup.screens.OnBoardingScreen
import com.example.swaragroup.screens.SelectSocietyScreen
import com.example.swaragroup.screens.SignUpScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
){
    NavHost(navController = navController, startDestination = startDestination){
        composable(route= Screen.OnBoarding.route){
            OnBoardingScreen(navController = navController)
        }
        composable(route = Screen.Home.route){
            HomeScreen(navController)
        }
        composable(route = Screen.Login.route){
            LoginScreen(navController = navController)
        }
        composable(route = Screen.SignUp.route){
            SignUpScreen(navController = navController)
        }
        composable(route = Screen.OTPScreen.route){
            OTPScreen(navController = navController)
        }
        composable(route = Screen.SelectSociety.route){
            SelectSocietyScreen(navController = navController)
        }
    }
}