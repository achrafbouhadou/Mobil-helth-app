package com.example.santedigital.Data.module

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Motif(
    @PrimaryKey val IdMotif :Int,
    val motif:String,
    val localisation:String,
    val histoire:String
)
