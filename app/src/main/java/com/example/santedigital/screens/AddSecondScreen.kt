package com.example.santedigital.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.santedigital.ui.theme.Purple200
import com.example.santedigital.ui.theme.Purple500
import com.example.santedigital.ui.theme.gilroyFont
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.santedigital.Screen

@Composable

fun AddSecondeScreen(
    navController: NavController
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)){
    }
    Column() {
        NavigationButton()
        TopTitle("Nouveau visite")
        AvencementSeconde()
        FromFieldsSecondscreen(navController = navController)
}
}
@Composable
fun FromFieldsSecondscreen(
    navController: NavController
) {

    Card(modifier = Modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
        .background(color = Color.White)) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
        ) {
            Text(text = "Visite details",
                fontFamily = gilroyFont,
                fontWeight = FontWeight.Normal,
                fontSize = 30.sp,
                modifier = Modifier.padding(20.dp))
Column(modifier = Modifier.fillMaxSize(), verticalArrangement =  Arrangement.SpaceBetween) {


            Column(modifier = Modifier .verticalScroll(rememberScrollState())) {
                dropDownMenu(
                    listOf("service1","service2","service3"),"service"
                )
                dropDownMenu(
                    listOf("medcin1","medcin2","medcin3"),"medcin"
                )

            }
            Column() {
                ButtonNext("Ajouter", navController = navController, Screen.ListeDesVisite.route)

            }
}

        }
    }
}
@Composable
fun dropDownMenu(
    liste: List<String>,
    label:String
) {

    var expanded by remember { mutableStateOf(false) }
    val suggestions = liste
    var selectedText by remember { mutableStateOf("") }

    var textfieldSize by remember { mutableStateOf(Size.Zero)}

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            readOnly = true,
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            label = {Text("$label")},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textfieldSize.width.toDp()})
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedText = label
                    expanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }

}
@Composable
fun AvencementSeconde() {
    val shape = RoundedCornerShape(12.dp)
    Row(modifier = Modifier
        .padding(bottom = 10.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
        Column(modifier = Modifier.padding(end = 40.dp ),horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Patient details",
                color = Color.Gray,
                fontFamily = gilroyFont,
                fontWeight = FontWeight.Bold)
            Box(
                modifier = Modifier
                    .width(90.dp)
                    .padding(top = 8.dp)
                    .height(6.dp)
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Color.Gray)
                    .clip(CircleShape)
            )

        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "Visite details",
                color = Purple500,
                fontFamily = gilroyFont,
                fontWeight = FontWeight.Bold)
            Box(
                modifier = Modifier
                    .width(90.dp)
                    .padding(top = 8.dp)
                    .height(6.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(color = Purple500)
            )


        }

    }

}

@Composable
@Preview(showBackground = true)
fun AddSecondePreview() {
    AddSecondeScreen(
        navController = rememberNavController()
    )
}