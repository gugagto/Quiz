package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        button_finish.setOnClickListener(this)



        val name= intent.getStringExtra("nome")
        val acertos = intent.getIntExtra("acertos",0)


            tv_Acertos.text = "Your score is $acertos of 10"
            tv_name.text=name

        }




    override fun onClick(v: View?) {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }


}