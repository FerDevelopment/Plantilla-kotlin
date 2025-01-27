package com.example.plantillalocal

import android.app.Application
import com.example.plantillalocal.datos.ContenedorApp

class Aplicacion : Application() {
   lateinit var contenedor: ContenedorApp
   override fun onCreate() {
      super.onCreate()
      contenedor = ContenedorApp(this)
   }
}