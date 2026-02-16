package com.example.cse3200_feb5_2026_mvc_screens.controllers

import com.example.cse3200_feb5_2026_mvc_screens.models.ListOfBooleanQuestions

class NextQuestion {

    private val totalQuestions = ListOfBooleanQuestions().getSize()

    companion object {
        private var currentQuestion = 0
    }

    // these two function would be used if were aren't using eager list
    fun getNextIncQuestionNumber() : Int {
        currentQuestion = (currentQuestion +1) % totalQuestions
        return currentQuestion
    }

    fun getNextRandomQuestionNumber() : Int {
        val getRand = (0 until totalQuestions).random()
        return getRand
    }

}