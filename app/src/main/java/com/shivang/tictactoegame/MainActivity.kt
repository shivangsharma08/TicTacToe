package com.shivang.tictactoegame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.random.Random
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun buClick(view: View) {
        val buSelected = view as Button
        var cellID = 0
        when (buSelected.id) {
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
        //Toast.makeText(this,"ID:"+cellID, Toast.LENGTH_LONG).show()
        playGame(cellID, buSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1
    fun playGame(cellID: Int, buSelected: Button) {

        if (activePlayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellID)
            activePlayer = 2
            autoPlay()
        } else if(activePlayer==2) {
            buSelected.text = "O"
            buSelected.setBackgroundColor(Color.RED)
            player2.add(cellID)
            activePlayer = 1
        }
        else{
            finish()
        }

        buSelected.isEnabled = false
        checkWinner()
    }

    fun checkWinner() {
        var winner = -1
        //row 1

            if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
                winner = 1
                activePlayer=0
            }
            if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
                winner = 2
                activePlayer=0
            }

            //row 2
            if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
                winner = 1
                activePlayer=0
            }
            if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
                winner = 2
                activePlayer=0
            }

            //row 3
            if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
                winner = 1
                activePlayer=0
            }
            if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
                winner = 2
                activePlayer=0
            }

            //col 1
            if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
                winner = 1
                activePlayer=0
            }
            if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
                winner = 2
                activePlayer=0
            }

            //col 2
            if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
                winner = 1
                activePlayer=0
            }
            if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
                winner = 2
                activePlayer=0
            }

            //col 3
            if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
                winner = 1
                activePlayer=0
            }
            if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
                winner = 2
                activePlayer=0
            }
            //diag 1
            if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
                winner = 1
                activePlayer=0
            }
            if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
                winner = 2
                activePlayer=0

            }

            //diag 2
            if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
                winner = 1
                activePlayer=0
            }
            if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
                winner = 2
                activePlayer=0
            }
        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 wins the game!!", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this, "Player 2 wins the game!!", Toast.LENGTH_LONG).show()

            }
        }
    }
    fun autoPlay(){
        var emptyCells=ArrayList<Int>()
        for(cellID in 1..9){
            if(!(player1.contains(cellID) || player2.contains(cellID))){
                emptyCells.add(cellID)
            }
        }
        val r= Random
        val randIndx = r.nextInt(emptyCells.size-0)+0
        val cellID = emptyCells[randIndx]

        var buSelect:Button?

        when(cellID){
            1->buSelect=button1
            2->buSelect=button2
            3->buSelect=button3
            4->buSelect=button4
            5->buSelect=button5
            6->buSelect=button6
            7->buSelect=button7
            8->buSelect=button8
            9->buSelect=button9
            else->{
                buSelect=button1
            }
        }
        playGame(cellID, buSelect)

    }

}


