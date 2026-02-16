package com.example.cse3200_feb5_2026_mvc_screens.models

class ListOfBooleanQuestions{
    fun getListOfBooleanQuestions(): List<BooleanQuestion> {
        return listOfBooleanQuestions
    }

    fun getSize() : Int {
        return listOfBooleanQuestions.size
    }

    companion object {
        val listOfBooleanQuestions: List<BooleanQuestion> = listOf(
            // SPACE questions
            BooleanQuestion(1, "Our solar system has 13 planets", false, QuestionType.SPACE),
            BooleanQuestion(2, "Our solar system has 8 planets", true, QuestionType.SPACE),
            BooleanQuestion(3, "Our solar system has at least 2 dwarf planets", true, QuestionType.SPACE),
            BooleanQuestion(4, "Jupiter is the largest planet in our solar system", true, QuestionType.SPACE),
            BooleanQuestion(5, "Our solar system is in the Milky Way", true, QuestionType.SPACE),
            BooleanQuestion(6, "Mars is the 3rd planet from the Sun", false, QuestionType.SPACE),
            BooleanQuestion(7, "Saturn has rings", true, QuestionType.SPACE),
            BooleanQuestion(8, "Neptune is the farthest planet from the Sun", true, QuestionType.SPACE),
            BooleanQuestion(9, "The Earth has two moons", false, QuestionType.SPACE),
            BooleanQuestion(10, "The Moon has no atmosphere", false, QuestionType.SPACE),
            BooleanQuestion(11, "Mars is sometimes called the red planet", true, QuestionType.SPACE),
            BooleanQuestion(12, "Kuiper Belt includes dwarf planets", true, QuestionType.SPACE),

            // ARITHMETIC questions
            BooleanQuestion(13, "2 + 2 = 5", false, QuestionType.ARITHMETIC),
            BooleanQuestion(14, "7 x 8 = 56", true, QuestionType.ARITHMETIC),
            BooleanQuestion(15, "The square root of 25 is 5", true, QuestionType.ARITHMETIC),
            BooleanQuestion(16, "15 / 3 = 4", false, QuestionType.ARITHMETIC),
            BooleanQuestion(17, "2^10 = 1024", true, QuestionType.ARITHMETIC),
            BooleanQuestion(18, "Can 7.4 be rounded up?", false, QuestionType.ARITHMETIC),
            BooleanQuestion(19, "The sum of angles in a triangle is 180 degrees", true, QuestionType.ARITHMETIC),
            BooleanQuestion(20, "100 in binary is 4 in decimal", true, QuestionType.ARITHMETIC),

            // GENERAL knowledge questions
            BooleanQuestion(21, "Water boils at 100 degrees Celsius at sea level", true, QuestionType.GENERAL),
            BooleanQuestion(22, "The Great Wall of China is visible from space", false, QuestionType.GENERAL),
            BooleanQuestion(23, "Humans have 206 bones in the adult body", true, QuestionType.GENERAL),
            BooleanQuestion(24, "Lightning never strikes the same place twice", false, QuestionType.GENERAL),
            BooleanQuestion(25, "Octopuses have three hearts", true, QuestionType.GENERAL),
            BooleanQuestion(26, "Sound travels faster than light", false, QuestionType.GENERAL),
            BooleanQuestion(27, "The Amazon is the longest river in the world", false, QuestionType.GENERAL),
            BooleanQuestion(28, "Diamonds are made of carbon", true, QuestionType.GENERAL)
        )
    }

}