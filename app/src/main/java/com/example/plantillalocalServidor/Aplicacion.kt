package com.example.plantillalocalServidor

import android.app.Application
import com.example.plantillalocalServidor.datos.ContenedorApp

class Aplicacion : Application() {
   lateinit var contenedor: ContenedorApp
   override fun onCreate() {
      super.onCreate()
      contenedor = ContenedorApp(this)
   }
}