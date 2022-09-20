package com.example.santedigital.Data.module.realm

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class Patient() : RealmObject {

    @PrimaryKey
    var _id: ObjectId = ObjectId.create()
    var idPatient:Int = 0
    var nom: String = "test"
    var prenom: String = "test"
    var sexe : String = "test"
    var telephone: String = "test"
    var situationFamil: String = "test"
    var origin: String = "test"
    var residance: String = "test"
    var profession: String = "test"
    var niveauSocioceonomique: String = "test"
    var couverture_medical:String = "test"

}
