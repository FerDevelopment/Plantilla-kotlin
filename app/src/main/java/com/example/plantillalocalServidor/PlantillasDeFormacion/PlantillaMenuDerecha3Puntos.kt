package com.example.plantillalocalServidor.PlantillasDeFormacion
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.plantillalocalServidor.R

enum class Pantallas1(@StringRes val titulo: Int) {
   Inicio(titulo = R.string.alo),
   Ajustes(titulo = R.string.alo),
   Perfil(titulo = R.string.alo)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App3Puntitos(
   navController: NavHostController = rememberNavController()
){
   val pilaRetroceso by navController.currentBackStackEntryAsState()

   val pantallaActual = Pantallas.valueOf(
      pilaRetroceso?.destination?.route ?: Pantallas.Inicio.name
   )

   val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

   Scaffold(
      topBar = {
         AppTopBar(
            pantallaActual = pantallaActual,
            navController = navController,
            scrollBehavior = scrollBehavior
         )
      },
      modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
   ) { innerPadding ->

      NavHost(
         navController = navController,
         startDestination = Pantallas.Inicio.name,
         modifier = Modifier.padding(innerPadding)
      ){
         // Grafo de las rutas
         composable(route = Pantallas.Inicio.name) {

         }
         composable(route = Pantallas1.Ajustes.name) {

         }
         composable(route = Pantallas1.Perfil.name) {

         }
      }
   }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
   pantallaActual: Pantallas,
   navController: NavHostController,
   scrollBehavior: TopAppBarScrollBehavior,
   modifier: Modifier = Modifier
){
   var mostrarMenu by remember { mutableStateOf(false) }

   TopAppBar(
      title = { Text(text = stringResource(id = pantallaActual.titulo)) },
      colors = TopAppBarDefaults.mediumTopAppBarColors(
         containerColor = MaterialTheme.colorScheme.primaryContainer
      ),
      navigationIcon = {
         if(navController.previousBackStackEntry != null) {
            IconButton(onClick = { navController.navigateUp() }) {
               Icon(
                  imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                  contentDescription = stringResource(R.string.atras)
               )
            }
         }
      },
      actions = {
         if(pantallaActual == Pantallas.Inicio) {
            IconButton(onClick = { mostrarMenu = true }) {
               Icon(
                  imageVector = Icons.Outlined.MoreVert,
                  contentDescription = stringResource(R.string.alo)
               )
            }
            DropdownMenu(
               expanded = mostrarMenu,
               onDismissRequest = { mostrarMenu = false }
            ) {
               DropdownMenuItem(
                  text = { Text(text = stringResource(id = R.string.alo)) },
                  onClick = {
                     mostrarMenu = false
                     navController.navigate(Pantallas1.Ajustes.name)
                  }
               )
               DropdownMenuItem(
                  text = { Text(text = stringResource(id = R.string.alo)) },
                  onClick = {
                     mostrarMenu = false
                     navController.navigate(Pantallas1.Perfil.name)
                  }
               )
            }
         }
      },
      scrollBehavior = scrollBehavior,
      modifier = modifier
   )
}