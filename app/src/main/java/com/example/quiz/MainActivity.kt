package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button_start.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        if (edit_name.text.toString().isEmpty()) {
            Toast.makeText(this, "Digite seu nome", Toast.LENGTH_SHORT).show()
        } else {

            val name = edit_name.text.toString()


           val intent= Intent(this,QuizQuestionsActivity::class.java)
          intent.putExtra("nome",name)
            startActivity(intent)
            finish()


        }
    }
}