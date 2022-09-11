package com.example.santedigital.screens.detailVisite.Diagnostics

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.santedigital.ui.theme.Purple200
import com.example.santedigital.ui.theme.Purple500
import com.example.santedigital.ui.theme.gilroyFont


@Composable
fun Diagnostic() {
    var openDialogue = remember {
        mutableStateOf(false)
    }
    if(openDialogue.value){
        dialogDiagnostic(openDialog = openDialogue)
    }
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Row(modifier  = Modifier
            .fillMaxWidth()
            .padding(20.dp),horizontalArrangement = Arrangement.End) {
            ExtendedFloatingActionButton(
                icon = { Icon(Icons.Filled.Add, contentDescription = null) },
                text = { Text("Ajouter un Diagnostic") },
                onClick = {openDialogue.value =true },
                backgroundColor = Purple500,
                contentColor = Color.White
            )
        }
        Card {
            Column() {
                Card(modifier = Modifier.padding(12.dp), elevation = 6.dp) {
                    Column() {


                    Text(
                        text = "Pour",
                        modifier = Modifier
                            .padding(15.dp)
                            .align(alignment = Alignment.CenterHorizontally),
                        fontSize = 30.sp,
                        fontFamily = gilroyFont,
                        fontWeight = FontWeight.Bold

                    )
                    Text(
                        text = "Text Pour de Diagnostic 1 ici, Text de 1er Diagnostic limite en 3 lignes, Text de Diagnostic tremini",
                        modifier = Modifier
                            .padding(15.dp)
                            ,
                        fontSize = 30.sp,
                        fontFamily = gilroyFont,
                        fontWeight = FontWeight.Normal

                    )
                    }
                }
                Card(modifier = Modifier.padding(12.dp),elevation = 6.dp) {
                    Column() {


                    Text(
                        text = "Contre",
                        modifier = Modifier
                            .padding(15.dp)
                            .align(alignment = Alignment.CenterHorizontally),
                        fontSize = 30.sp,
                        fontFamily = gilroyFont,
                        fontWeight = FontWeight.Bold

                    )
                    Text(
                        text = "text Contre de Diagnostic 1 ici, Text de 1er Diagnostic limite en 3 lignes, Text de Diagnostic tremini",
                        modifier = Modifier.padding(15.dp),
                        fontSize = 30.sp,
                        fontFamily = gilroyFont,
                        fontWeight = FontWeight.Normal

                    )

                }
                }
            }
        }
    }


}

@Composable
@Preview
fun DiagnosticPreview() {
    Diagnostic()
}