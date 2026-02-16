package com.example.cse3200_feb5_2026_mvc_screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cse3200_feb5_2026_mvc_screens.ui.theme.CSE3200_Feb5_2026_MVC_ScreensTheme

// one question at a time or all questions at a go

object Routes {
    const val LANDING_SCREEN = "landing_screen"
    const val QUIZ_QUESTIONS = "quiz_questions"
    const val SUMMARY_SCREEN = "summary_screen"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CSE3200_Feb5_2026_MVC_ScreensTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Routes.LANDING_SCREEN,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        /* LANDING_SCREEN */
                        composable(Routes.LANDING_SCREEN) {
                            LandingScreen(
                                goToQuizScreen = {
                                    navController.navigate(Routes.QUIZ_QUESTIONS) {
                                        popUpTo(Routes.LANDING_SCREEN) { inclusive = true }
                                    }
                                }
                            )
                        }

                        /* QUIZ_QUESTIONS */
                        composable(Routes.QUIZ_QUESTIONS) {
                            QuizQuestionScreen(
                                goToSummaryScreen = {
                                    navController.navigate(Routes.SUMMARY_SCREEN) {
                                        popUpTo(Routes.QUIZ_QUESTIONS) { inclusive = true }
                                    }
                                }
                            )
                        }

                        /* SUMMARY_SCREEN */
                        composable(Routes.SUMMARY_SCREEN) {
                            SummaryScreen(
                                restartQuiz = {
                                    navController.navigate(Routes.LANDING_SCREEN) {
                                        popUpTo(0) // nuke entire backstack
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
