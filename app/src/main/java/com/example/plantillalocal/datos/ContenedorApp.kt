package com.example.plantillalocal.datos

import android.content.Context
import com.example.plantillalocal.conexion.BaseDeDatos

interface ContenedorAppIN {
   val productoRepositorio: ClaseGenericaRepositorio
}

class ContenedorApp(private val context: Context) : ContenedorAppIN {
   override val productoRepositorio: ClaseGenericaRepositorio by lazy {
      ConexionGenericaRepositorio(BaseDeDatos.obtenerBaseDatos(context).claseGenericaDao())
   }
}