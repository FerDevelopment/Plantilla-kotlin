package com.example.plantillaLocalServidor

import android.app.Application
import com.example.plantillaLocalServidor.datos.ContenedorApp

class Aplicacion : Application() {
   lateinit var contenedor: ContenedorApp
   override fun onCreate() {
      super.onCreate()
      contenedor = ContenedorApp(this)
   }
}