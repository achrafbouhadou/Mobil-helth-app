package com.example.santedigital.screens.detailVisite.examinClinique

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.santedigital.screens.Input
import com.example.santedigital.screens.InputPhone
import com.example.santedigital.ui.theme.Purple500
import androidx.compose.material.*
import androidx.compose.runtime.*


@Composable
fun examinGeneral() {
    Column( )  {
       // InputPhone(labele = "CONSCIENCE", maxLength = 101, label = "CONSCIENCE")
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            switchAndTitle(label = "Pupilles symétriques ")
            switchAndTitle(label = "Pupilles réactives ")
        }
        /*
        InputPhone(labele = "FRÉQUENCE RESPIRATOIRE", maxLength = 101, label = "FRÉQUENCE RESPIRATOIRE")
        InputPhone(labele = "FRÉQUENCE CARDIAQUE", maxLength = 101, label = "FRÉQUENCE CARDIAQUE")
        InputPhone(labele = "TENSION ARTÉRIELLE", maxLength = 101, label = "TENSION ARTÉRIELLE")
        InputPhone(labele = "TEMPÉRATURE", maxLength = 101, label = "TEMPÉRATURE")
        Input(label = "", labele = "COULEUR DE LA PEAU", maxLength =110 )
        Input(label = "", labele = "COULEUR DES CONJONCTIVES", maxLength =110 )
        Input(label = "", labele = "ASPECT DES MEMBRES SUPÉRIEURS ET INFÉRIEURS", maxLength =110 )
        Input(label = "", labele = "AUTRE SIGNES PARTICULIERS", maxLength =110 )

         */
    }



}

@Composable
fun switchAndTitle(
    label:String
) {
    Row(verticalAlignment = Alignment.CenterVertically){
        val checkedState = remember { mutableStateOf(true) }
        Switch(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            colors = SwitchDefaults.colors(Purple500)
        )
        Text(text = "$label")
    }
}
@Composable
@Preview(showBackground = true)
fun examinPreview () {
    examinGeneral()
}