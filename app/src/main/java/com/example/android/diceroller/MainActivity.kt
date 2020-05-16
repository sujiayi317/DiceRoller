package com.example.android.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //specify which layout is associated with the activity, and you inflate the layout:
        setContentView(R.layout.activity_main)

        // get a reference to the View with a specific ID:
        val rollButton: Button = findViewById(R.id.roll_button)
        /*A click handler is a method that is invoked each time the user clicks or taps on
        a clickable UI element, such as a button. To create a click handler you need:
        1.A method that performs some operation.
        2.The setOnClickListener() method, which connects the Button to the handler method.*/
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
//        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "Dice Rolled!"
    }

}
