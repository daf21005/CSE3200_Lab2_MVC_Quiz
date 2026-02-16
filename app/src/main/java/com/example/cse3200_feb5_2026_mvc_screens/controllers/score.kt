package com.example.cse3200_feb5_2026_mvc_screens.controllers

class Score {

    companion object {
        private var correctAnswers = 0
        private var incorrectAnswers = 0
        private var skippedQuestions = 0
    }

    fun incrementCorrect() {
        correctAnswers++
    }

    fun incrementIncorrect() {
        incorrectAnswers++
    }

    fun incrementSkipped() {
        skippedQuestions++
    }

    fun getCorrect(): Int = correctAnswers
    fun getIncorrect(): Int = incorrectAnswers
    fun getSkipped(): Int = skippedQuestions
    fun getTotal(): Int = correctAnswers + incorrectAnswers + skippedQuestions

    fun reset() {
        correctAnswers = 0
        incorrectAnswers = 0
        skippedQuestions = 0
    }
}
