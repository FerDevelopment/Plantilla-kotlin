package com.example.plantillaLocalServidor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.plantillaLocalServidor.pantallas.App
import com.example.plantillaLocalServidor.ui.theme.PlantillaLocalServidorTheme


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


