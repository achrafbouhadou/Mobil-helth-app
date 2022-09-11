package com.example.santedigital.screens.detailVisite.Diagnostics

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.santedigital.screens.Input
import com.example.santedigital.ui.theme.Purple500
import com.example.santedigital.ui.theme.gilroyFont

@Composable
fun dialogDiagnostic(
    openDialog: MutableState<Boolean> = remember { mutableStateOf(true) } ,



) {
    AlertDialog(
        onDismissRequest = {
            openDialog.value = false
        },
        title = {
            Text(
                text = "Ajouter un Diagnostic",
                fontSize = 30.sp,
                fontFamily = gilroyFont,
                fontWeight = FontWeight.Bold

            )
        },
        text = {
            Column() {
                Input(label = "Titre de Diagnostic", labele = "Titre de Diagnostic", maxLength =101 )
                Input(label = "Pour", labele = "Pour", maxLength =199 )
                Input(label = "Contre", labele = "Contre", maxLength =199 )
            }
        },
        buttons = {
            Row(
                modifier = Modifier.padding(all = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    openDialog.value = false
                },
                    modifier = Modifier
                        .weight(1f)
                        .height(100.dp)
                        .padding(20.dp)
                        .border(width = 1.dp, color = Color.Transparent)
                        .alpha(ContentAlpha.medium),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Purple500)
                ) {
                    Text(
                        text = "CLose",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontFamily = gilroyFont,
                        fontWeight = FontWeight.Normal,
                    )
                }
                Button(onClick = {
                    openDialog.value = false
                },
                    modifier = Modifier
                        .weight(1f)
                        .height(100.dp)
                        .padding(20.dp)
                        .border(width = 1.dp, color = Color.Transparent),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Purple500)
                ) {
                    Text(
                        text = "Ajouter",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontFamily = gilroyFont,
                        fontWeight = FontWeight.Normal,
                    )
                }
            }
        }
    )
}

@Composable
@Preview
fun dialogDiagnosticPreview() {
    dialogDiagnostic()
}