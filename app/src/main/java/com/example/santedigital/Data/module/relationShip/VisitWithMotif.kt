package com.example.santedigital.Data.module.relationShip

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.santedigital.Data.module.Motif
import com.example.santedigital.Data.module.Visite

data class VisitWithMotif (
    @Embedded val visite: Visite,
    @Relation(
        parentColumn = "IdVisite",
        entityColumn = "IdMotif",
        associateBy = Junction(MotifVisitCrossRef::class)
    )
    val motif: List<Motif>
)