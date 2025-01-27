package com.example.plantillalocal.conexion

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.plantillalocal.dao.ClaseGenericaDao
import com.example.plantillalocal.modelo.ClaseGenerica

@Database(entities = [ClaseGenerica::class], version = 1, exportSchema = false)
abstract class BaseDeDatos : RoomDatabase() {
   abstract fun claseGenericaDao(): ClaseGenericaDao<ClaseGenerica>

   companion object {
      @Volatile
      private var Instance: BaseDeDatos? = null

      fun obtenerBaseDatos(context: Context): BaseDeDatos {
         return Instance ?: synchronized(this) {
            Room.databaseBuilder(context, BaseDeDatos::class.java, "basededatosgenericadb")
               .build()
               .also { Instance = it }
         }
      }
   }
}