package com.example.cse3200_feb5_2026_mvc_screens.models

enum class QuestionType {
    SPACE,
    ARITHMETIC,
    GENERAL
}

data class BooleanQuestion(
    val number: Int,
    val text:String,
    val isTrue: Boolean,
    val questionType: QuestionType
)