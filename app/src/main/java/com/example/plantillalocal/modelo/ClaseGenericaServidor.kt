package com.example.plantillalocal.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClaseGenericaServidor(
        @SerialName(value = "id")
        val id : String = ""
                                )
