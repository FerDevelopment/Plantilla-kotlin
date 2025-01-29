package com.example.plantillalocal.datos

import com.example.plantillalocal.conexion.ServicioAPI
import com.example.plantillalocal.modelo.ClaseGenericaServidor

interface ServidorRepositorio {
   suspend fun obtenerEntidades(): List<ClaseGenericaServidor>
   suspend fun insertarEntidad(entidad: ClaseGenericaServidor): ClaseGenericaServidor
   suspend fun actualizarEntidad(id: String, entidad: ClaseGenericaServidor): ClaseGenericaServidor
   suspend fun eliminarEntidad(id: String): ClaseGenericaServidor
}

class ConexionRepositorioServidor(private val servicioAPI: ServicioAPI
) : ServidorRepositorio {
   override suspend fun obtenerEntidades(): List<ClaseGenericaServidor> =
           servicioAPI.obtenerEntidades()

   override suspend fun insertarEntidad(entidad: ClaseGenericaServidor): ClaseGenericaServidor =
           servicioAPI.insertarEntidad(entidad)

   override suspend fun actualizarEntidad(id: String, entidad: ClaseGenericaServidor
   ): ClaseGenericaServidor = servicioAPI.actualizarEntidad(id, entidad)

   override suspend fun eliminarEntidad(id: String): ClaseGenericaServidor =
           servicioAPI.eliminarEntidad(id)
}