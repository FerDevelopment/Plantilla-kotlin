package com.example.plantillalocalServidor.pantallas

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.plantillalocalServidor.ui.GenericoViewModel

@Composable
fun App(
   viewModel: GenericoViewModel = viewModel(factory = GenericoViewModel.Factory),
   navController: NavHostController = rememberNavController()
) {
   //Intentar poner un Scaffold en cada pantalla
}