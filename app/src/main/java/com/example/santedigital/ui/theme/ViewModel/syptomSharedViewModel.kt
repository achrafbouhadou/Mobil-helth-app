package com.example.santedigital.ui.theme.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

abstract class IMyViewModel  : ViewModel(){

}

class syptomSharedViewModel : ViewModel() {
    private val _syptoms = listOf(Syptom(1,"")).toMutableStateList()
    val syptoms:List<Syptom> = _syptoms

    fun addSyptom(syptom: Syptom){
        _syptoms.add(syptom)
    }
    fun removeSyptom(id: Int){
        _syptoms.removeAt(id)
    }
    fun getAllSyptom() : List<Syptom>{
        return syptoms
    }

}

data class Syptom(
    val id:Int ,
    val label : String,
)