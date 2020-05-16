package com.example.android.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * DiceRoller demonstrates simple interactivity in an Android app.
 * It contains one button that updates an image view with a dice
 * vector image with a random value between 1 and 6.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //associates the layout with the activity,
        // and inflates that layout when the activity is created.
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        /*A click handler is a method that is invoked each time the user clicks or taps on
        a clickable UI element, such as a button. To create a click handler you need:
        1.A method that performs some operation.
        2.The setOnClickListener() method, which connects the Button to the handler method.*/
        rollButton.setOnClickListener { rollDice() }

        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener { countUp() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
    }

    /**
     * Click listener for the Roll button.
     */
    private fun rollDice() {
//        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.text = "Dice Rolled!"
        val randomInt = (1..6).random()
        resultText.text = randomInt.toString()
    }

    /**
     * Click listener for the countUp button.
     */
    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        val str = resultText.text.toString()
        if (str == "Hello World!") resultText.text = "1" else {
            var resultInt = resultText.text.toString().toInt()

            if (resultInt < 6) {
                resultInt++
                resultText.text = resultInt.toString()
            }
        }
    }

    /**
     * Click listener for the reset button.
     */
    private fun reset() {
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "0"
    }

}
