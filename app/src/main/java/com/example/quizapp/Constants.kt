package com.example.quizapp

object Constants {

    const val USER_NAME:String ="user_name"
    const val TOTAL_QUESTIONS:String ="total_questions"
    const val CORRECT_ANSWER:String ="correct_answers"

    fun getQuestions() : ArrayList<Questions> {
        val QuestionList = ArrayList<Questions>()

        val Que1 = Questions(
            1,
            "what country does this flag belong to?",
            R.drawable.ic_australia_flag,
            R.string.q1option1,
            R.string.q1option2,
            R.string.q1option3,
            R.string.q1option4,
            3)

        val Que2 = Questions(
            2,
            "what country does this flag belong to?",
            R.drawable.ic_brazil_flag,
            R.string.q2option1 ,
            R.string.q2option2 ,
            R.string.q2option3 ,
            R.string.q2option4 ,
            1
        )
        val Que3 = Questions(
            3,
            "what country does this flag belong to?",
            R.drawable.ic_canada_flag,
            R.string.q3option1 ,
            R.string.q3option2 ,
            R.string.q3option3 ,
            R.string.q3option4 ,
            1
        )
        val Que4 = Questions(
            4,
            "what country does this flag belong to?",
            R.drawable.ic_china_flag,
            R.string.q4option1 ,
            R.string.q4option2 ,
            R.string.q4option3 ,
            R.string.q4option4 ,
            4
        )
        val Que5 = Questions(
            5,
            "what country does this flag belong to?",
            R.drawable.ic_israel_flag,
            R.string.q5option1 ,
            R.string.q5option2 ,
            R.string.q5option3 ,
            R.string.q5option4 ,
            4
        )
        val Que6 = Questions(
            6,
            "what country does this flag belong to?",
            R.drawable.ic_japan_flag,
            R.string.q6option1 ,
            R.string.q6option2 ,
            R.string.q6option3 ,
            R.string.q6option4 ,
            2
        )
        val Que7 = Questions(
            7,
            "what country does this flag belong to?",
            R.drawable.ic_saudi_arabia_flag,
            R.string.q7option1 ,
            R.string.q7option2 ,
            R.string.q7option3 ,
            R.string.q7option4 ,
            1
        )
        val Que8 = Questions(
            8,
            "what country does this flag belong to?",
            R.drawable.ic_turkey_flag,
            R.string.q8option1 ,
            R.string.q8option2 ,
            R.string.q8option3 ,
            R.string.q8option4 ,
            2
        )
        val Que9 = Questions(
            9,
            "what country does this flag belong to?",
            R.drawable.ic_united_kingdom_flag,
            R.string.q9option1 ,
            R.string.q9option2 ,
            R.string.q9option3 ,
            R.string.q9option4 ,
            2
        )
        val Que10 = Questions(
            10,
            "what country does this flag belong to?",
            R.drawable.ic_united_states_of_america_flag,
            R.string.q10option1 ,
            R.string.q10option2 ,
            R.string.q10option3 ,
            R.string.q10option4 ,
            1
        )


        QuestionList.add(Que1)
        QuestionList.add(Que2)
        QuestionList.add(Que3)
        QuestionList.add(Que4)
        QuestionList.add(Que5)
        QuestionList.add(Que6)
        QuestionList.add(Que7)
        QuestionList.add(Que8)
        QuestionList.add(Que9)
        QuestionList.add(Que10)
        return QuestionList
    }


}