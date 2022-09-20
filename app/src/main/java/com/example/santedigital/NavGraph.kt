package com.example.santedigital

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.santedigital.screens.*
import com.example.santedigital.ui.theme.ViewModel.realm.PatientSharedViewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    patientSharedViewModel : PatientSharedViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ListeDesVisite.route
    ){
        composable(
            route = Screen.ListeDesVisite.route
        ){
            VisiteScren(
                navController = navController
            )
        }
        composable(
            route = Screen.ListeDesMotifs.route
        ){
            DossierMedical()
        }
        composable(
            route = Screen.AddInformationPatient.route
        ){
            AddFirstScreen(
                navController = navController,
                patientSharedViewModel = patientSharedViewModel
            )
        }
        composable(
            route = Screen.AddInformationVisite.route
        ){
            AddSecondeScreen(
                navController = navController
            )
        }
        composable(
            route = Screen.PatientListScren.route
        ){
            PatientListScren(
                navController = navController,
                patientSharedViewModel = patientSharedViewModel
            )
        }
        composable(
            route = Screen.ProfilScreen.route,
            arguments = listOf(navArgument("idPatient") { type = NavType.IntType })
        ){
            val idPatient : Int? = it.arguments?.getInt("idPatient")
            ProfilScreen(
                navController = navController,
                patientSharedViewModel = patientSharedViewModel,
                id = idPatient,

            )
        }
    }
}