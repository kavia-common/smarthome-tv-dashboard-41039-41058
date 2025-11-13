package org.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.app.ui.theme.SmartHomeTVTheme

/**
 * PUBLIC_INTERFACE
 * MainActivity is the entry point of the SmartHome TV Dashboard.
 * It hosts the Jetpack Compose content and sets up a placeholder NavHost for future routes.
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
                    val navController: NavHostController = rememberNavController()
                    Scaffold { _ ->
                        // Placeholder NavHost; routes will be implemented in later steps
                        NavHost(
                            navController = navController,
                            startDestination = "placeholder"
                        ) {
                            composable("placeholder") {
                                PlaceholderScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * PUBLIC_INTERFACE
 * A temporary screen shown until real navigation destinations are implemented.
 */
@Composable
fun PlaceholderScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "SmartHome TV Dashboard\nCompose migration successful.",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
