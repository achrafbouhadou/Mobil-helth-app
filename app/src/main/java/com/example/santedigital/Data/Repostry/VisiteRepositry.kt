package com.example.santedigital.Data.Repostry



import com.example.santedigital.Data.Dao.VisiteDao
import com.example.santedigital.Data.module.Visite
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Named


@ViewModelScoped
class VisiteRepositry
    @Inject
    constructor(
    private val visiteDao: VisiteDao
) {
    val getAllVisites : Flow<List<Visite>> = visiteDao.getAllVisite()

    fun getVisite (visitId : Int) : Flow<Visite> {
        return visiteDao.getVisite(idVisite = visitId)
    }
}



