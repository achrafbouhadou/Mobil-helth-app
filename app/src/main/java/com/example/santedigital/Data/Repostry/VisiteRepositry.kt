package com.example.santedigital.Data.Repostry

import com.example.santedigital.Data.Dao.VisiteDao
import com.example.santedigital.Data.module.Visite
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Named

/*
@ViewModelScoped
class VisiteRepositry @Inject @Named("visit") constructor(
    private val visiteDao: VisiteDao
) {
    val getAllVisites : Flow<List<Visite>> = visiteDao.getAllVisite()
}

 */