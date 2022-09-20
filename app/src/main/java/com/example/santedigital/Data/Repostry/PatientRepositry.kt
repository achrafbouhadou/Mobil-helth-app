package com.example.santedigital.Data.Repostry


import com.example.santedigital.Data.Dao.PatientDao

import com.example.santedigital.Data.module.Patient
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Named


@ViewModelScoped
class PatientRepositry @Inject  constructor(
    private val patientDao: PatientDao
) {
    val getAllPatients : Flow<List<Patient>> = patientDao.getAllPatient()
    fun getPatient (patientId : Int) : Flow<Patient> {
        return patientDao.getPatient(idPatient = patientId)
    }
}

