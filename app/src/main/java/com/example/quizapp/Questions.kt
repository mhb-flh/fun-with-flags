package com.example.quizapp

data class Questions (
    val id:Int,
    val question:String,
    val image:Int,
    val option1:Int,
    val option2:Int,
    val option3:Int,
    val option4:Int,
    val correctAnswer:Int)
{
}