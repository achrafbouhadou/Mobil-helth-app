package com.example.santedigital.NavigationDrawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.santedigital.ui.theme.Purple500
import com.example.santedigital.ui.theme.gilroyFont

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),

    ) {
       Column(modifier = Modifier.padding(20.dp)) {



               Icon( Icons.Rounded.AccountCircle,
                   contentDescription = "user Image",
                   modifier = Modifier
                       .size(100.dp)
                       ,
                   tint = Purple500
               )
               Column() {
                   Text(text = "Achraf",
                       fontFamily = gilroyFont,
                       fontWeight = FontWeight.Bold)
                   Text(text = "ID : Moro11546",
                       fontFamily = gilroyFont,
                       fontWeight = FontWeight.Light)


           }
       }
    }
}

@Composable
fun DrawerBody(
    items: List<NavigationItheme>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (NavigationItheme) -> Unit
) {
    LazyColumn(){
        items(items){
                item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(16.dp),

            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.ContentDescription
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f)
                )
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun HeaderPreview() {
    DrawerHeader()
}