package org.example.app.navigation

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.unit.dp

/**
 * PUBLIC_INTERFACE
 * TVFocus provides helpers for DPAD focus management such as creating and remembering
 * FocusRequester instances for initial focus.
 */
object TVFocus {
    /**
     * PUBLIC_INTERFACE
     * Creates and remembers a FocusRequester to request focus for the first focusable element.
     */
    @Composable
    fun rememberFirstItemFocusRequester(): FocusRequester = remember { FocusRequester() }
}

/**
 * PUBLIC_INTERFACE
 * dpadFocusable applies focusable behavior, a subtle focus visual using scale and padding,
 * and sets up DPAD key handlers using androidx.compose.ui.input.key Keys without nativeKeyCode logic.
 *
 * This modifier:
 * - makes the element focusable for TV DPAD navigation
 * - adds onFocusChanged to slightly scale and pad when focused (visual feedback)
 * - adds onKeyEvent handling that recognizes DPAD keys (arrows and enter) but returns false
 *   to let default focus/navigation behavior proceed unless customized later
 */
fun Modifier.dpadFocusable(): Modifier {
    // Local state-less visuals driven by focus change via graphicsLayer values.
    // We compute and apply visuals directly from the onFocusChanged callback by
    // adjusting layer scale and using padding when focused.
    var isFocused = false
    return this
        .focusable()
        .onFocusChanged { state ->
            isFocused = state.isFocused
        }
        .graphicsLayer {
            // Slight scale up when focused for a TV-like affordance
            val scale = if (isFocused) 1.04f else 1.0f
            scaleX = scale
            scaleY = scale
            shadowElevation = if (isFocused) 16f else 0f
            clip = false
        }
        .then(if (isFocused) Modifier.padding(2.dp) else Modifier.padding(0.dp))
        .onKeyEvent { event: KeyEvent ->
            // Keep default behavior; acknowledge only on key down if we plan to handle explicitly
            if (event.type != KeyEventType.KeyDown) return@onKeyEvent false
            when (event.key) {
                Key.DirectionUp,
                Key.DirectionDown,
                Key.DirectionLeft,
                Key.DirectionRight,
                Key.Enter,
                Key.NumPadEnter -> {
                    // By default, do not consume so that focus/navigation proceeds normally.
                    // If in future we need to intercept a key, return true here.
                    false
                }
                else -> false
            }
        }
}
