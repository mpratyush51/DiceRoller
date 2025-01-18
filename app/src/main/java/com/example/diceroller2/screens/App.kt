package com.example.diceroller2.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.ContextCompat.getDrawable
import androidx.navigation.NavHostController
import com.example.diceroller2.R
import com.example.diceroller2.navigation.JackRoute
import com.example.diceroller2.navigation.OggyRoute
import com.example.diceroller2.screens.Scores.gamesPlayed
import com.example.diceroller2.screens.Scores.gamesWonPLayer1
import com.example.diceroller2.screens.Scores.gamesWonPlayer2
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import kotlin.random.Random



//@Preview(showBackground = true)
@Composable
fun App(modifier: Modifier = Modifier,navControl:NavHostController) {
    var scorePlayer1 = remember { mutableStateOf(0) }
    var scorePlayer2 = remember { mutableStateOf(0) }
    var currentImage = remember { mutableStateOf(0) }

    var images = listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )

    var isPlayer1Turn = remember { mutableStateOf(true) }

    fun resetGame() {
        scorePlayer1.value = 0
        scorePlayer2.value = 0
        currentImage.value = 0
        isPlayer1Turn.value = true
    }

    fun gameStats() {
        if (scorePlayer1.value >= 20 ) {
            gamesWonPLayer1.value += 1
        }
            else {

                gamesWonPlayer2.value += 1

            }
        }

    if (scorePlayer1.value >= 20 || scorePlayer2.value >= 20) {
        if (scorePlayer1.value > scorePlayer2.value) {
            Dialog(
                onDismissRequest = { },
                properties = DialogProperties(
                    usePlatformDefaultWidth = true
                )
            ) {
                Card(modifier = Modifier.size(420.dp),
                    colors = CardDefaults.cardColors(Color.Transparent),
                    border = BorderStroke(1.dp, Color(0xFF00F0F0)),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(modifier = Modifier
                            .clip(CircleShape)
                            .size(260.dp),
                            painter = rememberDrawablePainter(
                                drawable = getDrawable(
                                    LocalContext.current,
                                    R.drawable.oggygif
                                )
                            ),
                            contentDescription = null ,
                            contentScale = ContentScale.FillBounds
                            )
                        Spacer(modifier = Modifier.height(12.dp) )
                        Text(text = "Game Over!!!",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF00FFFF),
                            fontFamily = FontFamily.Monospace)
                        Spacer(modifier = Modifier.height(12.dp) )
                        Text(text = "OGGY Wins",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF00FFFF),
                            fontFamily = FontFamily.Monospace,
                        )
                        Spacer(modifier = Modifier.height(10.dp) )
                        Button(onClick = { resetGame()
                            gameStats()
                                         },
                            colors = ButtonDefaults.buttonColors(Color(0xFF00FFFF))) {
                            Text(text = "Restart",
                                fontSize = 26.sp,
                                fontWeight = FontWeight.W800,
                                color = Color.Black,
                                fontFamily = FontFamily.Monospace
                            )

                        }
                    }
                }
            }

        } else {
            Dialog(
                onDismissRequest = { },
                properties = DialogProperties(
                    usePlatformDefaultWidth = true
                )
            ) {
                Card(modifier = Modifier.size(420.dp),
                    colors = CardDefaults.cardColors(Color.Transparent),
                    elevation = CardDefaults.cardElevation(8.dp),
                    border = BorderStroke(1.dp, Color(0xFF4ED839))
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(modifier = Modifier
                            .clip(CircleShape)
                            .size(260.dp),
                            painter = rememberDrawablePainter(
                                drawable = getDrawable(
                                    LocalContext.current,
                                    R.drawable.jackgif
                                )
                            ),
                            contentDescription = null ,
                            contentScale = ContentScale.FillBounds,)
                        Text(text = "Game Over!!!",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF62Ec4D),
                            fontFamily = FontFamily.Monospace)
                        Spacer(modifier = Modifier.height(12.dp) )
                        Text(text = "JACK Wins",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF62Ec4D),
                            fontFamily = FontFamily.Monospace
                        )
                        Spacer(modifier = Modifier.height(10.dp) )
                        Button(onClick = { resetGame()
                                         gameStats()},
                            colors = ButtonDefaults.buttonColors(Color(0xFF62Ec4D))) {
                            Text(text = "Restart",
                                fontSize = 26.sp,
                                fontWeight = FontWeight.W800,
                                color = Color.Black,
                                fontFamily = FontFamily.Monospace,
                                modifier = Modifier.clickable {
                                    gamesPlayed.value += 1
                                }
                            )

                        }
                    }
                }

            }

        }

    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "SCORE",
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif)

            Spacer(modifier = Modifier.height(40.dp))

            Row {
                Text(text = "OGGY : ${scorePlayer1.value}",
                    color = Color(0xFF00FFFF),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif
                )
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "JACK : ${scorePlayer2.value}",
                    color = Color(0xFF62Ec4D),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            if (isPlayer1Turn.value) {
                Text(text = "OGGY's turn",
                    color = Color(0xFF00FFFF),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Monospace)
            } else {
                Text(text = "JACK's turn",
                    color = Color(0xFF62Ec4D),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Monospace)
            }
            Spacer(modifier = Modifier.height(2.dp))
            Image(
                painter = if (currentImage.value == 0) {
                    painterResource(id = R.drawable.combo)
                } else painterResource(id = images.get(currentImage.value - 1)),
                contentDescription = null,
                modifier = Modifier.size(250.dp)

            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
            Row {
                    Button(
                        onClick = {
                            val randomNum = Random.nextInt(6) + 1
                            scorePlayer1.value += randomNum
                            currentImage.value = randomNum

                            isPlayer1Turn.value = !isPlayer1Turn.value
                        },
                        enabled = if (isPlayer1Turn.value) true else false,
                        colors = ButtonDefaults.buttonColors(Color(0xFF00FFFF)),
                        shape = RoundedCornerShape(10.dp),
                        elevation = ButtonDefaults.buttonElevation(10.dp),
                        border = BorderStroke(1.dp, Color(0xFF00F0F0))
                    ) {



                        Text(
                            text = "Scooty",
                            color = Color(0xFFFFA500),
                            fontWeight = FontWeight.W800
                        )
                    }
                    Spacer(modifier = Modifier.width(24.dp))
                Button(
                    onClick = {
                        val randomNum = Random.nextInt(6) + 1
                        scorePlayer2.value += randomNum
                        currentImage.value = randomNum
                        isPlayer1Turn.value = !isPlayer1Turn.value
                    },
                    enabled = if (isPlayer1Turn.value) false else true,
                    colors = ButtonDefaults.buttonColors(Color(0xFF62Ec4D)),
                    shape = RoundedCornerShape(10.dp),
                    elevation = ButtonDefaults.buttonElevation(10.dp),
                    border = BorderStroke(1.dp, Color(0xFF4ED839))

                )
                {
                    Text(
                        text = "David Putra",
                        color = Color(0xFFFFA500),
                        fontWeight = FontWeight.W800
                    )

                }

                }
                Spacer(modifier = Modifier.height(26.dp))

                Text(
                    text = "Bike Info",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
                Spacer(modifier = Modifier.height(18.dp))


                Row {
                    Text(
                        text = "Scooty", modifier = Modifier.clickable {
                            navControl.navigate(OggyRoute)

                        },
                        color = Color(0xFF00FFFF),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        textDecoration = TextDecoration.Underline
                    )
                    Spacer(modifier = Modifier.width(56.dp))
                    Text(
                        text = "David Putra", modifier = Modifier.clickable {
                            navControl.navigate(JackRoute)

                        },
                        color = Color(0xFF62Ec4D),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        textDecoration = TextDecoration.Underline
                    )
                }




                }
            }

                }
            }

    object Scores {
        var gamesWonPLayer1 = mutableStateOf(0)

        var gamesWonPlayer2 = mutableStateOf(0)

        var gamesPlayed = mutableStateOf(0)

    }






