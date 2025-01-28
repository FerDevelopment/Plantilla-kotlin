package com.example.plantillalocal.datos

import com.example.plantillalocal.dao.ClaseGenericaDao
import com.example.plantillalocal.modelo.ClaseGenerica

interface ClaseGenericaRepositorio {
   suspend fun insertar(entidad: ClaseGenerica)
   suspend fun actualizar(entidad: ClaseGenerica)
   suspend fun eliminar(entidad: ClaseGenerica)
}

class ConexionGenericaRepositorio(private val claseGenericaDao: ClaseGenericaDao<ClaseGenerica>
) : ClaseGenericaRepositorio {
   override suspend fun insertar(entidad: ClaseGenerica) = claseGenericaDao.insertar(entidad)
   override suspend fun actualizar(entidad: ClaseGenerica) = claseGenericaDao.actualizar(entidad)
   override suspend fun eliminar(entidad: ClaseGenerica) = claseGenericaDao.eliminar(entidad)
}