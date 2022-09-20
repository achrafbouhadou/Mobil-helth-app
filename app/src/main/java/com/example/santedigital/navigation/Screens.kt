package com.example.santedigital.navigation

import androidx.navigation.NavHostController
import com.example.santedigital.util.Action
import com.example.santedigital.util.CONSTANT.LISTE_PATIENT

class Screens(navHostController: NavHostController) {
    /// Liste des patien route
    val list : (Action) -> Unit = { action ->
        navHostController.navigate("liste/${action.name}"){
            popUpTo(LISTE_PATIENT){inclusive=true}
        }

    }
    ///  patien route
    val patient : (Int)-> Unit = { patientid ->
        navHostController.navigate("patient/$patientid")
    }
    ///  visite route
    val visite : (Int) -> Unit = { visiteId ->
        navHostController.navigate("visit/$visiteId")
    }
    /// Liste des visite route
    val listViste  = navHostController.navigate("visits")

    /// New visite + formation patient et visite formation

val addPateint = navHostController.navigate("add-patient")


}