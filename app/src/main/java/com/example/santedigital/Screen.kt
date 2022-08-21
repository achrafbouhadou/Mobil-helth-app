package com.example.santedigital

sealed class Screen(val route: String){
    object AddInformationPatient: Screen(route ="information_patient")
    object AddInformationVisite : Screen(route ="information_visite")
    object ListeDesVisite : Screen(route = "visite_screen")
    object ListeDesMotifs : Screen(route = "motif_screen")
    object PatientListScren : Screen(route = "patients_screen")
    object ProfilScreen : Screen(route = "profil_screen")
}
