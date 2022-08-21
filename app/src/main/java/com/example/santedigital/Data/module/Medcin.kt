package com.example.santedigital.Data.module

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Medcin(
    @PrimaryKey
    val MedcinId:Int,
    val Numatricule:String,
    val NomMedcin:String,
    val NameService:Int
)
