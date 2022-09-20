package com.example.santedigital.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun rememberWindowsInfo(): WindowInfo {
    val configuration = LocalConfiguration.current
    return WindowInfo(
        screenWithInfo = when {
            configuration.screenWidthDp < 600 -> WindowInfo.WindowsType.Compact
            configuration.screenWidthDp < 840 -> WindowInfo.WindowsType.Medium
            else -> WindowInfo.WindowsType.Expanded
        },
        screenHeightInfo = when {
            configuration.screenHeightDp < 480 -> WindowInfo.WindowsType.Compact
            configuration.screenHeightDp < 900 -> WindowInfo.WindowsType.Medium
            else -> WindowInfo.WindowsType.Expanded

        },
        screenWith = configuration.screenWidthDp.dp,
        screenHeight = configuration.screenHeightDp.dp
    )
}
data class WindowInfo(
    val screenWithInfo: WindowsType,
    val screenHeightInfo: WindowsType,
    val screenHeight: Dp,
    val screenWith: Dp,
)
{
    sealed class WindowsType {
        object  Compact : WindowsType()
        object  Medium : WindowsType()
        object  Expanded : WindowsType()
    }

}