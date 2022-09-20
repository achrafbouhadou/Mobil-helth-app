package com.example.santedigital.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.ArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.santedigital.Data.Repostry.PatientRepositry
import com.example.santedigital.Data.module.realm.Patient
import com.example.santedigital.Screen
import com.example.santedigital.ui.theme.Purple200
import com.example.santedigital.ui.theme.Purple500
import com.example.santedigital.ui.theme.Teal200
import com.example.santedigital.ui.theme.ViewModel.realm.PatientSharedViewModel

import com.example.santedigital.ui.theme.gilroyFont
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

@Composable
fun PatientListScren(
    navController: NavController,
    patientSharedViewModel: PatientSharedViewModel
) {
LaunchedEffect(key1 = true){
    patientSharedViewModel.onStart()
}
   val patientsize = patientSharedViewModel.allPatient.collectAsState().value.size
    val allpatient by patientSharedViewModel.allPatient.collectAsState()


    Box(modifier = Modifier
        .fillMaxSize()
        .background(Purple200)) {
        Column() {

            InputIcon(label = "search", hint = "Recherche...")
            titleVisite(title = "Liste des patients $patientsize")

            Column(modifier = Modifier
                .fillMaxSize()) {
                patientListeLazy(patients =allpatient , navController =navController )
            }
        }
    }

}

@Composable
fun titleVisite(
    title:String
) {
    Text(
        text = "$title",
        modifier = Modifier.padding(15.dp),
        fontSize = 30.sp,
        fontFamily = gilroyFont,
        fontWeight = FontWeight.Bold

    )
}

@Composable
fun PatientListes(
    navController: NavController
) {
    var extendble by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (extendble) 180f else 0f
    )
    Card(modifier = Modifier
        .padding(12.dp)
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearOutSlowInEasing
            )
        )
        .clickable {
            extendble = !extendble
        }, shape = RoundedCornerShape(20.dp)) {

        Column() {
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Icon( Icons.Rounded.AccountCircle,
                    contentDescription = "patient Image",
                    modifier = Modifier
                        .size(55.dp)
                        .padding(end = 10.dp),
                    tint = Teal200
                )
                Text(text = "Achraf Bouhadou",
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Bold)
                Text(text = "Morocco1236",
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal)

                IconButton(onClick = {
                    extendble = !extendble
                }, modifier = Modifier
                    .alpha(ContentAlpha.medium)
                    .rotate(rotationState),


                    ) {
                    Icon(imageVector = Icons.Default.ArrowDropDown , contentDescription = "show deatails")
                }
            }
            if (extendble){
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()) {
                    latesTest(label = "Glucose", test ="1.44 g" )
                    latesTest(label = "Po2", test ="98" )
                    latesTest(label = "Tension", test ="145" )

                }
                Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable{
                        navController.navigate(route = Screen.ProfilScreen.route)
                    }) {
                        Text(text = "voire le profil",
                            fontFamily = gilroyFont,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                            color = Purple500
                        )
                        Icon(Icons.Rounded.ArrowForward,
                            contentDescription ="voire le profile" ,
                            tint = Purple500)

                    }

                }
            }
        }


    }

}

@Composable
fun latesTest(
    label:String,
    test:String,
) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(text = "$label",
            fontFamily = gilroyFont,
            fontSize = 20.sp,


            fontWeight = FontWeight.Bold,

            )
        Text(text = "$test",
            fontFamily = gilroyFont,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal)
    }
}

@Composable
fun patientListeLazy(
    patients : List<Patient>,
    navController: NavController
) {
    Column() {
        LazyColumn(){
            items(patients){ patient ->
                var extendble by remember {
                    mutableStateOf(false)
                }
                val rotationState by animateFloatAsState(
                    targetValue = if (extendble) 180f else 0f
                )
                Card(modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(
                            durationMillis = 300,
                            easing = LinearOutSlowInEasing
                        )
                    )
                    .clickable {
                        extendble = !extendble
                    }, shape = RoundedCornerShape(20.dp)) {

                    Column() {
                        Row(horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                            Icon( Icons.Rounded.AccountCircle,
                                contentDescription = "patient Image",
                                modifier = Modifier
                                    .size(55.dp)
                                    .padding(end = 10.dp),
                                tint = Teal200
                            )
                            Text(text = "${patient.prenom} ${patient.nom}",
                                fontFamily = gilroyFont,
                                fontWeight = FontWeight.Bold)
                            Text(text = "${patient.idPatient}",
                                fontFamily = gilroyFont,
                                fontWeight = FontWeight.Normal)

                            IconButton(onClick = {
                                extendble = !extendble
                            }, modifier = Modifier
                                .alpha(ContentAlpha.medium)
                                .rotate(rotationState),


                                ) {
                                Icon(imageVector = Icons.Default.ArrowDropDown , contentDescription = "show deatails")
                            }
                        }
                        if (extendble){
                            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth()) {
                                latesTest(label = "Glucose", test ="1.44 g" )
                                latesTest(label = "Po2", test ="98" )
                                latesTest(label = "Tension", test ="145" )

                            }
                            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable{
                                    navController.navigate(route = "profil_screen/"+patient.idPatient.toInt())
                                }) {
                                    Text(text = "voire le profil",
                                        fontFamily = gilroyFont,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Normal,
                                        color = Purple500
                                    )
                                    Icon(Icons.Rounded.ArrowForward,
                                        contentDescription ="voire le profile" ,
                                        tint = Purple500)

                                }

                            }
                        }
                    }


                }
            }
        }
    }
}
