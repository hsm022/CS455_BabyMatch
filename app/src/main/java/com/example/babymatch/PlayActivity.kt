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

        //Select a fragment and time based on user's selection
        if(difficulty == getString(R.string.easy) && level == getString(R.string.one)) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LevelOneFragment(30000))
                .commit()
        }
        else if(difficulty == getString(R.string.easy) && level == getString(R.string.two)) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LevelTwoFragment(40000))
                .commit()
        }
        else if(difficulty == getString(R.string.easy) && level == getString(R.string.three)) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LevelThreeFragment(50000))
                .commit()
        }
        else if(difficulty == getString(R.string.medium) && level == getString(R.string.one)) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LevelOneFragment(20000))
                .commit()
        }
        else if(difficulty == getString(R.string.medium) && level == getString(R.string.two)) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LevelTwoFragment(25000))
                .commit()
        }
        else if(difficulty == getString(R.string.medium) && level == getString(R.string.three)) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LevelThreeFragment(30000))
                .commit()
        }
        else if(difficulty == getString(R.string.hard) && level == getString(R.string.one)) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LevelOneFragment(10000))
                .commit()
        }
        else if(difficulty == getString(R.string.hard) && level == getString(R.string.two)) {
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