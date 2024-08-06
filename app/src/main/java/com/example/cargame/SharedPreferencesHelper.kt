package com.example.cargame

import android.content.Context

class SharedPreferencesHelper(context: Context) {

    private val PREFS_NAME = "com.example.cargame"
    private val HIGH_SCORE_KEY = "high_score"

    private val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun getHighScore(): Int {
        return sharedPreferences.getInt(HIGH_SCORE_KEY, 0)
    }

    fun setHighScore(score: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(HIGH_SCORE_KEY, score)
        editor.apply()
    }
}
