package com.example.santedigital

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Group
import androidx.compose.material.icons.rounded.Vaccines
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.santedigital.NavigationDrawer.AppBar
import com.example.santedigital.NavigationDrawer.DrawerBody
import com.example.santedigital.NavigationDrawer.DrawerHeader
import com.example.santedigital.NavigationDrawer.NavigationItheme
import com.example.santedigital.ui.theme.SanteDigitalTheme
import com.example.santedigital.ui.theme.ViewModel.realm.PatientSharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val patientSharedViewModel : PatientSharedViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SanteDigitalTheme {
                

                navController = rememberNavController()
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
                                    "Patients" ->  navController.navigate(route = Screen.PatientListScren.route)
                                    "visites" -> navController.navigate(route = Screen.ListeDesVisite.route)
                                }
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                }
                            }
                        )
                    },

                    ) {
                    SetupNavGraph(navController =navController ,patientSharedViewModel = patientSharedViewModel)
                }


            }
        }
    }
}



