package com.example.santedigital.Data.module

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Patient(
    @PrimaryKey
    val idPatient:Int,
    val nom: String,
    val prenom: String,
    val sexe : String,
    val telephone: String,
    val situationFamil: String,
    val origin: String,
    val residance: String,
    val profession: String,
    val niveauSocioceonomique: String,
    val couverture_medical:String,

)