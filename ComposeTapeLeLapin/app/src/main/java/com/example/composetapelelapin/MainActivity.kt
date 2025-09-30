package com.example.composetapelelapin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.composetapelelapin.ui.theme.ComposeTapeLeLapinTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTapeLeLapinTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {Text(text = "ITALIA")},
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.Black,
                                titleContentColor = Color.White,
                            )
                        )

                    }
                ) { innerPadding ->
                    Italia()
                    Modifier.padding(innerPadding)
                }
            }
        }
    }
}

@Composable
fun Italia() {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        Surface (
            color = Color.Green,
            modifier = Modifier.weight(1f).fillMaxHeight()
        ){}

        Surface(
            color = Color.White,
            modifier = Modifier.weight(1f).fillMaxHeight()

        ){}

        Surface(
            color = Color.Red,
            modifier = Modifier.weight(1f).fillMaxHeight()
        ){}
    }
}

