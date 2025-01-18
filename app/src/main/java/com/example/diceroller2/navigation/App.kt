package com.example.diceroller2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.diceroller2.screens.App
import com.example.diceroller2.screens.jackAnalysis
import com.example.diceroller2.screens.jackStats
import com.example.diceroller2.screens.oggyAnalysis
import com.example.diceroller2.screens.oggyStats


@Composable
fun Application(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = StartRoute){
        composable<StartRoute>{
            App(navControl = navController)
        }
        composable<OggyRoute>{
            oggyStats(navControl = navController)
        }
        composable<JackRoute>{
            jackStats(navControl = navController)
        }
        composable<Oggy_Stats>{
            oggyAnalysis()
        }
        composable<Jack_Stats>{
            jackAnalysis()
        }

    }

}

