package org.example.app.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme: ColorScheme = darkColorScheme(
    primary = Color(0xFF3B82F6),       // #3b82f6
    secondary = Color(0xFF64748B),     // #64748b
    tertiary = Color(0xFF06B6D4),      // #06b6d4
    error = Color(0xFFEF4444),         // hsl(0 84% 60%) ~ #ef4444
    background = Color(0xFF0B0F14),    // Deep background
    surface = Color(0xFF0E141B),       // Card/surface
    onPrimary = Color(0xFF0A1220),
    onSecondary = Color(0xFFE5E7EB),
    onTertiary = Color(0xFF042026),
    onBackground = Color(0xFFE5E7EB),
    onSurface = Color(0xFFE5E7EB)
)

/**
 * PUBLIC_INTERFACE
 * SmartHomeTVTheme applies the Material3 dark color scheme and typography for TV UI.
 */
@Composable
fun SmartHomeTVTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = androidx.compose.material3.Typography(),
        content = content
    )
}
