package com.github.blackdark.kotlintest

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {

    private var isImageChecked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerRadioListener()
        initializeSpinner()
        fillScrollView()
    }

    private fun fillScrollView() {
        val textView = findViewById(R.id.TextView02) as TextView
        var string: String = ""

        for (i in 0..100) {
            string += "some String jau. "
        }

        textView.text = string
    }

    private fun initializeSpinner() {
        val spinner: Spinner = findViewById(R.id.spinner) as Spinner
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, R.array.ides_array, android.R.layout.simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    private fun registerRadioListener() {
        val radioGroup: RadioGroup = findViewById(R.id.orientation) as RadioGroup

        radioGroup.setOnCheckedChangeListener({ group, checkedId ->
            when(checkedId) {
                R.id.horizontal -> {
                    group.orientation = LinearLayout.HORIZONTAL
                }
                R.id.vertical -> {
                    group.orientation = LinearLayout.VERTICAL
                }
            }
        })
    }

    fun onClick(view: View) {
        val editText: EditText = findViewById(R.id.main_input) as EditText
        Toast.makeText(this, editText.text.toString(), Toast.LENGTH_SHORT).show()

        val imageView = findViewById(R.id.imageTest) as ImageView

        if (isImageChecked) {
            imageView.setImageResource(R.drawable.unchecked)
            isImageChecked = false
        } else {
            imageView.setImageResource(R.drawable.plus)
            isImageChecked = true
        }
    }

    fun openActivityPart1(view: View) {
        val intent = Intent(this, AndroidTutorialPart1::class.java)
        startActivity(intent)
    }

    fun openFragmentActivity(view: View) {
        val intent = Intent(this, FragmentActivity::class.java)
        startActivity(intent)
    }

    fun openSharedPref(view: View) {
        val intent = Intent(this, SharedPrefActivity::class.java)
        startActivity(intent)
    }
}
