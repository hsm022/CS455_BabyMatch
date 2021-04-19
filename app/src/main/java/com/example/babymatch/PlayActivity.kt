package com.example.babymatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        val difficulty = intent.getStringExtra("EXTRA_DIFFICULTY")
        val level = intent.getStringExtra("EXTRA_LEVEL")

        if(difficulty == "Easy" && level == "One") {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, EasyFragment(30000))
                .commit()
        }
        else if(difficulty == "Easy" && level == "Two") {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, MediumFragment(35000))
                .commit()
        }
        else if(difficulty == "Easy" && level == "Three") {

        }
        else if(difficulty == "Medium" && level == "One") {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, EasyFragment(20000))
                .commit()
        }
        else if(difficulty == "Medium" && level == "Two") {
           // wMessage.text = "Fragment 5"
        }
        else if(difficulty == "Medium" && level == "Three") {
           // wMessage.text = "Fragment 6"
        }
        else if(difficulty == "Hard" && level == "One") {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, EasyFragment(10000))
                .commit()
        }
        else if(difficulty == "Hard" && level == "Two") {
            //wMessage.text = "Fragment 8"
        }
        else {
            //wMessage.text = "Fragment 9"
        }
    }




}