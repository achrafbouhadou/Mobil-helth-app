package com.example.santedigital.Data.module

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.santedigital.Data.module.Motif
import java.util.*


@Entity
data class Visite(
    @PrimaryKey val IdVisite :Int,
    val date: Date,
    val cause:String,
    val service:String,
    val etat:String,
    val idPatient:Int,
    val MedcinId:Int,
    )
