package com.example.plantillalocalServidor.PlantillasDeFormacion

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.plantillalocalServidor.R
import com.example.plantillalocalServidor.modelo.Ruta
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

enum class Pantallas2(@StringRes val titulo: Int) {
   Inicio(titulo = R.string.alo),
   Pantalla1(titulo = R.string.alo),
   Pantalla2(titulo = R.string.alo)
}

val menu = arrayOf(
   Ruta( nombre = Pantallas.Inicio.titulo, ruta = Pantallas.Inicio.name, iconoLleno = Icons.Filled.Face, iconoVacio = Icons.Filled.Face),

)

@Composable
fun Ud7Ejemplo1App(
   navController: NavHostController = rememberNavController(),
   coroutineScope: CoroutineScope = rememberCoroutineScope(),
   drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
){
   val pilaRetroceso by navController.currentBackStackEntryAsState()

   val pantallaActual = Pantallas.valueOf(
      pilaRetroceso?.destination?.route ?: Pantallas.Inicio.name
   )

   ModalNavigationDrawer(
      drawerState = drawerState,
      drawerContent = {
         ModalDrawerSheet {
            DrawerContent(
               menu = menu,
               pantallaActual = pantallaActual
            ) { ruta ->
               coroutineScope.launch {
                  drawerState.close()
               }

               navController.navigate(ruta)
            }
         }
      },
   ) {
      Scaffold(
         topBar = {
            AppTopBar(
               pantallaActual = pantallaActual,
               drawerState = drawerState
            )
         }
      ) { innerPadding ->

         NavHost(
            navController = navController,
            startDestination = Pantallas.Inicio.name,
            modifier = Modifier.padding(innerPadding)
         ) {
            // Grafo de las rutas
            composable(route = Pantallas.Inicio.name) {

            }
            composable(route = Pantallas.Pantalla1.name) {

            }
            composable(route = Pantallas.Pantalla2.name) {

            }

         }
      }
   }
}

@Composable
private fun DrawerContent(
   menu: Array<Ruta<String>>,
   pantallaActual: Pantallas,
   onMenuClick: (String) -> Unit
) {
   Column(
      modifier = Modifier.fillMaxSize()
   ) {
      Box(
         modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
         contentAlignment = Alignment.Center
      ) {
         Image(
            modifier = Modifier.size(150.dp),
            imageVector = Icons.Filled.AccountCircle,
            contentScale = ContentScale.Crop,
            contentDescription = null
         )
      }
      Spacer(modifier = Modifier.height(12.dp))
      menu.forEach {
         NavigationDrawerItem(
            label = { Text(text = stringResource(id = it.nombre)) },
            icon = { Icon(imageVector = it.iconoLleno, contentDescription = null) },
            selected = it.nombre == pantallaActual.titulo,
            onClick = {
               onMenuClick(it.ruta)
            }
         )
      }
   }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
   pantallaActual: Pantallas,
   drawerState: DrawerState?,
   modifier: Modifier = Modifier
){
   val coroutineScope = rememberCoroutineScope()

   TopAppBar(
      title = { Text(text = stringResource(id = pantallaActual.titulo)) },
      colors = TopAppBarDefaults.mediumTopAppBarColors(
         containerColor = MaterialTheme.colorScheme.primaryContainer
      ),
      navigationIcon = {
         if (drawerState != null) {
            IconButton(
               onClick = {
                  coroutineScope.launch {
                     drawerState.open()
                  }
               }) {
               Icon(
                  imageVector = Icons.Filled.Menu,
                  contentDescription = stringResource(id = R.string.atras)
               )
            }
         }
      },
      modifier = modifier
   )
}