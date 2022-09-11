package com.example.santedigital

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.santedigital.screens.*

@Composable
fun SetupNavGraph(
    navController: NavHostController
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
                navController = navController
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
                navController = navController
            )
        }
        composable(
            route = Screen.ProfilScreen.route
        ){
            ProfilScreen(
                navController = navController
            )
        }
    }
}