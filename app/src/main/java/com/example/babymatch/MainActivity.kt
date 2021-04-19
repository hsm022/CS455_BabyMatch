package com.example.babymatch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //creating variables
    private lateinit var btnPlay: Button
    private lateinit var rgDifficulty: RadioGroup
    private lateinit var rgLevel: RadioGroup
    private lateinit var wMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //defining variables
        btnPlay = findViewById(R.id.button_play)
        rgDifficulty = findViewById(R.id.radio_difficulty)
        rgLevel = findViewById(R.id.radio_level)
        wMessage = findViewById(R.id.welcome)

        //Play button has been clicked
        btnPlay.setOnClickListener { _: View ->
            //Get IDs of the selected radio buttons
            val difficultyID = rgDifficulty.checkedRadioButtonId
            val levelID = rgLevel.checkedRadioButtonId

            //get the radio button from the radio button id
            val difficulty = findViewById<RadioButton>(difficultyID)
            val level = findViewById<RadioButton>(levelID)

            //new activity
           Intent(this, PlayActivity::class.java).also {
               it.putExtra("EXTRA_DIFFICULTY",difficulty.text.toString())
               it.putExtra("EXTRA_LEVEL",level.text.toString())
               startActivity(it)
           }

        }
    }
}