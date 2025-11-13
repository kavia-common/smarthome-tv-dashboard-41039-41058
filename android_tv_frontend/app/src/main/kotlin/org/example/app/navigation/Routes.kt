package org.example.app.navigation

/**
 * PUBLIC_INTERFACE
 * Routes defines the navigation destinations for the app and provides helper builders for
 * parameterized routes used by the NavHost.
 */
object Routes {

    /** Root destinations */
    const val HOME: String = "home"
    const val DEVICE_DETAIL: String = "deviceDetail"
    const val CAMERA: String = "camera"

    /** Parameterized paths */
    const val DEVICE_DETAIL_WITH_ARG: String = "$DEVICE_DETAIL/{deviceId}"
    const val CAMERA_WITH_ARG: String = "$CAMERA/{cameraId}"

    // PUBLIC_INTERFACE
    /**
     * Build the device detail route with the provided deviceId.
     * @param deviceId The id of the device to show.
     * @return A navigable route string.
     */
    fun deviceDetail(deviceId: String): String = "$DEVICE_DETAIL/$deviceId"

    // PUBLIC_INTERFACE
    /**
     * Build the camera route with the provided cameraId.
     * @param cameraId The id of the camera to show.
     * @return A navigable route string.
     */
    fun camera(cameraId: String): String = "$CAMERA/$cameraId"
}
