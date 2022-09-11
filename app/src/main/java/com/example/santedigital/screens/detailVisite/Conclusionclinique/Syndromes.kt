package com.example.santedigital.screens.detailVisite.Conclusionclinique

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.santedigital.screens.InputEdit
import com.example.santedigital.ui.theme.Purple500
import com.example.santedigital.ui.theme.ViewModel.syndrome
import com.example.santedigital.ui.theme.ViewModel.syndromeSharedViewModel
import com.example.santedigital.ui.theme.gilroyFont

@Composable
fun Syndromes(
    syptomSharedViewModel: syndromeSharedViewModel = viewModel()
) {
    val allSyptom = syptomSharedViewModel.getAllSyptom()
    var id by remember { mutableStateOf(0) }
    var label by remember { mutableStateOf("") }
    Column() {

        Text(
            text = "Syndromes",
            modifier = Modifier.padding(15.dp),
            fontSize = 30.sp,
            fontFamily = gilroyFont,
            fontWeight = FontWeight.Bold
        )

        LazyColumn(){
            items(items = allSyptom,
                key = { syptom ->
                    syptom.id
                }){ syptom ->
                id += 1
                label = syptom.label
                InputEdit(label = "${syptom.label}", labele = "", maxLength = 101)
            }
        }


        Row(modifier  = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
            FloatingActionButton(backgroundColor = Purple500, contentColor = Color.White,onClick = {

                syptomSharedViewModel.addSyptom(syndrome = syndrome(id = id , label = "string" ))
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Localized description")
            }
        }

    }

}


@Composable
@Preview
fun previewSyndrom() {
    Syndromes()
}