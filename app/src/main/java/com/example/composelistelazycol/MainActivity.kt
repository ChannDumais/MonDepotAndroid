package com.example.composelistelazycol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelistelazycol.ui.theme.ComposeListeLazyColTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeListeLazyColTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)) {

                        val albums = listOf<String>("Antigéographiquement", "J'ai Bu", "Comment Debord",
                            "Darlène", "La nuit est une Panthère", "Jaune")

                        for (chanson in albums){
                            item {
                                ChansonItem(chanson, modifier = Modifier.padding(15.dp).height(150.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ChansonItem(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )

}