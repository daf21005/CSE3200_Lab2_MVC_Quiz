package com.example.cse3200_feb5_2026_mvc_screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cse3200_feb5_2026_mvc_screens.controllers.Score
import com.example.cse3200_feb5_2026_mvc_screens.models.BooleanQuestion
import com.example.cse3200_feb5_2026_mvc_screens.models.ListOfBooleanQuestions

@Composable
fun QuizQuestionScreen(
    goToSummaryScreen: () -> Unit
) {
    val questions = ListOfBooleanQuestions.listOfBooleanQuestions
    val score = remember { Score() }

    // Track each question's answer: "true", "false", "skipped", or null (unanswered)
    val answers = remember { mutableStateMapOf<Int, String>() }

    val scrollState = rememberScrollState()

    // Using a regular Column (eager) — loads ALL questions at once
    // as opposed to LazyColumn which only renders visible items
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Quiz Questions",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Answer all questions, then press Done.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Eagerly display ALL questions
        for (question in questions) {
            QuestionCard(
                question = question,
                selectedAnswer = answers[question.number],
                onAnswerSelected = { answer ->
                    answers[question.number] = answer
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Done button — calculates score and navigates to summary
        Button(
            onClick = {
                score.reset()
                for (question in questions) {
                    when (answers[question.number]) {
                        "true" -> {
                            if (question.isTrue) score.incrementCorrect()
                            else score.incrementIncorrect()
                        }
                        "false" -> {
                            if (!question.isTrue) score.incrementCorrect()
                            else score.incrementIncorrect()
                        }
                        "skipped" -> score.incrementSkipped()
                        else -> score.incrementSkipped() // unanswered = skipped
                    }
                }
                goToSummaryScreen()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Done")
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun QuestionCard(
    question: BooleanQuestion,
    selectedAnswer: String?,
    onAnswerSelected: (String) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Q${question.number}: ${question.text}",
                style = MaterialTheme.typography.bodyLarge
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // True button
                OutlinedButton(
                    onClick = { onAnswerSelected("true") },
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (selectedAnswer == "true") Color(0xFFC8E6C9) else Color.Transparent
                    ),
                    border = BorderStroke(
                        1.dp,
                        if (selectedAnswer == "true") Color(0xFF4CAF50) else Color.Gray
                    )
                ) {
                    Text("True")
                }

                // False button
                OutlinedButton(
                    onClick = { onAnswerSelected("false") },
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (selectedAnswer == "false") Color(0xFFFFCDD2) else Color.Transparent
                    ),
                    border = BorderStroke(
                        1.dp,
                        if (selectedAnswer == "false") Color(0xFFF44336) else Color.Gray
                    )
                ) {
                    Text("False")
                }

                // Skip button
                OutlinedButton(
                    onClick = { onAnswerSelected("skipped") },
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (selectedAnswer == "skipped") Color(0xFFFFF9C4) else Color.Transparent
                    ),
                    border = BorderStroke(
                        1.dp,
                        if (selectedAnswer == "skipped") Color(0xFFFFC107) else Color.Gray
                    )
                ) {
                    Text("Skip")
                }
            }
        }
    }
}