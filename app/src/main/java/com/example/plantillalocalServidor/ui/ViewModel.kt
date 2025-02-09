package com.example.plantillalocalServidor.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.plantillalocalServidor.Aplicacion
import com.example.plantillalocalServidor.datos.RepositorioInterno
import com.example.plantillalocalServidor.datos.ServidorRepositorio
import com.example.plantillalocalServidor.modelo.ClaseGenerica
import com.example.plantillalocalServidor.modelo.ClaseGenericaServidor

sealed interface ServidorUIState {
   data class ObtenerExito(val entidad: List<ClaseGenericaServidor>) : ServidorUIState
   data class CrearExito(val entidad: ClaseGenericaServidor) : ServidorUIState
   data class ActualizarExito(val entidad: ClaseGenericaServidor) : ServidorUIState
   data class EliminarExito(val id: String) : ServidorUIState

   object Error : ServidorUIState
   object Cargando : ServidorUIState
}

sealed interface InternoUIState {
   data class ObtenerExito(val entidad: List<ClaseGenerica>) : InternoUIState
   data class CrearExito(val entidad: ClaseGenerica) : InternoUIState
   data class ActualizarExito(val entidad: ClaseGenerica) : InternoUIState
   data class EliminarExito(val id: String) : InternoUIState

   object Error : InternoUIState
   object Cargando : InternoUIState
}

class GenericoViewModel(private val servidorRepositorio: ServidorRepositorio,
                        private val internoRepositorio: RepositorioInterno
) : ViewModel() {



   companion object {
      val Factory: ViewModelProvider.Factory = viewModelFactory {
         initializer {
            val aplicacion = (this[APPLICATION_KEY] as Aplicacion)
            val servidorRepositorio = aplicacion.contenedor.servidorRepositorio
            val internoRepositorio = aplicacion.contenedor.internoRepositorio

            GenericoViewModel(
               servidorRepositorio = servidorRepositorio, internoRepositorio = internoRepositorio
            )
         }
      }
   }
}