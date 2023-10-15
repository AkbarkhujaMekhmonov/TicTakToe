package com.akbar_prog.tictaktoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {
    var activePlayer=0
    var gameState= intArrayOf(2,2,2,2,2,2,2,2,2)
    var winningPositions= arrayOf(intArrayOf(0,1,2),intArrayOf(3,4,5),intArrayOf(6,7,8),intArrayOf(0,3,6),intArrayOf(1,4,7),intArrayOf(2,5,8),intArrayOf(0,4,8),intArrayOf(2,4,6))
    var gameactive=true
    public fun dropped(view: View){
        var counter:ImageView=view as ImageView


        var tappedCounter=parseInt(counter.getTag().toString())
        if(gameState[tappedCounter]==2&&gameactive) {


            gameState[tappedCounter] = activePlayer
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow)
                activePlayer = 1
            } else {
                counter.setImageResource(R.drawable.red)
                activePlayer = 0
            }
            counter.translationY = (-1500).toFloat()
            counter.animate().translationYBy(1500F).rotation(3600F).duration = 300

            for (winningPosition in winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    var winner = ""
                    if (activePlayer == 1) winner = "Yellow"
                    else winner = "Red"
                    gameactive=false
                    Toast.makeText(this, "$winner is winner", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
