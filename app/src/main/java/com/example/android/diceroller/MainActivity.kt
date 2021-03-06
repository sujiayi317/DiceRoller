package com.example.android.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

/**
 * DiceRoller demonstrates simple interactivity in an Android app.
 * It contains one button that updates an image view with a dice
 * vector image with a random value between 1 and 6.
 *
 * Challenge: Modify the DiceRoller app to have two dice. When the user taps the Roll button,
 * each die should have a value independent of the other.
 * Tip: Create a new private function to get a random drawable image and return an integer for
 * the drawable resource. Use that function for each of the die images.
 *
 * In 2018, Google announced Android Jetpack, which is a collection of libraries that includes
 * many of the previous classes and functions of the support library, while also expanding on
 * the support library.
 * The namespace for the Android Jetpack libraries is androidx
 */
class MainActivity : AppCompatActivity() {

    // The lateinit keyword promises the Kotlin compiler that the variable will be initialized
    // before the code calls any operations on it.
    // Minimize the calls to findViewById() in your code by declaring fields to hold those views,
    // and initializing the fields in onCreate(). Use the lateinit keyword for the field to avoid
    // needing to declare it nullable.
    lateinit var diceImage : ImageView
    lateinit var diceImage2 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //associates the layout with the activity,
        // and inflates that layout when the activity is created.
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)

        val rollButton: Button = findViewById(R.id.roll_button)
        /*A click handler is a method that is invoked each time the user clicks or taps on
        a clickable UI element, such as a button. To create a click handler you need:
        1.A method that performs some operation.
        2.The setOnClickListener() method, which connects the Button to the handler method.*/
        rollButton.setOnClickListener { rollDice() }

//        val countUpButton: Button = findViewById(R.id.count_up_button)
//        countUpButton.setOnClickListener { countUp() }
//
//        val resetButton: Button = findViewById(R.id.reset_button)
//        resetButton.setOnClickListener { reset() }

        val clearButton: Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener { clear() }

        Timber.i("onCreate called")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Called")
    }

    private fun clear() {
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
    }

    /**
     * Click listener for the Roll button.
     *
     * Use setImageResource() to change the view's image to a different resource.
     * Use R.drawable to refer to specific drawables, e.g. setImageResource(R.drawable.image_name)
     */
    private fun rollDice() {
        diceImage.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
    }

    private fun getRandomDiceImage() : Int {
        val randomInt = (1..6).random()
        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }


//    private fun rollDice() {
////        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
//        //val resultText: TextView = findViewById(R.id.result_text)
////        resultText.text = "Dice Rolled!"
//        val randomInt = (1..6).random()
//        //resultText.text = randomInt.toString()
//
//        // this is not efficient!!! :  val diceImage: ImageView = findViewById(R.id.dice_image)
//        val drawableResource = when (randomInt) {
//            1 -> R.drawable.dice_1
//            2 -> R.drawable.dice_2
//            3 -> R.drawable.dice_3
//            4 -> R.drawable.dice_4
//            5 -> R.drawable.dice_5
//            else -> R.drawable.dice_6
//        }
//        diceImage.setImageResource(drawableResource)
//    }



//    /**
//     * Click listener for the countUp button.
//     */
//    private fun countUp() {
//        val resultText: TextView = findViewById(R.id.result_text)
//        val str = resultText.text.toString()
//        if (str == "Hello World!") resultText.text = "1" else {
//            var resultInt = resultText.text.toString().toInt()
//
//            if (resultInt < 6) {
//                resultInt++
//                resultText.text = resultInt.toString()
//            }
//        }
//    }
//
//    /**
//     * Click listener for the reset button.
//     */
//    private fun reset() {
//        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.text = "0"
//    }

}
