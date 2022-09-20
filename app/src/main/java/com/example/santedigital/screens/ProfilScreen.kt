package com.example.santedigital.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.santedigital.Data.module.realm.Patient
import com.example.santedigital.Screen
import com.example.santedigital.ui.theme.Purple200
import com.example.santedigital.ui.theme.Purple500
import com.example.santedigital.ui.theme.Teal200
import com.example.santedigital.ui.theme.ViewModel.realm.PatientSharedViewModel
import com.example.santedigital.ui.theme.gilroyFont

@Composable
fun ProfilScreen(
    navController: NavController,
    patientSharedViewModel: PatientSharedViewModel,
    id : Int?
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Purple200)) {
        Column {
            LaunchedEffect(key1 = true ){
                if (id != null) {
                    patientSharedViewModel.getPatientById(id)
                }
            }
            val patient by patientSharedViewModel.patient.collectAsState()
            titleVisite(title = "Profile")
            ProfilNom(label = "${patient.prenom} ${patient.nom}", id = "${patient.idPatient}",navController=navController)
            detailPationt(patient = patient)
            fishierPationt()
            visiteListe()

        }
    }
}

@Composable
fun ProfilNom(
    label: String,
    id:String,
    navController: NavController,
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {


        Column() {
            Text(text = "$label",
                fontFamily = gilroyFont,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Text(text = "ID : $id",
                fontFamily = gilroyFont,
                fontWeight = FontWeight.Light,
                fontSize = 20.sp
            )

        }
        Button(onClick = {
            navController.navigate(route = Screen.AddInformationVisite.route)
        },
            modifier = Modifier
                .height(60.dp)
                .padding(5.dp)
            ,
            shape = RoundedCornerShape(10.dp),
            elevation =  ButtonDefaults.elevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            ), colors = ButtonDefaults.buttonColors(Purple500)) {
            Text(text = "Nouvelle Visite", color = Color.White, fontSize = 15.sp,  fontFamily = gilroyFont,
                fontWeight = FontWeight.Normal,)
        }
    }
}
@Composable
fun detailPationt(
patient: Patient
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
        }, shape = RoundedCornerShape(20.dp)
    ) {

        Column() {
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Row() {
                    Icon(Icons.Rounded.PermIdentity, contentDescription ="information", modifier = Modifier.padding(start = 10.dp) )
                    Text(text = "Informations",
                        fontFamily = gilroyFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }

                IconButton(onClick = {
                    extendble = !extendble
                }, modifier = Modifier
                    .alpha(ContentAlpha.medium)
                    .rotate(rotationState),


                    ) {
                    Icon(imageVector = Icons.Default.ArrowDropDown ,
                        contentDescription = "show deatails")
                }
            }
            if (extendble){
                Column(modifier = Modifier
                    .height(300.dp)
                    .verticalScroll(rememberScrollState())) {


                    InputEdit(label = "${patient.nom}", labele = "Nom", maxLength = 101)
                    InputEdit(label = "${patient.prenom} ", labele = "Prénom", maxLength = 101)
                    InputEdit(label = "${patient.telephone}", labele = "téléphone", maxLength = 101)
                    InputEdit(label = "${patient.origin}", labele = "origine", maxLength = 101)
                    InputEdit(label = "${patient.residance}", labele = "place de résidence", maxLength = 101)
                    InputEdit(label = "${patient.profession}", labele = "profession", maxLength = 101)
                    InputEdit(label = "${patient.couverture_medical}", labele = "couverture médicale", maxLength = 101)
                    Column(modifier = Modifier.padding(start = 20.dp)) {
                        /*
                        SexeSection(
                            sexe = listOf("Mr", "Mme"), label = "Sexe"
                        )
                        SexeSection(
                            sexe = listOf("marié", "célibataire", "divorcé"), label = "Situation familiale"
                        )
                        SexeSection(
                            sexe = listOf("Bas", "Bon"), label = "Niveau socioéconomique"
                        )

                         */
                    }
                }
                Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.End) {
                    TopSave()
                }
            }

        }
    }


}

@Composable
fun InputEdit(
    label:String,
    labele:String,
    maxLength:Int,
) {
    var label by remember { mutableStateOf("$label") }
    val maxLength = maxLength
    val lightBlue = Color(0xffd8e6ff)
    val blue = Purple500
    Text(
        text = "$labele",
        fontSize = 17.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp, start = 20.dp),
        textAlign = TextAlign.Start,
        color = blue
    )
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 25.dp),
        value = label,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = lightBlue,
            cursorColor = Color.Black,
            disabledLabelColor = lightBlue,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
            ,
        ),
        onValueChange = {
            if (it.length <= maxLength) label = it
        },
        shape = RoundedCornerShape(8.dp),
        singleLine = true,
        trailingIcon = {
            if (label.isNotEmpty()) {
                IconButton(onClick = { label = "" }) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = null
                    )
                }
            }
        }
    )
    Text(
        text = "${label.length} / $maxLength",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, end = 25.dp, bottom = 5.dp),
        textAlign = TextAlign.End,
        color = blue
    )

}
@Composable
fun fishierPationt(

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
        }, shape = RoundedCornerShape(20.dp)
    ) {

        Column() {
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Row() {
                    Icon(Icons.Rounded.AttachFile, contentDescription ="information", modifier = Modifier.padding(start = 10.dp) )
                    Text(text = "File/Document",
                        fontFamily = gilroyFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }

                IconButton(onClick = {
                    extendble = !extendble
                }, modifier = Modifier
                    .alpha(ContentAlpha.medium)
                    .rotate(rotationState),


                    ) {
                    Icon(imageVector = Icons.Default.ArrowDropDown ,
                        contentDescription = "show deatails",)
                }
            }
            if (extendble){
                Column(modifier = Modifier.verticalScroll(rememberScrollState())){
                    Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.End) {
                        Row() {
                            Icon(Icons.Rounded.UploadFile, contentDescription ="uploiade files", tint = Purple500)
                            Text(text = "Ajouter un fishier",
                                fontFamily = gilroyFont,
                                fontWeight = FontWeight.Light,
                                fontSize = 20.sp,
                                color = Purple500,
                                modifier = Modifier.padding(start = 5.dp, end = 20.dp , bottom = 20.dp)
                            )
                        }
                    }
                    files(test = "Blod test")
                    files(test = "Glucose test")
                    files(test = "Tension test")
                }
            }
        }


    }

}

@Composable
fun files(
    test:String,
) {
    Row(modifier = Modifier
        .padding(vertical = 10.dp, horizontal = 20.dp)
        .border(
            width = 1.dp, shape = RoundedCornerShape(8.dp),
            color = Color.Gray
        )){
        Row(modifier = Modifier.padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically){
            Icon(Icons.Rounded.FilePresent, contentDescription ="file present",
                modifier = Modifier
                    .alpha(ContentAlpha.medium)
                    .padding(horizontal = 12.dp)
                    .size(40.dp))
            Text(text = "Blood test",
                fontFamily = gilroyFont,
                fontWeight = FontWeight.Light,
                fontSize = 20.sp,
                modifier = Modifier.weight(5f)
            )
            Icon(Icons.Rounded.FileDownload, contentDescription ="file present",
                modifier = Modifier.alpha(ContentAlpha.medium) )
            Icon(Icons.Rounded.Delete, contentDescription ="file present",
                modifier = Modifier
                    .alpha(ContentAlpha.medium)
                    .padding(end = 12.dp) )
        }
    }

}

@Composable
fun visiteListe() {

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
        }, shape = RoundedCornerShape(20.dp)
    ) {

        Column() {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()
            ) {
                Row() {
                    Icon(
                        Icons.Rounded.FormatListBulleted,
                        contentDescription = "information",
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Text(
                        text = "Les visites",
                        fontFamily = gilroyFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }

                IconButton(
                    onClick = {
                        extendble = !extendble
                    },
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationState),


                    ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "show deatails",
                    )
                }
            }
            visteDetails(id = "123344", date = "fev 12 2021")
            visteDetails(id = "45454", date = "mar 05 2021")
            visteDetails(id = "545454", date = "dec 08 2021")
            visteDetails(id = "88486", date = "sep 08 2022")
        }
    }
}

@Composable
fun visteDetails(
    id:String,
    date:String,
) {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)) {
        Text(text = "$id",
            fontFamily = gilroyFont,
            fontWeight = FontWeight.Light,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
        Text(text = "$date",
            fontFamily = gilroyFont,
            fontWeight = FontWeight.Light,
            fontSize = 20.sp,
            modifier = Modifier
        )

        Text(text = "Details",
            fontFamily = gilroyFont,
            fontWeight = FontWeight.Light,
            fontSize = 20.sp,
            color = Purple500,
            modifier = Modifier.padding(end = 5.dp ))



    }
}
