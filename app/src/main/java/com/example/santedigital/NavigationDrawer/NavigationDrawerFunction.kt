package com.example.santedigital.NavigationDrawer

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Group
import androidx.compose.material.icons.rounded.Vaccines
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import com.example.santedigital.Screen
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawerFunction(
    navController: NavController
) {


val scaffoldState = rememberScaffoldState()
val scope = rememberCoroutineScope()
Scaffold(
scaffoldState = scaffoldState,
topBar = {
    AppBar(
        onNavigationIconClick = {
            scope.launch {
                scaffoldState.drawerState.open()
            }
        },
        Nom = "Achraf Bouhadou",
        Id = "Moro13158984978"
    )
},
drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
drawerContent = {
    DrawerHeader()
    DrawerBody(
        items = listOf(
            NavigationItheme(
                title = "Liste des Patient",
                icon = Icons.Rounded.Group,
                id = "Patients",
                ContentDescription = "listes des Patient"
            ),
            NavigationItheme(
                title = "Liste des Visites",
                icon = Icons.Rounded.Vaccines,
                id = "visites",
                ContentDescription = "listes des visites"
            ),

            ),
        onItemClick = {
            when(it.id){
                "Patients" ->  navController.navigate(route = Screen.AddInformationPatient.route)
                else -> navController.navigate(route = Screen.AddInformationPatient.route)
            }
        }
    )
},

) {

}
}