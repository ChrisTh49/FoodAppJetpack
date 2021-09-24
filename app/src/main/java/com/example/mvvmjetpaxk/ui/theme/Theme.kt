package com.example.mvvmjetpaxk.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Orange,
    primaryVariant = Orange,
    secondary = Orange
)

@Composable
fun MVVMJetpaxkTheme(
    content: @Composable() () -> Unit
) {

    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}