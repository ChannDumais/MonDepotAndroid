package com.example.navigation

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationTheme {
                    navigation()
                }
            }
        }
    }

@Composable
fun navigation(
    modificateur: Modifier = Modifier,
    controleurDeNavigation: NavHostController = rememberNavController()
){
    NavHost(
        navController = controleurDeNavigation,
        startDestination = "accueil"
    ){
        composable(route = "accueil") {Accueil(controleurDeNavigation, modificateur)}
        composable(route = "article") {Article(controleurDeNavigation, modificateur)}
        composable(route = "contact") {Contact(controleurDeNavigation, modificateur)}
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Accueil(
    controleurDeNavigation: NavHostController,
    modificateur: Modifier = Modifier
){
    Scaffold(
        modificateur.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray),
                title = {Text("Accueil")},
            )
        }

    ){padding ->
        Column(
            modificateur
                .fillMaxSize()
                .padding(padding),

            verticalArrangement = Arrangement.spacedBy(15.dp, alignment = Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = { controleurDeNavigation.navigate("article") },
                modificateur
                    .width(200.dp)
                    .height(50.dp)
                ) {
                    Text(
                        text="ARTICLE",
                        fontSize = 25.sp
                    )
                }

            Button(
                onClick = { controleurDeNavigation.navigate("contact")},
                modificateur
                    .width(200.dp)
                    .height(50.dp)
            ) {
                Text("CONTACT",
                    fontSize = 25.sp)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Article(
    controleurDeNavigation: NavHostController,
    modificateur: Modifier = Modifier
){
    Scaffold(
        modificateur.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray),
                title = {Text("Article")},
            )
        }

    ){padding ->
        Column(
            modificateur.fillMaxHeight().padding(padding)
        ){
            Box(
                modificateur.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ){
                Button(
                    onClick = {controleurDeNavigation.navigate("contact")},
                    modificateur
                        .width(200.dp)
                        .height(50.dp)
                ) {
                    Text("CONTACT",
                        fontSize = 25.sp)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Contact(
    controleurDeNavigation: NavHostController,
    modificateur: Modifier = Modifier
){
    Scaffold(
        modificateur.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray),
                title = {Text("Contact")},
            )
        }

    ){padding ->
        Column(
            modificateur.fillMaxHeight().padding(padding)
        ){
            Box(
                modificateur.fillMaxSize(),
            ){
                Button(
                    onClick = {controleurDeNavigation.navigate("accueil")},
                    modificateur
                        .width(200.dp)
                        .height(50.dp)
                ) {
                    Text("ACCUEIL",
                        fontSize = 25.sp)
                }
            }
        }
    }
}
