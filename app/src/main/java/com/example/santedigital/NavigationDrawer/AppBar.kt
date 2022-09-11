package com.example.santedigital.NavigationDrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.santedigital.R
import com.example.santedigital.screens.Profil
import com.example.santedigital.ui.theme.Purple200
import com.example.santedigital.ui.theme.Purple500
import com.example.santedigital.ui.theme.gilroyFont

@Composable
fun AppBar(
    Id:String,
    Nom:String,
    onNavigationIconClick: () -> Unit
) {
    Box(modifier = Modifier.background(Purple200)) {


        Row(
            modifier = Modifier

                .fillMaxWidth()
                .padding(bottom = 10.dp, start = 20.dp, end = 20.dp, top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Toggle drawer"
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {

                Icon(
                    Icons.Rounded.AccountCircle,
                    contentDescription = "user Image",
                    modifier = Modifier
                        .size(55.dp)
                        .padding(end = 10.dp),
                    tint = Purple500
                )
                Column() {
                    Text(
                        text = "$Nom",
                        fontFamily = gilroyFont,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "ID : $Id",
                        fontFamily = gilroyFont,
                        fontWeight = FontWeight.Light
                    )

                }
            }


        }


    }
}