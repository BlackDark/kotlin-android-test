package com.github.blackdark.kotlintest

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView

class SharedPrefActivity : AppCompatActivity() {

    private val THE_KEY = "The_key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)
    }

    fun saveSharedPrefData(view: View) {
        val sharedPreferences = getSharedPreferences(getString(R.string.sharedPrefActivity_test), Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val text = findViewById(R.id.sharedPrefText) as EditText
        editor.putString(THE_KEY, text.text.toString())
        editor.apply()
    }

    fun updateSharedPrefView(view: View) {
        val sharedPreferences = getSharedPreferences(getString(R.string.sharedPrefActivity_test), Context.MODE_PRIVATE)
        val text = findViewById(R.id.sharedPrefTextView) as TextView
        text.text = sharedPreferences.getString(THE_KEY, null)
    }
}
