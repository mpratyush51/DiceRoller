package com.example.diceroller2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.diceroller2.screens.Scores.gamesWonPlayer2

//@Preview(showBackground = true)
@Composable
fun jackAnalysis() {

    var winRate = (gamesWonPlayer2.value / gamesPlayed.value).toDouble()*100

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Box(modifier = Modifier.size(300.dp)) {
            Image(painter = painterResource(id = R.drawable.jack_dictator), contentDescription = null,
                modifier = Modifier.fillMaxSize()
                    .clip(CircleShape),
                    contentScale = ContentScale.FillBounds)
        }
        Spacer(modifier = Modifier.padding(4.dp))

        Text(text = "JACK's STATS",
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            color = Color(0xFF62Ec4D),
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = "Played : ${gamesPlayed.value}",
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            color = Color(0xFF62Ec4D),
            fontSize = 23.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = "Won : ${gamesWonPlayer2.value}",
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            color = Color(0xFF62Ec4D),
            fontSize = 23.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = "Win Rate : ${winRate} ",
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            color = Color(0xFF62Ec4D),
            fontSize = 23.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace)


    }


}