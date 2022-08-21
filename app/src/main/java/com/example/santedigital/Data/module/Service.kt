package com.example.santedigital.Data.module

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Service(
    @PrimaryKey
    val IdService:Int,
    val NameService:String,
)
