package com.example.santedigital.ui.theme.ViewModel.realm

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope


import com.example.santedigital.Data.module.realm.Patient



import dagger.hilt.android.lifecycle.HiltViewModel
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.subscriptions
import io.realm.kotlin.mongodb.sync.SyncConfiguration
import io.realm.kotlin.query.RealmResults
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


class PatientSharedViewModel  : ViewModel() {

    val Nom: MutableState<String> = mutableStateOf("")
    val prenom: MutableState<String> = mutableStateOf("")
    val sexe: MutableState<String> = mutableStateOf("")
    val telephone: MutableState<String> = mutableStateOf("")
    val situationFamil: MutableState<String> = mutableStateOf("")
    val origin: MutableState<String> = mutableStateOf("")
    val residance: MutableState<String> = mutableStateOf("")
    val profession: MutableState<String> = mutableStateOf("")
    val niveauSocioceonomique: MutableState<String> = mutableStateOf("")
    val couverture_medical: MutableState<String> = mutableStateOf("")
    /*
    private val _allPatient = MutableStateFlow<List<Patient>>(emptyList())
    val allPatient : MutableStateFlow<List<Patient>>   = _allPatient
    val app = App.create("hops_sync_flex-ooedg")
    lateinit var realm: Realm
    fun getAllPatient(){
            runBlocking{

                val user = app.login(Credentials.anonymous())
                val config = SyncConfiguration.Builder(
                    user = user,
                    "crud",
                    schema = setOf(Patient::class)
                ).name("crud").build()
                realm = Realm.open(config)
                _allPatient.value= realm.query<Patient>().find()
            }
    }
    fun addPatient(){
       viewModelScope.launch {
           AddNewPatient()
       }
    }
  suspend fun AddNewPatient(){
    realm.writeBlocking {
        copyToRealm(Patient().apply {
            nom = Nom.value
            prenom = this@PatientSharedViewModel.prenom.value
            sexe = this@PatientSharedViewModel.sexe.value
            telephone = this@PatientSharedViewModel.telephone.value
            situationFamil = this@PatientSharedViewModel.situationFamil.value
            origin = this@PatientSharedViewModel.origin.value
            residance = this@PatientSharedViewModel.residance.value
            profession = this@PatientSharedViewModel.profession.value
            niveauSocioceonomique = this@PatientSharedViewModel.niveauSocioceonomique.value
            couverture_medical = this@PatientSharedViewModel.couverture_medical.value

        })
    }
}

     */

    private lateinit var realm: Realm
    private lateinit var config: SyncConfiguration
    val app = App.create("sante-degital-yulvg")
    private val _allPatient = MutableStateFlow<List<Patient>>(emptyList())
    private val _patient = MutableStateFlow<Patient>(Patient())
    val allPatient: MutableStateFlow<List<Patient>> = _allPatient
    val patient: MutableStateFlow<Patient> = _patient
    suspend fun onStart() {
        val app = App.create("sante-degital-yulvg")
// use constants for query names so you can edit or remove them later
        val NAME_QUERY = "NAME_QUERY"
        runBlocking {
            val user = app.login(Credentials.anonymous())
             config = SyncConfiguration.Builder(user, setOf(Patient::class))
                .initialSubscriptions { realm ->
                    add(
                        realm.query<Patient>(

                        ),
                        "subscription name"
                    )
                }
                .build()
            realm = Realm.open(config)
           _allPatient.value =  realm.query<Patient>().find()
        }
    }
 fun creatPatient() {
    realm = Realm.open(config)

        runBlocking {
            realm.write {
                // create a frog object in the realm
                val frog = this.copyToRealm(Patient().apply {
                    nom = this@PatientSharedViewModel.Nom.value
                    prenom = this@PatientSharedViewModel.Nom.value
                    sexe = this@PatientSharedViewModel.sexe.value
                    telephone = this@PatientSharedViewModel.telephone.value
                    situationFamil = this@PatientSharedViewModel.situationFamil.value
                    origin = this@PatientSharedViewModel.origin.value
                    residance = this@PatientSharedViewModel.residance.value
                    profession = this@PatientSharedViewModel.profession.value
                    niveauSocioceonomique = this@PatientSharedViewModel.niveauSocioceonomique.value
                    couverture_medical = this@PatientSharedViewModel.couverture_medical.value

                })

            }
        }


    }
     fun getPatientById(id : Int){
        realm = Realm.open(config)
         _patient.value  = realm.query<Patient>(query = "idPatient == $id").first().find()!!
    }
    fun  deletAll(){
        realm = Realm.open(config)
        runBlocking {
            realm.write {
                // fetch all frogs from the realm
                val Patients: RealmResults<Patient> = this.query<Patient>().find()
                // call delete on the results of a query to delete those objects permanently
                delete(Patients)
            }
        }
    }
}