package com.capgemini.deyvidsilva.aluno.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Blue80,
    secondary = BlueGrey80,
    tertiary = Cyan80,

    background = BackgroundDark,
    surface = SurfaceDark,

    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onTertiary = Color.Black,

    onBackground = Color.White,
    onSurface = Color.White,

    surfaceVariant = Color(0xFF3A3A3A),
    onSurfaceVariant = Color(0xFFE0E0E0),

    outline = Color(0xFFB0BEC5)
)
private val LightColorScheme = lightColorScheme(
    primary = Blue40,
    secondary = BlueGrey40,
    tertiary = Cyan40,

    background = BackgroundLight,
    surface = SurfaceLight,

    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,

    onBackground = Color(0xFF1B1B1B),
    onSurface = Color(0xFF1B1B1B),

    surfaceVariant = Color(0xFFE8EDF2),
    onSurfaceVariant = Color(0xFF424242),

    outline = Color(0xFF90A4AE)
)

@Composable
fun AlunoMVVMTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = if (darkTheme)
            DarkColorScheme
        else
            LightColorScheme,
        typography = Typography,
        content = content
    )
}