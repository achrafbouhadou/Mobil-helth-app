package com.example.santedigital.Data.Dao

import androidx.room.*
import com.example.santedigital.Data.module.Patient
import kotlinx.coroutines.flow.Flow

@Dao
interface PatientDao {
    @Query("SELECT * FROM Patient ORDER BY idPatient ASC")
    fun getAllPatient(): Flow<List<Patient>>

    @Query("SELECT * FROM Patient WHERE idPatient = :idPatient")
    fun getPatient(idPatient: Int): Flow<Patient>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPatient(patient: Patient)

    @Update
    suspend fun updatPatient(patient: Patient)

    @Delete
    suspend fun deletePatient(patient: Patient)
}