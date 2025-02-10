package com.example.plantillaLocalServidor.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ClaseGenerica")
data class ClaseGenerica(
        @PrimaryKey(autoGenerate = true)
        val id : Int,
        val nombre: String,
        val correo: String
                        )
