package com.example.babymatch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        //Get extras from main activity
        val difficulty = intent.getStringExtra("EXTRA_DIFFICULTY")
        val level = intent.getStringExtra("EXTRA_LEVEL")

        //
        if(difficulty == "Easy" && level == "One") {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LevelOneFragment(30000))
                .commit()
        }
        else if(difficulty == "Easy" && level == "Two") {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LevelTwoFragment(40000))
                .commit()
        }
        else if(difficulty == "Easy" && level == "Three") {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LevelThreeFragment(50000))
                .commit()
        }
        else if(difficulty == "Medium" && level == "One") {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LevelOneFragment(20000))
                .commit()
        }
        else if(difficulty == "Medium" && level == "Two") {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LevelTwoFragment(25000))
                .commit()
        }
        else if(difficulty == "Medium" && level == "Three") {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LevelThreeFragment(30000))
                .commit()
        }
        else if(difficulty == "Hard" && level == "One") {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LevelOneFragment(10000))
                .commit()
        }
        else if(difficulty == "Hard" && level == "Two") {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LevelTwoFragment(15000))
                .commit()
        }
        else {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LevelThreeFragment(20000))
                .commit()
        }
    }
}