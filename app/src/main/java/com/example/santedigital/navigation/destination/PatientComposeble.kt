package com.example.santedigital.navigation.destination

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.santedigital.screens.ProfilScreen
import com.example.santedigital.ui.theme.ViewModel.PatientSharedViewModel
import com.example.santedigital.util.Action
import com.example.santedigital.util.CONSTANT.PATIENT_SCREN
import com.example.santedigital.util.CONSTANT.PATIENT_SCREN_ARRGUMENT_KEY
import kotlinx.coroutines.flow.collect

fun NavGraphBuilder.patientComposable(
    sharedViewModel: PatientSharedViewModel,
    navigateToListePatientScreen : (Action) -> Unit
){
    composable(
        route = PATIENT_SCREN,
        arguments = listOf(navArgument(PATIENT_SCREN_ARRGUMENT_KEY){
            type = NavType.IntType
        })
    ) {
    }
}