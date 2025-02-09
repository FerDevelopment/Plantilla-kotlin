package com.example.plantillalocalServidor.conexion

import com.example.plantillalocalServidor.modelo.ClaseGenericaServidor
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ServicioAPI {
   @GET("trabajadores")
   suspend fun obtenerEntidades(): List<ClaseGenericaServidor>

   @POST("trabajadores")
   suspend fun insertarEntidad(
      @Body trabajador: ClaseGenericaServidor
   ): ClaseGenericaServidor

   @PUT("trabajadores/{id}")
   suspend fun actualizarEntidad(
      @Path("id") id: String,
      @Body trabajador: ClaseGenericaServidor
   ): ClaseGenericaServidor

   @DELETE("trabajadores/{id}")
   suspend fun eliminarEntidad(
      @Path("id") id: String
   ): ClaseGenericaServidor
}