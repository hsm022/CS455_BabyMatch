package com.example.babymatch

import android.app.AlertDialog
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class LevelOneFragment(timeGiven:Long) : Fragment() {

    //Variables
    private lateinit var myTimer: CountDownTimer
    var totalTime = timeGiven
    private lateinit var buttons: List<ImageButton>
    private lateinit var cards: List<BabyCard>
    private var selectedCard: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_level_one, container, false)
        val images = mutableListOf(R.drawable.baby_1,R.drawable.baby_2,R.drawable.baby_3,R.drawable.baby_4)

        //Add the images that exist again in images
        images.addAll(images)
        //Shuffle the order of images
        images.shuffle()

        //list of image buttons
        buttons = listOf(view.findViewById(R.id.imageButton1) as ImageButton, view.findViewById(R.id.imageButton2) as ImageButton,
                view.findViewById(R.id.imageButton3) as ImageButton, view.findViewById(R.id.imageButton4) as ImageButton,
                view.findViewById(R.id.imageButton5) as ImageButton, view.findViewById(R.id.imageButton6) as ImageButton,
                view.findViewById(R.id.imageButton7) as ImageButton, view.findViewById(R.id.imageButton8) as ImageButton)

        //create indices and map
        cards = buttons.indices.map{index->
            BabyCard(images[index])
        }

        //Start the timer
        startTimeCounter(totalTime,view)

        //set listener and perform the task
        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                //update models
                updatesModels(index)
                //update view
                updateViews()
                //check if user won
                checkWin()
            }
        }
        return view
    }

    //Check if all cards are have been matched/ user won
    private fun checkWin() {
        var flag = false
        for(card in cards) {
            if(!card.isMatched){
                flag = true
            }
        }
        if(!flag){
            //Stop the timer
            myTimer.cancel()

            //Create an alert dialog box
            val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
            builder.setTitle("Result")
            builder.setMessage("YOU WON!")
            //Setup an OK button for the alert dialog box
            builder.setPositiveButton("OK") { dialog, _ ->
                //Dismiss the alert
                dialog.dismiss()
                //Show a toast message on screen
                Toast.makeText(activity,"Good Job, play another level or difficulty",Toast.LENGTH_SHORT).show()
                //Back to main activity
                activity?.finish()
            }

            //Create alert and show it
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()

        }
    }

    // This function updates the UI part/the View part
    private fun updateViews() {
        cards.forEachIndexed { index, card ->
            val button = buttons[index]
            // change the opacity to indicate match
            if(card.isMatched) {
                button.alpha = 0.4f
            }
            //show a baby image if card is facing up else show the card image
            button.setImageResource(if (card.isFaceUp) card.identifier else R.drawable.card)
        }
    }

    // This function updates the Model
    private fun updatesModels(index: Int) {
        val card = cards[index]

        //user clicks an already flipped card
        if(card.isFaceUp) {
            Toast.makeText(activity,"Invalid",Toast.LENGTH_SHORT).show()
            return
        }

        // 0 or 2 card are already flipped, rearrange cards
        if(selectedCard == null) {
            rearrangeCards()
            selectedCard = index
        }

        // 1 card is already flipped, check match
        else {
            checkMatch(selectedCard!!, index)
            selectedCard = null
        }
        card.isFaceUp = !card.isFaceUp
    }

    //This function makes all the unmatched card face down
    private fun rearrangeCards() {
        for(card in cards) {
            if(!card.isMatched) {
                card.isFaceUp = false
            }
        }
    }

    //This function checks if two cards match
    private fun checkMatch(index1: Int, index2: Int) {
        if (cards[index1].identifier == cards[index2].identifier){
            //cards match therefore update the isMatched property
            cards[index1].isMatched = true;
            cards[index2].isMatched = true;
        }
    }

    // This function creates the count down and also alerts the user when he/she loses
    private fun startTimeCounter(totalTime:Long, view: View) {
        val countTime: TextView = view.findViewById(R.id.timer)
        myTimer = object: CountDownTimer(totalTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                countTime.text = "Time Left: " + (millisUntilFinished / 1000).toString() + " seconds"
            }
            override fun onFinish() {
                //Time is up, update the timer
                countTime.text = "Time is UP, YOU LOST!"

                //Create an alert dialog box
                val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
                builder.setTitle("Result")
                builder.setMessage("YOU LOST!")
                //Setup an OK button for the alert dialog box
                builder.setPositiveButton("OK") { dialog, _ ->
                    //Dismiss the alert
                    dialog.dismiss()
                    //Show a toast message on screen
                    Toast.makeText(activity,"Don't Worry, Try Again!",Toast.LENGTH_SHORT).show()
                    //Back to main activity
                    activity?.finish()
                }

                //Create alert and show it
                val alertDialog: AlertDialog = builder.create()
                alertDialog.show()
            }
        }.start()
    }
}