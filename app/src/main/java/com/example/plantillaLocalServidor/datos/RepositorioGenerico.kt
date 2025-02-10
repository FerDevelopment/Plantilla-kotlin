package com.example.plantillaLocalServidor.datos

import com.example.plantillaLocalServidor.dao.ClaseGenericaDao
import com.example.plantillaLocalServidor.modelo.ClaseGenerica

interface RepositorioInterno {
   suspend fun insertar(entidad: ClaseGenerica)
   suspend fun actualizar(entidad: ClaseGenerica)
   suspend fun eliminar(entidad: ClaseGenerica)
}

class ConexionGenericaRepositorioInterno(private val claseGenericaDao: ClaseGenericaDao
) : RepositorioInterno {
   override suspend fun insertar(entidad: ClaseGenerica) = claseGenericaDao.insertar(entidad)
   override suspend fun actualizar(entidad: ClaseGenerica) = claseGenericaDao.actualizar(entidad)
   override suspend fun eliminar(entidad: ClaseGenerica) = claseGenericaDao.eliminar(entidad)
}