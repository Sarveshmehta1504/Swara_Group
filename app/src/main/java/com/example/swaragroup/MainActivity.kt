package com.example.swaragroup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.swaragroup.navigation.SetupNavGraph
import com.example.swaragroup.screens.LoginScreen
import com.example.swaragroup.screens.OnBoardingScreen
import com.example.swaragroup.ui.theme.SwaraGroupTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwaraGroupTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}