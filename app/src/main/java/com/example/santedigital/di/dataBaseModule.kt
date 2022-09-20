package com.example.santedigital.di

import android.content.Context
import androidx.room.Room
import com.example.santedigital.Data.SanteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object dataBaseModule  {

    @Singleton
    @Provides
    fun provideDataBase(
        @ApplicationContext context: Context
    )  = Room.databaseBuilder(
        context,
        SanteDataBase::class.java,
        "sante_dataBase"
    ).build()

    @Singleton

    @Provides
    fun providePatientDao(dataBase: SanteDataBase) = dataBase.patientDao()

    @Singleton
    @Provides
    fun provideVisitDao(dataBase: SanteDataBase) = dataBase.visitDao()
}