package com.example.santedigital.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.santedigital.R
import com.example.santedigital.Screen
import com.example.santedigital.screens.NavigationButton
import com.example.santedigital.screens.NavigationPatient
import com.example.santedigital.screens.Profil
import com.example.santedigital.screens.TopTitle

@Composable
fun IdenScrenn() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Profil(Nom = "Achraf Bouhadou", Id = "123SJBDSKK")
            NavigationButton()
            NavigationPatient(
                navigation = listOf(
                    "Identité",
                    "Motif de consultation",

                    )
            )
            Box(
                modifier = Modifier
                    .clip(CircleShape).padding(start = 20.dp)
                    .background(Purple500).clickable {

                    },
            ) {

                Icon(
                    Icons.Rounded.Edit,
                    contentDescription = "Ajouter",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(1.dp),
                    tint = Color.White
                )
            }
            SimpleInformation()
            ContainerFormation()
        }
    }
}

@Composable
fun SimpleInformation() {
    Card(modifier = Modifier
        .padding(start = 20.dp, end = 20.dp, top = 15.dp, bottom = 15.dp)
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(25.dp)), elevation = 40.dp) {
        Column() {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Achraf BOUHADOU",
                    modifier = Modifier.padding(15.dp),
                    fontSize = 30.sp,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Bold

                )
                Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Rounded.Phone, contentDescription ="phone" )
                    Text(
                        text = "+212 682 457 919",
                        modifier = Modifier.padding(15.dp),
                        fontSize = 25.sp,
                        fontFamily = gilroyFont,
                        fontWeight = FontWeight.Normal

                    )

                }


            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
                Text(
                    buildAnnotatedString() {
                        withStyle(style = ParagraphStyle(lineHeight = 50.sp)) {
                            withStyle(style = SpanStyle(color = Color.Gray,fontSize = 40.sp)) {
                                append("20\n")
                            }
                            withStyle(

                                style = SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 30.sp

                                    )
                            ) {
                                append("Visite")
                            }

                        }
                    },textAlign = TextAlign.Center,

                )
                Text(
                    buildAnnotatedString {
                        withStyle(style = ParagraphStyle(lineHeight = 50.sp)) {
                            withStyle(style = SpanStyle(color = Color.Gray
                            , fontSize = 40.sp)) {
                                append("10\n")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 30.sp

                                    )
                            ) {
                                append("Hour")
                            }

                        }
                    },textAlign = TextAlign.Center,
                )
            }
            }

        }
    }

@Composable
fun ContainerFormation() {
    Card(modifier = Modifier
        .padding(start = 20.dp, end = 20.dp, top = 15.dp, bottom = 15.dp)
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(25.dp)), elevation = 40.dp) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            PatientFormation(FirstText = "femme",
                SecondeTexte = "12 jul 1999",
                FirsteLabel ="sexe" ,
                SecondLabel ="date de naissance" )
            Divider(color = Color.Gray , thickness = 1.dp , modifier = Modifier.padding(20.dp))
            PatientFormation(FirstText = "talojt 2 n68",
                SecondeTexte = "Marrakech",
                FirsteLabel ="Adress" ,
                SecondLabel ="Ville" )
            Divider(color = Color.Gray , thickness = 1.dp , modifier = Modifier.padding(20.dp))
            PatientFormation(FirstText = "femme",
                SecondeTexte = "12 jul 1999",
                FirsteLabel ="sexe" ,
                SecondLabel ="date de naissance" )
            Divider(color = Color.Gray , thickness = 1.dp , modifier = Modifier.padding(20.dp))
            PatientFormation(FirstText = "femme",
                SecondeTexte = "12 jul 1999",
                FirsteLabel ="sexe" ,
                SecondLabel ="date de naissance" )
            Divider(color = Color.Gray , thickness = 1.dp , modifier = Modifier.padding(20.dp))
        }


    }
}
@Composable
fun PatientFormation(
    FirstText:String,
    SecondeTexte:String,
    FirsteLabel:String,
    SecondLabel:String,
) {
    
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                buildAnnotatedString() {
                    withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                        withStyle(style = SpanStyle(color = Color.Gray,fontSize = 25.sp)) {
                            append("$FirsteLabel\n")
                        }
                        withStyle(

                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,


                            )
                        ) {
                            append("$FirstText")
                        }

                    }
                },textAlign = TextAlign.Center,

                )
            Text(
                buildAnnotatedString {
                    withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                        withStyle(style = SpanStyle(color = Color.Gray
                            , fontSize = 25.sp)) {
                            append("$SecondLabel\n")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp

                            )
                        ) {
                            append("$SecondeTexte")
                        }

                    }
                },textAlign = TextAlign.Center,
            )
        }
    }


@Composable
@Preview(showBackground = true)
fun IdenScrennPreview() {
    IdenScrenn()
}