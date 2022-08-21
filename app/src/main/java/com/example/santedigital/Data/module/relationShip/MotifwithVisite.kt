package com.example.santedigital.Data.module.relationShip

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.santedigital.Data.module.Motif
import com.example.santedigital.Data.module.Visite


data class MotifwithVisite (
    @Embedded val motif: Motif,
    @Relation(
        parentColumn = "IdMotif",
        entityColumn = "IdVisite",
        associateBy = Junction(MotifVisitCrossRef::class)
                            )
    val visite: List<Visite>
    )