package com.github.blackdark.kotlintest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val intent = intent
        val message = intent.getStringExtra(AndroidTutorialPart1.EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById(R.id.textView2) as TextView
        textView.text = message
    }
}
