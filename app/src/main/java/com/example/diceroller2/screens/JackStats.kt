package com.example.diceroller2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.diceroller2.R
import com.example.diceroller2.navigation.Jack_Stats

//@Preview(showBackground = true)
@Composable
fun jackStats(navControl: NavHostController) {
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Box(modifier = Modifier.size(300.dp)) {
            Image(painter = painterResource(id = R.drawable.david_putra), contentDescription = null,
            modifier = Modifier.fillMaxSize())
        }
        Text(text = "Model Name : David Putra",
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            color = Color(0xFF62Ec4D),
            fontSize = 23.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace)
        Spacer(modifier = Modifier.padding(6.dp))
        Text(text = "Owner : Jack",
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            color = Color(0xFF62Ec4D),
            fontSize = 23.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace)
        Spacer(modifier = Modifier.padding(6.dp))
        Text(text = "Engine Capacity : 2000cc",
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            color = Color(0xFF62Ec4D),
            fontSize = 23.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace)
        Spacer(modifier = Modifier.padding(6.dp))
        Text(text = "Top Speed : ???(>3000 km/h)",
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            color = Color(0xFF62Ec4D),
            fontSize = 23.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace)

        Spacer(modifier = Modifier.padding(36.dp))
        Text(
            text = "GAME STATS",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navControl.navigate(Jack_Stats) },
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.Monospace,
            textDecoration = TextDecoration.Underline
        )
    }


}
