package com.example.santedigital.ui.theme.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.santedigital.Data.Repostry.PatientRepositry
import com.example.santedigital.Data.module.Patient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PatientSharedViewModel @Inject constructor(
    private val repositry: PatientRepositry
) : ViewModel() {
    private val _allPatient = MutableStateFlow<List<Patient>>(emptyList())
    val allPatient : StateFlow<List<Patient>> = _allPatient
    fun getAllPatient(){
        viewModelScope.launch {
            repositry.getAllPatients.collect{
                _allPatient.value = it
            }
        }
    }

    private  val _patient = MutableStateFlow<Patient?>(null)
    val patient : StateFlow<Patient?> = _patient
    fun getSelectedPatient(patienId : Int){
        viewModelScope.launch {
            repositry.getPatient(patienId).collect{ patient ->
                _patient.value = patient

            }
        }
    }
}