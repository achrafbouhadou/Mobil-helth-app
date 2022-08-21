package com.example.santedigital.Data.module.relationShip

import androidx.room.Embedded

import androidx.room.Relation
import com.example.santedigital.Data.module.Medcin
import com.example.santedigital.Data.module.Visite

data class MedcinWithVisite(
    @Embedded val medcin: Medcin,
    @Relation(
        parentColumn = "MedcinId",
        entityColumn = "MedcinId"
    )
    val visite: List<Visite>
)
