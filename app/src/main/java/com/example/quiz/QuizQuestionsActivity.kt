package com.example.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_quiz_questions.*
import kotlin.properties.Delegates

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var questionList: ArrayList<Question>
    private var curretentPosition = 1
    var acertos = 0
    var selectedAnswer = 0
    var correctAnswer = 0
    private var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        questionList = Constants.getQuestions()

        setQuestion()


        name =intent.getStringExtra("nome")




        tv_option1.setOnClickListener(this)
        tv_option2.setOnClickListener(this)
        tv_option3.setOnClickListener(this)
        tv_option4.setOnClickListener(this)
        button_submit.setOnClickListener(this)


    }

    private fun setQuestion() {
        button_submit.text = "SUBMIT"

        tv_option1.setTextColor(Color.parseColor("#7a8089"))
        tv_option1.typeface = Typeface.DEFAULT
        tv_option1.background = ContextCompat.getDrawable(this, R.drawable.default_selector)
        tv_option2.setTextColor(Color.parseColor("#7a8089"))
        tv_option2.typeface = Typeface.DEFAULT
        tv_option2.background = ContextCompat.getDrawable(this, R.drawable.default_selector)
        tv_option3.setTextColor(Color.parseColor("#7a8089"))
        tv_option3.typeface = Typeface.DEFAULT
        tv_option3.background = ContextCompat.getDrawable(this, R.drawable.default_selector)
        tv_option4.setTextColor(Color.parseColor("#7a8089"))
        tv_option4.typeface = Typeface.DEFAULT
        tv_option4.background = ContextCompat.getDrawable(this, R.drawable.default_selector)


        val question = questionList[curretentPosition - 1]

        progressBar.progress = curretentPosition
        tv_progress.text = ("$curretentPosition /10")
        image.setImageResource(question.image)

        tv_option1.text = question.option1
        tv_option2.text = question.option2
        tv_option3.text = question.option3
        tv_option4.text = question.option4

        correctAnswer = question.correctAnswer
    }


    override fun onClick(v: View) {

        if (v.id == R.id.tv_option1) {
            tv_option1.setTextColor(Color.parseColor("#000000"))
            tv_option1.setTypeface(tv_option1.typeface, Typeface.BOLD)
            tv_option1.background = ContextCompat.getDrawable(this, R.drawable.selected_border)
            selectedAnswer = 1

            tv_option2.setTextColor(Color.parseColor("#7a8089"))
            tv_option2.typeface = Typeface.DEFAULT
            tv_option2.background = ContextCompat.getDrawable(this, R.drawable.default_selector)
            tv_option3.setTextColor(Color.parseColor("#7a8089"))
            tv_option3.typeface = Typeface.DEFAULT
            tv_option3.background = ContextCompat.getDrawable(this, R.drawable.default_selector)
            tv_option4.setTextColor(Color.parseColor("#7a8089"))
            tv_option4.typeface = Typeface.DEFAULT
            tv_option4.background = ContextCompat.getDrawable(this, R.drawable.default_selector)


        }
        if (v.id == R.id.tv_option2) {
            tv_option2.setTextColor(Color.parseColor("#000000"))
            tv_option2.setTypeface(tv_option2.typeface, Typeface.BOLD)
            tv_option2.background = ContextCompat.getDrawable(this, R.drawable.selected_border)
            selectedAnswer = 2

            tv_option1.setTextColor(Color.parseColor("#7a8089"))
            tv_option1.typeface = Typeface.DEFAULT
            tv_option1.background = ContextCompat.getDrawable(this, R.drawable.default_selector)
            tv_option3.setTextColor(Color.parseColor("#7a8089"))
            tv_option3.typeface = Typeface.DEFAULT
            tv_option3.background = ContextCompat.getDrawable(this, R.drawable.default_selector)
            tv_option4.setTextColor(Color.parseColor("#7a8089"))
            tv_option4.typeface = Typeface.DEFAULT
            tv_option4.background = ContextCompat.getDrawable(this, R.drawable.default_selector)

        }

        if (v.id == R.id.tv_option3) {
            tv_option3.setTextColor(Color.parseColor("#000000"))
            tv_option3.setTypeface(tv_option3.typeface, Typeface.BOLD)
            tv_option3.background = ContextCompat.getDrawable(this, R.drawable.selected_border)
            selectedAnswer = 3

            tv_option2.setTextColor(Color.parseColor("#7a8089"))
            tv_option2.typeface = Typeface.DEFAULT
            tv_option2.background = ContextCompat.getDrawable(this, R.drawable.default_selector)
            tv_option1.setTextColor(Color.parseColor("#7a8089"))
            tv_option1.typeface = Typeface.DEFAULT
            tv_option1.background = ContextCompat.getDrawable(this, R.drawable.default_selector)
            tv_option4.setTextColor(Color.parseColor("#7a8089"))
            tv_option4.typeface = Typeface.DEFAULT
            tv_option4.background = ContextCompat.getDrawable(this, R.drawable.default_selector)

        }

        if (v.id == R.id.tv_option4) {
            tv_option4.setTextColor(Color.parseColor("#000000"))
            tv_option4.setTypeface(tv_option4.typeface, Typeface.BOLD)
            tv_option4.background = ContextCompat.getDrawable(this, R.drawable.selected_border)
            selectedAnswer = 4

            tv_option2.setTextColor(Color.parseColor("#7a8089"))
            tv_option2.typeface = Typeface.DEFAULT
            tv_option2.background = ContextCompat.getDrawable(this, R.drawable.default_selector)
            tv_option3.setTextColor(Color.parseColor("#7a8089"))
            tv_option3.typeface = Typeface.DEFAULT
            tv_option3.background = ContextCompat.getDrawable(this, R.drawable.default_selector)
            tv_option1.setTextColor(Color.parseColor("#7a8089"))
            tv_option1.typeface = Typeface.DEFAULT
            tv_option1.background = ContextCompat.getDrawable(this, R.drawable.default_selector)

        }

        if (v.id == R.id.button_submit) {

            if (selectedAnswer == 0) {
                curretentPosition++

                when {
                    curretentPosition <= questionList.size
                    -> {
                        setQuestion()
                    }
                    else
                    -> {
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra("nome",name)
                        intent.putExtra("acertos",acertos)
                        startActivity(intent)
                        finish()


                    }

                }

            } else {
                val question = questionList.get(curretentPosition - 1)
                if (question.correctAnswer != selectedAnswer) {
                    answerView(selectedAnswer, R.drawable.wrong_option_border)
                } else {
                    acertos++
                }
                answerView(correctAnswer, R.drawable.correct_option_border)


                if (curretentPosition == questionList.size) {
                    button_submit.text = "Fim"

                    val intent = Intent(this, ResultActivity::class.java)

                    val bundle = Bundle()
                    bundle.putString("nome", name)
                    bundle.putInt("acertos", acertos)
                    intent.putExtras(bundle)

                    startActivity(intent)

                } else {
                    button_submit.text = "SUBMIT"
                }
                selectedAnswer = 0

            }
        }


    }

    private fun answerView(answer: Int, OptionBorder: Int) {

        when (answer) {
            1 -> {
                tv_option1.background =
                    ContextCompat.getDrawable(this, OptionBorder)
            }
            2 -> {
                tv_option2.background =
                    ContextCompat.getDrawable(this, OptionBorder)
            }
            3 -> {
                tv_option3.background =
                    ContextCompat.getDrawable(this, OptionBorder)

            }
            4 -> {
                tv_option4.background =
                    ContextCompat.getDrawable(this, OptionBorder)
            }
        }

    }


}