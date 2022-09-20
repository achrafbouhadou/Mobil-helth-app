package com.example.santedigital.ui.theme.ViewModel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class syndromeSharedViewModel : ViewModel() {
    private val _syndrome = listOf(syndrome(1,"")).toMutableStateList()
    val syndrome:List<syndrome> = _syndrome

    fun addSyptom(syndrome: syndrome){
        _syndrome.add(syndrome)
    }
    fun removeSyptom(id: Int){
        _syndrome.removeAt(id)
    }
    fun getAllSyptom() : List<syndrome>{
        return syndrome
    }

}

data class syndrome(
    val id:Int ,
    val label : String,
)