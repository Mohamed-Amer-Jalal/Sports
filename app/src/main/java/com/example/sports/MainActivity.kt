package com.example.sports

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import com.example.sports.ui.SportsApp
import com.example.sports.ui.theme.SportsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SportsTheme {
                val layoutDirection = LocalLayoutDirection.current
                val windowInsets = WindowInsets.safeDrawing.asPaddingValues()
                Surface(
                    modifier = Modifier
                        .padding(
                            start = windowInsets.calculateStartPadding(layoutDirection),
                            end = windowInsets.calculateEndPadding(layoutDirection)
                        )
                ) {
                    SportsApp(
                        windowSize = calculateWindowSizeClass(this).widthSizeClass,
                        onBackPressed = { finish() }
                    )
                }
            }
        }
    }
}