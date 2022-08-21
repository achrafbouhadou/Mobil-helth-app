package com.example.santedigital.Data.module.relationShip

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = ["IdMotif", "IdVisite"])
data class MotifVisitCrossRef(
    val IdMotif:Int,
    val IdVisite:Int,
)
