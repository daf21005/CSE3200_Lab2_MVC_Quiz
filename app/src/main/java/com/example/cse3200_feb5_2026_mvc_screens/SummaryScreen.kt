package com.example.cse3200_feb5_2026_mvc_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cse3200_feb5_2026_mvc_screens.controllers.Score

@Composable
fun SummaryScreen(
    restartQuiz: () -> Unit
) {
    val score = Score()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Quiz Complete!", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(24.dp))

        Text("Correct: ${score.getCorrect()}", style = MaterialTheme.typography.titleLarge)
        Text("Incorrect: ${score.getIncorrect()}", style = MaterialTheme.typography.titleLarge)
        Text("Skipped: ${score.getSkipped()}", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Total Answered: ${score.getTotal()}",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                score.reset()
                restartQuiz()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Restart Quiz")
        }
    }
}
