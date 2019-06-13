package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun restartActivity (view: View) {
        recreate()
    }

    fun buttonOnClick(view: View) {
        val clickedButton = view as Button
        var cellID = 0
        when (clickedButton.id) {
            R.id.button1 -> cellID = 1
            R.id.button2 -> cellID = 2
            R.id.button3 -> cellID = 3
            R.id.button4 -> cellID = 4
            R.id.button5 -> cellID = 5
            R.id.button6 -> cellID = 6
            R.id.button7 -> cellID = 7
            R.id.button8 -> cellID = 8
            R.id.button9 -> cellID = 9
        }
        playGame(cellID, clickedButton)
    }

    private val player1 = mutableListOf<Int>()
    private val player2 = mutableListOf<Int>()

    private var activePlayer = 1

    private fun playGame(cellID: Int, clickedButton: Button) {
        if (activePlayer == 1) {
            clickedButton.text = "X"
            clickedButton.setBackgroundColor(Color.parseColor("#009193"))
            player1 += (cellID)
            activePlayer = 2
        } else {
            clickedButton.text = "o"
            clickedButton.setBackgroundColor(Color.parseColor("#FF9300"))
            player2 += (cellID)
            activePlayer = 1
        }
        clickedButton.isEnabled = false
        whoIsWinner()
    }

    private fun whoIsWinner() {
        var winner = -1
        when {
            player1.containsAll(listOf(1, 2, 3)) ||
                    player1.containsAll(listOf(4, 5, 6)) ||
                    player1.containsAll(listOf(7, 8, 9)) ||
                    player1.containsAll(listOf(1, 4, 7)) ||
                    player1.containsAll(listOf(2, 5, 8)) ||
                    player1.containsAll(listOf(3, 6, 9)) ||
                    player1.containsAll(listOf(1, 5, 9)) ||
                    player1.containsAll(listOf(7, 5, 3)) -> winner = 1

            player2.containsAll(listOf(1, 2, 3)) ||
                    player2.containsAll(listOf(4, 5, 6)) ||
                    player2.containsAll(listOf(7, 8, 9)) ||
                    player2.containsAll(listOf(1, 4, 7)) ||
                    player2.containsAll(listOf(2, 5, 8)) ||
                    player2.containsAll(listOf(3, 6, 9)) ||
                    player2.containsAll(listOf(1, 5, 9)) ||
                    player2.containsAll(listOf(7, 5, 3)) -> winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 wins", Toast.LENGTH_LONG).show()
                recreate()
            }
            else {
                Toast.makeText(this, "Player 2 wins", Toast.LENGTH_LONG).show()
                recreate()
            }
        }
    }
}