package com.example.santedigital.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.santedigital.screens.PatientListScren
import com.example.santedigital.ui.theme.ViewModel.PatientSharedViewModel
import com.example.santedigital.ui.theme.ViewModel.visiteSharedViewModel
import com.example.santedigital.util.CONSTANT

fun NavGraphBuilder.listvisiteComposable(
    navigateToVisiteScreen : (visiteId : Int) -> Unit,
    navigateToNewScreen: Unit ,
    sharedViewModelVisite : visiteSharedViewModel,
    sharedViewModelPatient : PatientSharedViewModel,
){
    composable(route = CONSTANT.LISTE_PATIENT,
        arguments = listOf(navArgument(CONSTANT.LISTE_PATIENT_ARRGUMENT_KEY){
            type= NavType.StringType
        })
    ){

    }
}