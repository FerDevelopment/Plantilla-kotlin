package com.example.plantillaLocalServidor.conexion

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.plantillaLocalServidor.dao.ClaseGenericaDao
import com.example.plantillaLocalServidor.modelo.ClaseGenerica

@Database(entities = [ClaseGenerica::class], version = 1, exportSchema = false)
abstract class BaseDeDatos : RoomDatabase() {
   abstract fun claseGenericaDao(): ClaseGenericaDao

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