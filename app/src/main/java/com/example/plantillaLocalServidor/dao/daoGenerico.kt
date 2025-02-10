package com.example.plantillaLocalServidor.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.plantillaLocalServidor.modelo.ClaseGenerica

@Dao
interface ClaseGenericaDao {
   @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insertar(entity: ClaseGenerica)

   @Update
   suspend fun actualizar(entity: ClaseGenerica)

   @Delete
   suspend fun eliminar(entity: ClaseGenerica)
}