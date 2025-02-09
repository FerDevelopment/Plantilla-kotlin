package com.example.plantillalocalServidor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.plantillalocalServidor.pantallas.App
import com.example.plantillalocalServidor.ui.theme.PlantillaLocalServidorTheme


class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      enableEdgeToEdge()
      setContent {
         PlantillaLocalServidorTheme {
         App()
         }
      }
   }
}


