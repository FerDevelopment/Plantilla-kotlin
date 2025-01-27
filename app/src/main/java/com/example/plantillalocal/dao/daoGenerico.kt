package com.example.plantillalocal.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
interface ClaseGenericaDao<T : Any> {
   @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insertar(entity: T)

   @Update
   suspend fun actualizar(entity: T)

   @Delete
   suspend fun eliminar(entity: T)
}