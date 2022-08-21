package com.example.santedigital.Data.Dao

import androidx.room.*
import com.example.santedigital.Data.module.Motif
import com.example.santedigital.Data.module.Patient
import kotlinx.coroutines.flow.Flow

@Dao
interface MotifDao {
    @Query("SELECT * FROM Motif ORDER BY IdMotif ASC")
    fun getAllMotif(): Flow<List<Motif>>



    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMotif(motif: Motif)

    @Update
    suspend fun updatMotif(motif: Motif)

    @Delete
    suspend fun deleteMotif(motif: Motif)
}