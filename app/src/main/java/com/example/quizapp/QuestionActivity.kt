package com.example.quizapp

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityQuestionBinding

private lateinit var binding: ActivityQuestionBinding

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition = 1
    private var mQuestionList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition = 0
    private var mCorrectAnswers = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestions()
        setQuestions()

        binding.option1.setOnClickListener(this)
        binding.option2.setOnClickListener(this)
        binding.option3.setOnClickListener(this)
        binding.option4.setOnClickListener(this)
        binding.checkAnswer.setOnClickListener(this)


    }

    fun setQuestions() {

        val question = mQuestionList?.get(mCurrentPosition - 1)
        defaultOptionsView()

        if (mCurrentPosition == mQuestionList!!.size) {
            binding.checkAnswer.text = resources.getText(R.string.finish)
        } else {
            binding.checkAnswer.text = getString(R.string.check_answer_btn)
        }


        binding.progressBar.progress = mCurrentPosition
        binding.tvProgress.text = "$mCurrentPosition" + "/" + binding.progressBar.max
        binding.tvQuestion.text = question!!.question
        binding.ivImage.setImageResource(question.image)

        binding.option1.text = getString(question.option1)
        binding.option2.text = getString(question.option2)
        binding.option3.text = getString(question.option3)
        binding.option4.text = getString(question.option4)

    }

    private fun defaultOptionsView() {

        val optionView = ArrayList<TextView>()
        optionView.add(0, binding.option1)
        optionView.add(1, binding.option2)
        optionView.add(2, binding.option3)
        optionView.add(3, binding.option4)

        for (option in optionView) {
            option.typeface = Typeface.DEFAULT
            option.setTextColor(resources.getColor(R.color.white))
            option.background = ContextCompat.getDrawable(this, R.drawable.tv_border)
        }
    }

    private fun selectedOption(tv: TextView, selectedOptionNumber: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background = ContextCompat.getDrawable(this, R.drawable.tv_border_clicked)
    }

    private fun answerView(answer: Int, drawable: Int) {
        when (answer) {
            1 -> {
                binding.option1.background = ContextCompat.getDrawable(this, drawable)
                binding.option1.setTextColor(resources.getColor(R.color.primaryDark))
            }
            2 -> {
                binding.option2.background = ContextCompat.getDrawable(this, drawable)
                binding.option2.setTextColor(resources.getColor(R.color.primaryDark))
            }
            3 -> {
                binding.option3.background = ContextCompat.getDrawable(this, drawable)
                binding.option3.setTextColor(resources.getColor(R.color.primaryDark))
            }
            4 -> {
                binding.option4.background = ContextCompat.getDrawable(this, drawable)
                binding.option4.setTextColor(resources.getColor(R.color.primaryDark))
            }
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.option1 -> {
                selectedOption(binding.option1, 1)
            }
            R.id.option2 -> {
                selectedOption(binding.option2, 2)
            }
            R.id.option3 -> {
                selectedOption(binding.option3, 3)
            }
            R.id.option4 -> {
                selectedOption(binding.option4, 4)
            }
            R.id.check_answer -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestions()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.tv_wrong)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.tv_correct)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        binding.checkAnswer.text = getString(R.string.finish)
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWER, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                        startActivity(intent)
                        finish()
                    } else {
                        binding.checkAnswer.text = getString(R.string.next_question)
                    }
                }
                mSelectedOptionPosition = 0

            }
        }
    }


}