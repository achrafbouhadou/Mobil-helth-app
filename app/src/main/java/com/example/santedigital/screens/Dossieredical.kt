package com.example.santedigital.screens

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Save
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.santedigital.FakeData.Motif
import com.example.santedigital.FakeData.Quest
import com.example.santedigital.FakeData.Resp
import com.example.santedigital.ui.theme.Purple500
import com.example.santedigital.ui.theme.Teal200
import com.example.santedigital.ui.theme.gilroyFont
import com.google.accompanist.flowlayout.FlowRow

var showContent:Int = 0
@Composable
@Preview(showBackground = true)
fun DossierMedical() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {

            NavigationPatient(
                navigation = listOf(
                    "Identité",
                    "Motif de consultation",
                    "Antécédents",
                    "Histoire de la maladie",
                    " Examen clinique",
                    "Conclusion clinique",
                    "Diagnostics à évoquer",
                    "Examens complémentaires",
                    "Conclusion radio-clinique",
                    "Prise en charge"


                )
            )

        }
    }
}

@Composable
fun NavigationPatient(
    navigation:List<String>
) {
    var selectedIndex by remember {
        mutableStateOf(1)
    }
    var  showContent by remember {
        mutableStateOf(1)
    }
    LazyRow {
        items(navigation.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(end = 0.dp, bottom = 15.dp, start = 10.dp, top = 20.dp)
                    .fillMaxWidth()
                    .clickable {
                        selectedIndex = it
                        showContent = it

                    }
                    .clip(RoundedCornerShape(30.dp))
                    .background(
                        if (selectedIndex == it) Teal200
                        else Color.Gray
                    )
                    .padding(15.dp)
            ) {
                Text(text = navigation[it], color = Color.White)
            }
        }
    }
    if (showContent == 1){
        MotifeDeConsultation()
        Row(modifier = Modifier
            .fillMaxSize()
            , horizontalArrangement = Arrangement.Center) {

            Button(onClick = {
                selectedIndex = 0
                showContent = 0
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Retour",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
            Button(onClick = {
                selectedIndex = 2
                showContent = 2
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Suivant",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
        }
    }
    if (showContent == 0){
        Column(modifier = Modifier.verticalScroll(rememberScrollState())){

            Column(modifier = Modifier
                .height(300.dp)
                .verticalScroll(rememberScrollState())) {


            InputEdit(label = "Bouhadou", labele = "Nom", maxLength = 101)
            InputEdit(label = "Achraf ", labele = "Prénom", maxLength = 101)
            InputEdit(label = "+212 682 457 19", labele = "téléphone", maxLength = 101)
            InputEdit(label = "Ait ishak", labele = "origine", maxLength = 101)
            InputEdit(label = "Marrakech", labele = "place de résidence", maxLength = 101)
            InputEdit(label = "devolopper", labele = "profession", maxLength = 101)
            InputEdit(label = "Cnops", labele = "couverture médicale", maxLength = 101)
            Column(modifier = Modifier.padding(start = 20.dp)) {
                SexeSection(
                    sexe = listOf("Mr", "Mme"), label = "Sexe"
                )
                SexeSection(
                    sexe = listOf("marié", "célibataire", "divorcé"), label = "Situation familiale"
                )
                SexeSection(
                    sexe = listOf("Bas", "Bon"), label = "Niveau socioéconomique"
                )
            }
        } }
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.End) {
            TopSave()
        }
        Row(modifier = Modifier
            .fillMaxSize()
            , horizontalArrangement = Arrangement.Center) {

            Button(onClick = {
                selectedIndex = 1
                showContent = 1
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Suivant",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
        }
    }
    if (showContent == 2){
        TextBox(title = "Antécédents")
        Row(modifier = Modifier
            .fillMaxSize()
            , horizontalArrangement = Arrangement.Center) {

            Button(onClick = {
                selectedIndex = 1
                showContent = 1
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Retour",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
            Button(onClick = {
                selectedIndex = 3
                showContent = 3
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Suivant",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
        }
    }
    if (showContent == 3){
        TextBox(title = "Histoire de la maladie")
        Row(modifier = Modifier
            .fillMaxSize()
            , horizontalArrangement = Arrangement.Center) {

            Button(onClick = {
                selectedIndex = 2
                showContent = 2
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Retour",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
            Button(onClick = {
                selectedIndex = 4
                showContent = 4
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Suivant",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
        }
    }
    if (showContent ==4){
        TextBox(title = "Examen clinique")
        Row(modifier = Modifier
            .fillMaxSize()
            , horizontalArrangement = Arrangement.Center) {

            Button(onClick = {
                selectedIndex = 3
                showContent = 3
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Retour",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
            Button(onClick = {
                selectedIndex = 5
                showContent = 5
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Suivant",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
        }
    }
    if (showContent ==5){
        TextBox(title = "Conclusion clinique")
        Row(modifier = Modifier
            .fillMaxSize()
            , horizontalArrangement = Arrangement.Center) {

            Button(onClick = {
                selectedIndex = 4
                showContent = 4
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Retour",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
            Button(onClick = {
                selectedIndex = 6
                showContent = 6
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Suivant",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
        }
    }
    if (showContent ==6){
        TextBox(title = "Diagnostics à évoquer")
        Row(modifier = Modifier
            .fillMaxSize()
            , horizontalArrangement = Arrangement.Center) {

            Button(onClick = {
                selectedIndex = 5
                showContent = 5
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Retour",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
            Button(onClick = {
                selectedIndex = 7
                showContent = 7
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Suivant",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
        }
    }
    if (showContent ==7){
        TextBox(title = "Examens complémentaires")
        Row(modifier = Modifier
            .fillMaxSize()
            , horizontalArrangement = Arrangement.Center) {

            Button(onClick = {
                selectedIndex = 6
                showContent = 6
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Retour",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
            Button(onClick = {
                selectedIndex = 8
                showContent = 8
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Suivant",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
        }
    }
    if (showContent ==8){
        TextBox(title = "Conclusion radio-cliniqu")
        Row(modifier = Modifier
            .fillMaxSize()
            , horizontalArrangement = Arrangement.Center) {

            Button(onClick = {
                selectedIndex = 7
                showContent = 7
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Retour",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
            Button(onClick = {
                selectedIndex = 9
                showContent = 9
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Suivant",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }
        }
    }
    if (showContent ==9){
        TextBox(title = "Prise en charge")
        Row(modifier = Modifier
            .fillMaxSize()
            , horizontalArrangement = Arrangement.Center) {

            Button(onClick = {
                selectedIndex = 8
                showContent = 8
            },
                modifier = Modifier
                    .weight(5f)
                    .height(100.dp)
                    .padding(20.dp)
                    .border(width = 1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Retour",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                )
            }

        }
    }
}

@Composable
fun ButtonWithIcon(
    label:String
) {
    Button(
        onClick = {
            // do something here
        },modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(end = 20.dp, start = 20.dp, bottom = 10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation =  ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        ), colors = ButtonDefaults.buttonColors(Teal200)
    ) {
        Icon(
            imageVector = Icons.Filled.Save,
            contentDescription = "$label",
            Modifier.padding(end = 8.dp),
            tint = Color.White
        )
        Text(text = "$label", color = Color.White)
    }
    
}

@Composable
fun ListeDesMotifs(
    motifs:List<Motif>
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        LazyRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            items(motifs.size){ index ->
                var selectedIndex by remember {
                    mutableStateOf(0)
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(end = 0.dp, bottom = 15.dp, start = 15.dp, top = 20.dp)
                        .fillMaxWidth()
                        .clickable {
                            selectedIndex = index
                        }
                        .clip(RoundedCornerShape(30.dp))
                        .background(
                            if (selectedIndex == index) Purple500
                            else Color.Gray
                        )
                        .padding(15.dp)
                ) {
                    Text(text = motifs[index].Motif, color = Color.White)
                }
            }
        }
        LazyRow(){
            items(motifs.size) { index ->

                        ListeDesMotif(motif = motifs[index])
                    }
                }


    }
}


@Composable
fun ListeDesMotif(
    motif: Motif,
) {
    Column() {
        Text(
            text = "${motif.Motif}",
            modifier = Modifier.padding(15.dp),
            fontSize = 30.sp,
            fontFamily = gilroyFont,
            fontWeight = FontWeight.Bold

        )
        LazyColumn(modifier =   Modifier.height(200.dp)){
            items(motif.quest.size) { index ->
                ListeDesQuestion(quest = motif.quest[index],index)
            }
        }
    }

}

@Composable
fun ListeDesQuestion(
    quest: Quest,
    index:Int
) {
    Card(modifier = Modifier
        .padding(start = 20.dp, end = 20.dp, top = 15.dp, bottom = 15.dp)
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(15.dp)), elevation = 20.dp) {
        Column() {
            Text(
                text = "${quest.Quest}",
                modifier = Modifier.padding(15.dp),
                fontSize = 30.sp,
                fontFamily = gilroyFont,
                fontWeight = FontWeight.Bold,
                color = Purple500


            )

            FlowRow(Modifier.padding(10.dp)) {

                for (index in quest.Resp){
                    ListeDesReponse(resp = index)
                }

            }
        }
        }

}

@Composable
fun ListeDesReponse(
    resp: Resp
) {
    var selectedSexeIndex by remember {
        mutableStateOf(resp)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(end = 15.dp, bottom = 15.dp)
            .width(100.dp)
            .clickable {

                selectedSexeIndex = resp
            }
            .clip(RoundedCornerShape(10.dp))
            .background(
                if (selectedSexeIndex == resp) Teal200
                else Color.Gray
            )
            .padding(15.dp)
    ) {
        Text(text = resp.Resp, color = Color.White)
    }
}

@Composable
fun TopAdd(

) {
    var showDialog = remember {
        mutableStateOf(true)
    }
    Box(modifier = Modifier
        .padding(5.dp)
        .shadow(elevation = 10.dp, shape = CircleShape)
        .background(Color.Transparent)) {


    Box(modifier = Modifier
        .clip(CircleShape)
        .background(Purple500)



    ) {

        Icon(
            Icons.Rounded.Add,
            contentDescription = "Ajouter",
            modifier = Modifier
                .size(50.dp)
                .padding(10.dp)
                .clickable {

                },
            tint = Color.White,

        )
    }
    }
}

@Composable
fun TopSave(

) {
    Box(modifier = Modifier
        .padding(5.dp)
        .shadow(elevation = 10.dp, shape = CircleShape)
        .background(Color.Transparent)) {

    val context  = LocalContext.current
    Box(modifier = Modifier
        .clip(CircleShape)
        .background(Teal200)


    ) {

        Icon(
            Icons.Rounded.Save,
            contentDescription = "Save",
            modifier = Modifier
                .size(50.dp)
                .padding(10.dp).clickable {
                    Toast.makeText(context , "les modification sont bien enregestrer",Toast.LENGTH_LONG).show()
                },
            tint = Color.White
        )
    }
    }
}
@Composable
fun MotifeDeConsultation() {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End ) {
            TopAdd()
            TopSave()

        }
        TopTitle("Liste des Motifes")

        ListeDesMotifs(listOf(
            Motif(
                Motif = "Douleur",
                quest =  listOf(
                    Quest(
                        Quest = "Location",
                        Resp=  listOf(
                            Resp(
                                Resp = "Bras"
                            ),
                            Resp(
                                Resp = "Dous"
                            ),
                            Resp(
                                Resp = "Epaule"
                            ),
                        )
                    ),

                    )
            ), Motif(
                Motif = "Autre",
                quest =  listOf(
                    Quest(
                        Quest = "Location",
                        Resp=  listOf(
                            Resp(
                                Resp = "Bras"
                            ),
                            Resp(
                                Resp = "Dous"
                            ),
                            Resp(
                                Resp = "Epaule"
                            ),
                        )
                    ),
                    Quest(
                        Quest = "Nature",
                        Resp= listOf(
                            Resp(
                                Resp = "Brulleur"
                            ),
                            Resp(
                                Resp = "Loudeur"
                            ),
                            Resp(
                                Resp = "Serrant"
                            ),
                        )
                    ),
                    Quest(
                        Quest = "Gravité",
                        Resp= listOf(
                            Resp(
                                Resp = "Legere"
                            ),
                            Resp(
                                Resp = "Grave"
                            ),
                            Resp(
                                Resp = "Moder"
                            ),
                        )
                    ), Quest(
                        Quest = "Facteur",
                        Resp= listOf(
                            Resp(
                                Resp = "Marche"
                            ),
                            Resp(
                                Resp = "courire"
                            ),
                            Resp(
                                Resp = "esclade"
                            ),
                        )
                    )
                )
            )
        ))
    }

@Composable
fun TextBox(
    title:String
) {
    var label by remember { mutableStateOf("") }
    val lightBlue = Color(0xffd8e6ff)
    val blue = Purple500
    TopTitle("$title")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End ) {
        TopSave()

    }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(30.dp),
        value = label,
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
             label = it
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
}

