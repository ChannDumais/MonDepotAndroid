package com.example.composelistelazycol

import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

                        val listeAlbums = listOf<Album>(
                            Album(1, "Antigéographiquement", "Jérome 50"),
                            Album(2, "J'ai Bu", "Quebec Redneck"),
                            Album(3, "La nuit est une Panthère", "Comment Debord"),
                            Album(4, "Jaune", "Jean-Pierre"),
                            Album(5, "L'Enfant Sauvage", "Gojira"),
                        )

                        for (album in listeAlbums){
                            item {
                                ChansonItem(album, modifier = Modifier.padding(15.dp).height(150.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

data class Album(
    val id: Int,
    val name: String,
    val artistName: String,
)

@Composable
fun ChansonItem(name: Album, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(
            text = name.name,
        )
        Text(
            text = name.artistName,
            fontSize = 12.sp
        )
    }

}