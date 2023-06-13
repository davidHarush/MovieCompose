package com.david.movieCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.david.movieCompose.ui.screens.main.MainScreen
import com.david.movieCompose.ui.theme.AppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            AppTheme {
                val systemUiController = rememberSystemUiController()
                systemUiController.apply {
                    setStatusBarColor(color = MaterialTheme.colorScheme.surface)
                    setNavigationBarColor(color = MaterialTheme.colorScheme.surface)
                }
                MainScreen()
            }
        }
    }
}
