package com.example.santedigital.viewModels

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class MotifViewModels:ViewModel() {
    private val _motifs = listOf(Motiftest("")).toMutableStateList()
    val motifs : List<Motiftest>
        get() = _motifs

    fun addmotif(motif: Motiftest){
        _motifs.add(motif)
    }
    fun removemotif(motif: Motiftest){
        _motifs.remove(motif)
    }
}
