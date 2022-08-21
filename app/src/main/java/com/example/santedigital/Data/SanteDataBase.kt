package com.example.santedigital.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.santedigital.Data.Converter.Converters
import com.example.santedigital.Data.Dao.MotifDao
import com.example.santedigital.Data.Dao.PatientDao
import com.example.santedigital.Data.Dao.VisiteDao
import com.example.santedigital.Data.module.Medcin
import com.example.santedigital.Data.module.Motif
import com.example.santedigital.Data.module.Patient
import com.example.santedigital.Data.module.Visite
import com.example.santedigital.Data.module.relationShip.MotifVisitCrossRef

@Database(entities = [Patient::class,
    Visite::class,Motif::class, Medcin::class,
   MotifVisitCrossRef::class],
    version =1, exportSchema = false )
@TypeConverters(Converters::class)
abstract class SanteDataBase:RoomDatabase() {
    abstract fun patientDao(): PatientDao
    abstract fun visitDao(): VisiteDao
    abstract fun motifDao(): MotifDao
}