package org.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.rememberNavController
import org.example.app.navigation.AppNavHost
import org.example.app.navigation.Routes
import org.example.app.ui.theme.SmartHomeTVTheme

/**
 * PUBLIC_INTERFACE
 * MainActivity is the entry point of the SmartHome TV Dashboard.
 * It hosts the Jetpack Compose content and sets up the NavHost for routes.
 */
class MainActivity : ComponentActivity() {

    /**
     * PUBLIC_INTERFACE
     * onCreate initializes the Compose UI content for the activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartHomeTVTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold { innerPadding ->
                        Surface(modifier = Modifier.padding(innerPadding)) {
                            AppNavHost(
                                navController = navController,
                                startDestination = Routes.HOME
                            )
                        }
                    }
                }
            }
        }
    }
}
