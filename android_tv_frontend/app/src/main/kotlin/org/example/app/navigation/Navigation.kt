package org.example.app.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import org.example.app.ui.theme.SmartHomeTVTheme
import org.example.app.navigation.dpadFocusable

/**
 * PUBLIC_INTERFACE
 * AppNavHost wires the navigation graph with default transitions and DPAD-ready screens.
 *
 * @param navController The NavHostController used to navigate between screens.
 * @param startDestination The initial route. Defaults to Routes.HOME.
 */
@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = Routes.HOME
) {
    val defaultEnter = fadeIn(animationSpec = tween(150)) + scaleIn(initialScale = 0.98f, animationSpec = tween(150))
    val defaultExit = fadeOut(animationSpec = tween(150)) + scaleOut(targetScale = 1.02f, animationSpec = tween(150))

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            route = Routes.HOME,
            enterTransition = { defaultEnter },
            exitTransition = { defaultExit },
            popEnterTransition = { defaultEnter },
            popExitTransition = { defaultExit }
        ) {
            HomeScreen(
                onOpenDevice = { deviceId -> navController.navigate(Routes.deviceDetail(deviceId)) },
                onOpenCamera = { cameraId -> navController.navigate(Routes.camera(cameraId)) }
            )
        }

        composable(
            route = Routes.DEVICE_DETAIL_WITH_ARG,
            arguments = listOf(navArgument("deviceId") { type = NavType.StringType }),
            enterTransition = { defaultEnter },
            exitTransition = { defaultExit },
            popEnterTransition = { defaultEnter },
            popExitTransition = { defaultExit }
        ) { backStackEntry ->
            val deviceId = requireNotNull(backStackEntry.arguments?.getString("deviceId")) { "deviceId required" }
            DeviceDetailScreen(
                deviceId = deviceId,
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Routes.CAMERA_WITH_ARG,
            arguments = listOf(navArgument("cameraId") { type = NavType.StringType }),
            enterTransition = { defaultEnter },
            exitTransition = { defaultExit },
            popEnterTransition = { defaultEnter },
            popExitTransition = { defaultExit }
        ) { backStackEntry ->
            val cameraId = requireNotNull(backStackEntry.arguments?.getString("cameraId")) { "cameraId required" }
            CameraScreen(
                cameraId = cameraId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}

/**
 * PUBLIC_INTERFACE
 * Minimal, DPAD-ready Home screen with buttons to navigate to Device Detail and Camera.
 * Placeholder content to be replaced by full-featured UI in subsequent steps.
 */
@Composable
fun HomeScreen(
    onOpenDevice: (String) -> Unit,
    onOpenCamera: (String) -> Unit
) {
    val firstFocus = TVFocus.rememberFirstItemFocusRequester()
    SmartHomeTVTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "SmartHome TV Dashboard",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(Modifier.height(24.dp))
                    Button(
                        modifier = Modifier
                            .focusRequester(firstFocus)
                            .then(Modifier.dpadFocusable()),
                        onClick = { onOpenDevice("device-001") }
                    ) {
                        Text("Open Device Detail (device-001)")
                    }
                    Spacer(Modifier.height(12.dp))
                    Button(
                        modifier = Modifier.dpadFocusable(),
                        onClick = { onOpenCamera("cam-42") }
                    ) {
                        Text("Open Camera (cam-42)")
                    }
                }
            }
        }
    }
}

/**
 * PUBLIC_INTERFACE
 * Minimal Device Detail screen showing the id and a back button.
 */
@Composable
fun DeviceDetailScreen(
    deviceId: String,
    onBack: () -> Unit
) {
    val firstFocus = TVFocus.rememberFirstItemFocusRequester()
    SmartHomeTVTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Device Detail",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Device ID: $deviceId",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(Modifier.height(24.dp))
                    Button(
                        modifier = Modifier
                            .focusRequester(firstFocus)
                            .then(Modifier.dpadFocusable()),
                        onClick = onBack
                    ) {
                        Text("Back")
                    }
                }
            }
        }
    }
}

/**
 * PUBLIC_INTERFACE
 * Minimal Camera screen showing the id and a back button.
 */
@Composable
fun CameraScreen(
    cameraId: String,
    onBack: () -> Unit
) {
    val firstFocus = TVFocus.rememberFirstItemFocusRequester()
    SmartHomeTVTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Camera View",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Camera ID: $cameraId",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(Modifier.height(24.dp))
                    Button(
                        modifier = Modifier
                            .focusRequester(firstFocus)
                            .then(Modifier.dpadFocusable()),
                        onClick = onBack
                    ) {
                        Text("Back")
                    }
                }
            }
        }
    }
}
