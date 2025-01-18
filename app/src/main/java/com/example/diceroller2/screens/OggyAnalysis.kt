package com.example.diceroller2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import com.example.diceroller2.R
import com.example.diceroller2.screens.Scores.gamesPlayed
import com.example.diceroller2.screens.Scores.gamesWonPLayer1

//@Preview(showBackground = true)
@Composable
fun oggyAnalysis(
) {
    var winRate = (gamesWonPLayer1.value / gamesPlayed.value).toDouble() * 100
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.size(300.dp)) {
            Image(
                painter = painterResource(id = R.drawable.oggy_stats), contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = "OGGY's STATS",
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            color = Color(0xFF00FFFF),
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "Played : ${gamesPlayed.value}",
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            color = Color(0xFF00FFFF),
            fontSize = 23.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace
        )

        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "Won :${gamesWonPLayer1.value}",
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            color = Color(0xFF00FFFF),
            fontSize = 23.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.padding(4.dp))

        Text(
            text = "Win Rate:${winRate} ",
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            color = Color(0xFF00FFFF),
            fontSize = 23.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace
        )


    }


}