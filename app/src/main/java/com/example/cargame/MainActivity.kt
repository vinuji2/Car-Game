package com.example.cargame

import android.os.Bundle
import android.text.BoringLayout
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(),GameTask {
        lateinit var rootLayout: LinearLayout
        lateinit var startBtn: Button
        lateinit var mGameView: GameView
        lateinit var score:TextView
        lateinit var highScore: TextView
        var currentScore = 0

        lateinit var sharedPreferencesHelper: SharedPreferencesHelper
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBtn = findViewById(R.id.startBtn)
        rootLayout = findViewById(R.id.rootLayout)
        score = findViewById(R.id.score)
            highScore = findViewById(R.id.highScore)
            sharedPreferencesHelper = SharedPreferencesHelper(this)


            mGameView = GameView(this,this)

        startBtn.setOnClickListener{
            mGameView.setBackgroundResource(R.drawable.road)
            rootLayout.addView(mGameView)
            startBtn.visibility = View.GONE
            score.visibility = View.GONE
            highScore.visibility = View.GONE
        }
            highScore.text = "High Score: ${sharedPreferencesHelper.getHighScore()}"

    }

    override fun closeGame(mScore: Int) {

        currentScore = mScore
        if (currentScore > sharedPreferencesHelper.getHighScore()) {
            sharedPreferencesHelper.setHighScore(currentScore)
            highScore.text = "High Score: $currentScore"
        }

        // Update TextViews
        score.text = "Score : $mScore"

        rootLayout.removeView(mGameView)
        startBtn.visibility = View.VISIBLE
        score.visibility = View.VISIBLE
        highScore.visibility = View.VISIBLE

    }
}