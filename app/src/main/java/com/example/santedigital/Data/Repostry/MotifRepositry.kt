package com.example.santedigital.Data.Repostry

import com.example.santedigital.Data.Dao.MotifDao
import com.example.santedigital.Data.module.Motif
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Named

/*
@ViewModelScoped
class MotifRepositry @Inject @Named("motif") constructor(
    private val motifDao : MotifDao
) {
    val getAllMotif : Flow<List<Motif>> = motifDao.getAllMotif()
}

 */