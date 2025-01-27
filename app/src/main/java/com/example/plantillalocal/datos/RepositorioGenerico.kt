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
   override suspend fun insertar(producto: ClaseGenerica) = claseGenericaDao.insertar(producto)
   override suspend fun actualizar(producto: ClaseGenerica) = claseGenericaDao.actualizar(producto)
   override suspend fun eliminar(producto: ClaseGenerica) = claseGenericaDao.eliminar(producto)
}