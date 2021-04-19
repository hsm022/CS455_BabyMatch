package com.example.babymatch

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView

class PlayActivity : AppCompatActivity() {
    private lateinit var myTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        val difficulty = intent.getStringExtra("EXTRA_DIFFICULTY")
        val level = intent.getStringExtra("EXTRA_LEVEL")
        val won = intent.getStringExtra("EXTRA_WIN")

        if(difficulty == "Easy" && level == "One") {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, FirstFragment())
                .commit()
            //start the timer
            startTimeCounter(30000)
            
        }
        else if(difficulty == "Easy" && level == "Two") {
           // wMessage.text = "Fragment 2"
        }
        else if(difficulty == "Easy" && level == "Three") {
           // wMessage.text = "Fragment 3"
        }
        else if(difficulty == "Medium" && level == "One") {
            //wMessage.text = "Fragment 4"
        }
        else if(difficulty == "Medium" && level == "Two") {
           // wMessage.text = "Fragment 5"
        }
        else if(difficulty == "Medium" && level == "Three") {
           // wMessage.text = "Fragment 6"
        }
        else if(difficulty == "Hard" && level == "One") {
           // wMessage.text = "Fragment 7"
        }
        else if(difficulty == "Hard" && level == "Two") {
            //wMessage.text = "Fragment 8"
        }
        else {
            //wMessage.text = "Fragment 9"
        }
    }

    private fun startTimeCounter(time:Long) {
        val countTime: TextView = findViewById(R.id.timer)
        myTimer = object: CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                countTime.text = (millisUntilFinished / 1000).toString()
            }
            override fun onFinish() {
                countTime.text = "Time is UP"
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, TimeUpFragmentFragment())
                        .commit()
            }
        }.start()
    }


}