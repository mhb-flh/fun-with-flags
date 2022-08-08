package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizapp.databinding.ActivityQuestionBinding
import com.example.quizapp.databinding.ActivityResultBinding

private lateinit var binding: ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        var username=intent.getStringExtra(Constants.USER_NAME)
        binding.username.text=username
        var correctAnswers=intent.getIntExtra(Constants.CORRECT_ANSWER,0)
        var totalQuestions=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        binding.score.text=" $correctAnswers out of $totalQuestions"

        binding.btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}