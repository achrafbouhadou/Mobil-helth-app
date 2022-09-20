package com.example.santedigital.screens

import android.net.RouteInfo
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.santedigital.R
import com.example.santedigital.Screen
import com.example.santedigital.ui.theme.*
import com.example.santedigital.ui.theme.ViewModel.realm.PatientSharedViewModel


@Composable
fun AddFirstScreen(
    navController: NavController,
    patientSharedViewModel: PatientSharedViewModel
) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Purple200)){
        }
    Column() {
        NavigationButton()
        TopTitle("Nouveau visite")
        Avencement()
        FromFields("Patient details",navController = navController,patientSharedViewModel = patientSharedViewModel)
    }

}
@Composable
fun NavigationButton() {
    Row(modifier = Modifier

        .fillMaxWidth()
        .padding(bottom = 10.dp, start = 20.dp, end = 20.dp, top = 20.dp) ,
        horizontalArrangement = Arrangement.SpaceBetween) {
       Icon(Icons.Rounded.ArrowBack,
           contentDescription = "Back",
           modifier = Modifier.size(30.dp),
            )
       Icon(Icons.Rounded.Close,
           contentDescription = "Close",
           modifier = Modifier.size(30.dp),
            )
    }
}

@Composable
fun TopTitle(
    title:String
) {
    Text(text = "$title",
        fontFamily = gilroyFont,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp,
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp))

}

@Composable
fun Avencement() {
    val shape = RoundedCornerShape(12.dp)
    Row(modifier = Modifier
        .padding(bottom = 10.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
        Column(modifier = Modifier.padding(end = 40.dp ),horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Patient details",
                color = Purple500,
                fontFamily = gilroyFont,
                fontWeight = FontWeight.Bold)
            Box(
                modifier = Modifier
                    .width(90.dp)
                    .padding(top = 8.dp)
                    .height(6.dp)
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Purple500)
                    .clip(CircleShape)
            )

        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(text = "Visite details",
                    color = Color.Gray,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Bold)
            Box(
                modifier = Modifier
                    .width(90.dp)
                    .padding(top = 8.dp)
                    .height(6.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(color = Color.Gray)
            )


        }

    }
    
}

@Composable
fun FromFields(
    title:String,
    navController: NavController,
    patientSharedViewModel: PatientSharedViewModel
) {

    val nom by patientSharedViewModel.Nom
    val prenom by patientSharedViewModel.prenom
    val sexe by patientSharedViewModel.sexe
    val telephone by patientSharedViewModel.telephone
    val situationFamil by patientSharedViewModel.situationFamil
    val origin by patientSharedViewModel.origin
    val residance by patientSharedViewModel.residance
    val profession by patientSharedViewModel.profession
    val niveauSocioceonomique by patientSharedViewModel.niveauSocioceonomique
    val couverture_medical by patientSharedViewModel.couverture_medical

    Card(modifier = Modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
        .background(color = Color.White)) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
           ) {
            Text(text = "$title",
                fontFamily = gilroyFont,
                fontWeight = FontWeight.Normal,
                fontSize = 30.sp,
                modifier = Modifier.padding(20.dp))

            Column(modifier = Modifier .verticalScroll(rememberScrollState())) {
                Input(onValueChange = {patientSharedViewModel.Nom.value = it},nom,"Nom",110)
                Input(onValueChange = {patientSharedViewModel.prenom.value = it},prenom,"Prénom",110)
                InputPhone(onValueChange = {patientSharedViewModel.telephone.value  = it},telephone,"téléphone",10)
                Input(onValueChange = {patientSharedViewModel.origin.value = it},origin,"origine",110)
                Input(onValueChange = {patientSharedViewModel.residance.value = it},residance,"place de résidence",200)
                Input(onValueChange = {patientSharedViewModel.profession.value = it},profession,"profession",110)
                Input(onValueChange = {patientSharedViewModel.couverture_medical.value = it},couverture_medical,"couverture médicale ",110)

                SexeSection(
                    sexe = listOf("Mr", "Mme"),label="Sexe", OnSelectedItem = {patientSharedViewModel.sexe.value = it}
                )
                SexeSection(
                    sexe = listOf("marié", "célibataire","divorcé"),label="Situation familiale",OnSelectedItem = {patientSharedViewModel.situationFamil.value = it}
                )
                SexeSection(
                    sexe = listOf("Bas","Bon"),label="Niveau socioéconomique",OnSelectedItem = {patientSharedViewModel.niveauSocioceonomique.value = it}
                )
                ButtonNext(patientSharedViewModel = patientSharedViewModel,"Suivant",navController = navController,Screen.AddInformationVisite.route,)
            }


        }
    }
}

@Composable
fun Input(
    onValueChange : (String) -> Unit,
    title:String,
    labele:String,
    maxLength:Int,
) {
    var  label by remember { mutableStateOf("") }
    val maxLength = maxLength

    val lightBlue = Color(0xffd8e6ff)
    val blue = Purple500
    Text(
        text = "$labele",
        fontSize = 17.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
        textAlign = TextAlign.Start,
        color = blue
    )
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = title,
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
            if (it.length <= maxLength) onValueChange(it)
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
            .padding(top = 4.dp),
        textAlign = TextAlign.End,
        color = blue
    )

}
@Composable
fun InputPhone(
    onValueChange : (String) -> Unit,
    title:String,
    labele:String,
    maxLength:Int,
) {
    var label by remember { mutableStateOf("") }
    val maxLength = maxLength
    val lightBlue = Color(0xffd8e6ff)
    val blue = Purple500
    Text(
        text = "$labele",
        fontSize = 17.sp,

        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
        textAlign = TextAlign.Start,
        color = blue

    )
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = title,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = lightBlue,
            cursorColor = Color.Black,
            disabledLabelColor = lightBlue,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ,
        ),
        onValueChange = {
            if (it.length <= maxLength) onValueChange(it)
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
            .padding(top = 4.dp),
        textAlign = TextAlign.End,
        color = blue
    )

}
@Composable
fun SexeSection(
    OnSelectedItem : (String) -> Unit,
    sexe: List<String>,
    label:String
) {
    var selectedSexeIndex by remember {
        mutableStateOf(0)
    }
    Column() {
        Text(
            text = "$label",
            fontSize = 17.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            textAlign = TextAlign.Start,
            color = Purple500
        )

    LazyRow {
        items(sexe.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(end = 15.dp, bottom = 15.dp)
                    .width(100.dp)
                    .clickable {
                        selectedSexeIndex = it
                        OnSelectedItem(sexe[it])
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedSexeIndex == it) Teal200
                        else Color.Gray
                    )
                    .padding(15.dp)
            ) {
                Text(text = sexe[it], color = Color.White)
            }
        }
    }
}
}
@Composable
fun ButtonNext(
    patientSharedViewModel: PatientSharedViewModel,
    label:String,
    navController: NavController,
    route:String,
) {
    Button(onClick = {
        patientSharedViewModel.creatPatient()
        navController.navigate(route = route)

    },
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        elevation =  ButtonDefaults.elevation(
        defaultElevation = 10.dp,
        pressedElevation = 15.dp,
        disabledElevation = 0.dp
    ), colors = ButtonDefaults.buttonColors(Purple500)) {
        Text(text = "$label", color = Color.White, fontSize = 15.sp,  fontFamily = gilroyFont,
            fontWeight = FontWeight.Normal,)
    }
}



