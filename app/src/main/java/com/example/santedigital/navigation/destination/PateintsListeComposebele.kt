package com.example.santedigital.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.santedigital.screens.PatientListScren
import com.example.santedigital.ui.theme.ViewModel.PatientSharedViewModel
import com.example.santedigital.util.CONSTANT.LISTE_PATIENT
import com.example.santedigital.util.CONSTANT.LISTE_PATIENT_ARRGUMENT_KEY

fun NavGraphBuilder.listPateintComposable(
    navigateToPatientScreen : (patientId : Int) -> Unit,
    sharedViewModel :PatientSharedViewModel
){
    composable(route = LISTE_PATIENT,
    arguments = listOf(navArgument(LISTE_PATIENT_ARRGUMENT_KEY){
        type= NavType.StringType
    })
    ){
//        PatientListScren()
    }
}
