package com.example.babymatch

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.ImageButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class FirstFragment : Fragment() {

    //Variables
    private lateinit var buttons: List<ImageButton>
    private lateinit var cards: List<BabyCard>
    private var selectedCard: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val images = mutableListOf(R.drawable.baby_1,R.drawable.baby_2,R.drawable.baby_3,R.drawable.baby_4)

        //Add the images that exist again in images
        images.addAll(images)
        //Shuffle the order of images
        images.shuffle()
        //Add one more image two times
        images.add(images[1])
        images.add(images[1])
        //Shuffle the order of images again so that the last two images don't appear together
        images.shuffle()

        buttons = listOf(view.findViewById(R.id.imageButton1) as ImageButton, view.findViewById(R.id.imageButton2) as ImageButton,
                view.findViewById(R.id.imageButton3) as ImageButton, view.findViewById(R.id.imageButton4) as ImageButton,
                view.findViewById(R.id.imageButton5) as ImageButton, view.findViewById(R.id.imageButton6) as ImageButton,
                view.findViewById(R.id.imageButton7) as ImageButton, view.findViewById(R.id.imageButton8) as ImageButton,
                view.findViewById(R.id.imageButton9) as ImageButton, view.findViewById(R.id.imageButton10) as ImageButton)

        //create indices and map
        cards = buttons.indices.map{index->
            BabyCard(images[index])
        }

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
            //Close the fragment
            Toast.makeText(activity,"YOU WON",Toast.LENGTH_SHORT).show()
            //new activity
           // Intent (activity, PlayActivity::class.java).also {
            //    it.putExtra("EXTRA_WIN","WON")
            //    activity?.startActivity(it)
            //}

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
}