package com.example.santedigital.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.santedigital.NavigationDrawer.NavigationDrawerFunction
import com.example.santedigital.R
import com.example.santedigital.Screen
import com.example.santedigital.ui.theme.*
import com.example.santedigital.ui.theme.ViewModel.PatientSharedViewModel
import com.example.santedigital.ui.theme.ViewModel.visiteSharedViewModel
import com.example.santedigital.ui.theme.modifier.adaptiveWidth
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VisiteScren(
    navController: NavController
) {




    Box(modifier = Modifier
        .fillMaxSize()
        .background(Purple200)) {
        Column {
            FilterIcon()
            InputIcon(label = "search", hint = "Recherche...")

            FeatureSection(

                visites = listOf(
                Visites(
                    IdPatient = "Moroco4543455",
                    IdVisite = "mo5545654",
                    Nom = "Achraf Bouhadou",
                    Date = "Janvier 05,2022 03:21 PM",
                    Status = "active"
                ),
                Visites(
                    IdPatient = "Moroco4543455",
                    IdVisite = "mo5545654",
                    Nom = "Youssef boussaboun",
                    Date = "Janvier 05,2022 03:21 PM",
                    Status = "active"
                ),
                        Visites(
                    IdPatient = "Moroco4543455",
                    IdVisite = "mo5545654",
                    Nom = "Youssef boussaboun",
                    Date = "Janvier 05,2022 03:21 PM",
                    Status = "active"
                )
            ),navController = navController)


        }

    }
}

@Composable
fun FilterIcon() {

    Row(modifier = Modifier
        .adaptiveWidth()
        .padding(bottom = 10.dp, start = 20.dp, end = 20.dp, top = 20.dp) ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        TopTitle("Les Visites")
        Icon( painter = painterResource(id = R.drawable.ic_filters_icon),
            contentDescription = "filter",
            modifier = Modifier
                .size(45.dp)
                .padding(bottom = 20.dp),
            tint = Purple500)

    }

}
@Composable
fun Profil(
    Nom:String,
    Id:String
) {
    
        Row(modifier = Modifier

            .fillMaxWidth()
            .padding(bottom = 10.dp, start = 20.dp, end = 20.dp, top = 20.dp) ,
            horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Rounded.Menu,
                contentDescription = "Close",
                modifier = Modifier.size(30.dp),
                tint = Purple500
            )
            Row( verticalAlignment = Alignment.CenterVertically) {

               Icon( Icons.Rounded.AccountCircle,
                   contentDescription = "user Image",
                   modifier = Modifier
                       .size(55.dp)
                       .padding(end = 10.dp),
               tint = Purple500)
                Column() {
                    Text(text = "$Nom",
                        fontFamily = gilroyFont,
                        fontWeight = FontWeight.Bold)
                    Text(text = "ID : $Id",
                        fontFamily = gilroyFont,
                        fontWeight = FontWeight.Light)

                }
            }


        }
}

@Composable
fun FilterVisite(
    filterBy:List<String>,
    filtered:List<String>
) {

        LazyRow {
            items(filterBy.size) {
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Gray,fontFamily = gilroyFont,
                            fontWeight = FontWeight.Normal)
                        ) {
                            append(filterBy[it])
                        }
                        withStyle(style = SpanStyle(color = Purple500,fontFamily = gilroyFont,
                            fontWeight = FontWeight.Bold)) {
                            append(filtered[it])
                        }

                    },
                    modifier = Modifier.padding(end = 8.dp)
                )

            }
        }



}
@Composable
fun InputIcon(
    label:String,
    hint:String
) {
    var label by remember { mutableStateOf("") }

    val lightBlue = Color(0xffd8e6ff)
    val blue = Purple500

    TextField(
        modifier = Modifier
            .adaptiveWidth()
            .padding(end = 20.dp, start = 20.dp, top = 10.dp, bottom = 10.dp)
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(20.dp)),
        value = label,

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            cursorColor = Color.Black,
            disabledLabelColor = lightBlue,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        onValueChange = {
            label = it
        },

        shape = RoundedCornerShape(8.dp),
        leadingIcon = { Icon(imageVector = Icons.Rounded.Search, contentDescription = null) },

        singleLine = true,
        placeholder = { Text("$hint") },
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

@ExperimentalFoundationApi
@Composable
fun FeatureSection(visites: List<Visites>,
                   navController: NavController) {
    val windowsInfo = rememberWindowsInfo()
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier

            .padding(end = 20.dp) ,horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Active visites",
                modifier = Modifier.padding(15.dp),
                fontSize = 30.sp,
                fontFamily = gilroyFont,
                fontWeight = FontWeight.Bold

            )
            ButtomAdd(navController = navController )
        }
        /*

         */
        if(windowsInfo.screenWithInfo is WindowInfo.WindowsType.Compact){
            LazyColumn(
                contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
                modifier = Modifier.fillMaxHeight()
            ) {
                items(visites.size) {
                    FeatureItem(visites = visites[it],navController = navController)
                }
            }
        }else{
            FlowRow(Modifier.padding(10.dp)) {

                for (index in visites){
                    FeatureItem(visites = index,navController = navController)
                }

            }
        }

    }
}

@Composable
fun FeatureItem(
    visites: Visites,
    navController: NavController
) {

   Card(modifier = Modifier
       .padding(start = 20.dp, end = 20.dp, top = 15.dp, bottom = 15.dp)
       .width(325.dp)
       .adaptiveWidth()
       .clip(shape = RoundedCornerShape(15.dp)), elevation = 20.dp) {

       Column(modifier = Modifier.padding(start = 20.dp, end = 5.dp, top = 20.dp, bottom = 20.dp)) {
           Row(modifier = Modifier.fillMaxWidth() ,horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically) {
               Column() {
                   Text(text = visites.Nom,
                       fontFamily = gilroyFont,
                       fontWeight = FontWeight.Bold)
                   Text(text = visites.Date,
                       fontFamily = gilroyFont,
                       fontWeight = FontWeight.Light)

               }


           }
           Divider(color = Purple200 , thickness = 1.dp , modifier = Modifier
               .width(100.dp)
               .padding(bottom = 10.dp) )

           Text(
               buildAnnotatedString {
                   withStyle(style = SpanStyle(color = Color.Gray,fontFamily = gilroyFont,
                       fontWeight = FontWeight.Normal)
                   ) {
                       append("ID  ")
                   }
                   withStyle(style = SpanStyle(color = Purple500,fontFamily = gilroyFont,
                       fontWeight = FontWeight.Bold)) {
                       append(visites.IdPatient)
                   }

               },
               modifier = Modifier.padding(end = 8.dp)
           )
           Text(
               buildAnnotatedString {
                   withStyle(style = SpanStyle(color = Color.Gray,fontFamily = gilroyFont,
                       fontWeight = FontWeight.Normal)
                   ) {
                       append("visite  ")
                   }
                   withStyle(style = SpanStyle(color = Purple500,fontFamily = gilroyFont,
                       fontWeight = FontWeight.Bold)) {
                       append(visites.IdVisite)
                   }

               },
               modifier = Modifier.padding(end = 8.dp)
           )
           Row(modifier = Modifier
               .fillMaxSize()
               .horizontalScroll(rememberScrollState())) {

               Button(onClick = {
                   navController.navigate(route = Screen.ListeDesMotifs.route)
               },
                   modifier = Modifier
                       .width(300.dp)
                       .height(100.dp)
                       .padding(20.dp)
                       .border(width = 1.dp, color = Color.Transparent),
                   shape = RoundedCornerShape(10.dp),
                   colors = ButtonDefaults.buttonColors(Teal200)
                   ) {
                   Text(
                       text = "Consultation",
                       color = Color.White,
                       fontSize = 15.sp,
                       fontFamily = gilroyFont,
                       fontWeight = FontWeight.Normal,
                   )
               }
           }
       }

   }
}

@Composable
@Preview(showBackground = true)
fun VisiteScreenPreview () {
    VisiteScren(navController = rememberNavController())
}

@Composable
fun ButtomAdd(
navController: NavController
) {
    Box(modifier = Modifier
        .padding(5.dp)
        .shadow(elevation = 10.dp, shape = CircleShape)
        .background(Color.Transparent)) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Purple500)
                .clickable {
                    navController.navigate(route = Screen.AddInformationPatient.route)
                },
        ) {

            Icon(
                Icons.Rounded.Add,
                contentDescription = "Ajouter",
                modifier = Modifier
                    .size(50.dp)
                    .padding(1.dp),
                tint = Color.White
            )
        }
    }
    }

