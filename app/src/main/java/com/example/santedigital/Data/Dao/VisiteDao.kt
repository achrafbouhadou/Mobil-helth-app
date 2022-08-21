package com.example.santedigital.Data.Dao

import androidx.room.*

import com.example.santedigital.Data.module.Visite
import kotlinx.coroutines.flow.Flow

@Dao
interface VisiteDao {
    @Query("SELECT * FROM Visite ORDER BY IdVisite ASC")
    fun getAllVisite(): Flow<List<Visite>>



    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addVisite(visite: Visite)

    @Update
    suspend fun updateVisite(visite: Visite)

    @Delete
    suspend fun deleteVisite(visite: Visite)
}