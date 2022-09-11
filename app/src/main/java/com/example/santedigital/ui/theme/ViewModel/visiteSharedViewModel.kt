package com.example.santedigital.ui.theme.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.santedigital.Data.Repostry.VisiteRepositry
import com.example.santedigital.Data.module.Patient
import com.example.santedigital.Data.module.Visite
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class visiteSharedViewModel  @Inject constructor(
    private val repositry: VisiteRepositry
) : ViewModel() {
    private val _visites = MutableStateFlow<List<Visite>>(emptyList())
    val allVisite : StateFlow<List<Visite>> = _visites
    fun getAllVisites(){
        viewModelScope.launch {
            repositry.getAllVisites.collect{
                _visites.value = it
            }
        }
    }

    private  val _visite = MutableStateFlow<Visite?>(null)
    val visite : StateFlow<Visite?> = _visite
    fun getSelectedVisite(visiteId : Int){
        viewModelScope.launch {
            repositry.getVisite(visiteId).collect{ visite ->
                _visite.value = visite

            }
        }
    }
}


