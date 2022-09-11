package com.example.santedigital.screens.detailVisite.examinClinique

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.santedigital.ui.theme.Purple500

@Composable
fun examinDappareil() {
    var state by remember { mutableStateOf(0) }
    val titles = listOf(
        "Examen neurologique",
        "Examen cardiaque",
        "Examen respiratoire",
        "Examen abdominale",
        "Autre examens spécifiques")
    Column() {
        ScrollableTabRow(selectedTabIndex = state, backgroundColor = Purple500, contentColor = Color.White) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title)  },
                    selected = state == index,
                    onClick = { state = index }
                )
            }
        }

    }

}

@Composable
@Preview(showBackground = true)
fun Preview() {
    examinDappareil()
}