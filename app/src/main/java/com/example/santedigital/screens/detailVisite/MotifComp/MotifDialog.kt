package com.example.santedigital.screens.detailVisite.MotifComp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.santedigital.ui.theme.Purple500
import com.example.santedigital.ui.theme.gilroyFont


@Composable
fun MotifAlertDailog() {
    var showDialog = remember {
        mutableStateOf(true)
    }
    AlertDialog(
        onDismissRequest = {
            showDialog.value = false
        },
        title = {

        },
    confirmButton = {
            Row(modifier = Modifier.fillMaxWidth()){
                Row(modifier = Modifier
                    .fillMaxSize()
                    , horizontalArrangement = Arrangement.Center) {

                    Button(
                        onClick = {
                         showDialog.value = false
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
                            text = "Confirmer",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontFamily = gilroyFont,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                }
            }
    })
}

@Composable
fun Confirme(
    title:String
) {

}