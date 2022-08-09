package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityMainBinding

private lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.btnStart.setOnClickListener {
            if (binding.name.text.toString().isNotEmpty()) {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME,binding.name.text.toString())
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(
                    this,
                    resources.getString(R.string.Enter_your_name),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    }
}