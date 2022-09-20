package com.example.santedigital.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import com.example.santedigital.navigation.destination.listPateintComposable
import com.example.santedigital.navigation.destination.listvisiteComposable
import com.example.santedigital.navigation.destination.patientComposable
import com.example.santedigital.ui.theme.ViewModel.PatientSharedViewModel
import com.example.santedigital.ui.theme.ViewModel.visiteSharedViewModel
import com.example.santedigital.util.CONSTANT.LISTE_PATIENT

@Composable
fun NavigationSetup(
    navHostController: NavHostController,
    sharedViewModelPatient: PatientSharedViewModel,
    sharedViewModelVisite: visiteSharedViewModel
) {
    val screen = remember(navHostController){
        Screens(navHostController = navHostController)
    }
    NavHost(navController = navHostController, startDestination = LISTE_PATIENT)
    {
        listPateintComposable(
            navigateToPatientScreen = screen.patient,
            sharedViewModel = sharedViewModelPatient
        )
        patientComposable(
            navigateToListePatientScreen = screen.list,
            sharedViewModel = sharedViewModelPatient
        )
        listvisiteComposable(
            navigateToVisiteScreen = screen.visite,
            navigateToNewScreen= screen.addPateint,
            sharedViewModelPatient = sharedViewModelPatient,
            sharedViewModelVisite = sharedViewModelVisite,
        )
    }
}