package com.example.simplerandomizer

// <<------------------------------------------------------------------------------------------>> //

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.*

// <<------------------------------------------------------------------------------------------>> //

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.rollButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val quantityTextView = findViewById<TextView>(R.id.quantityTextView)

        rollButton.setOnClickListener {
            val random = Random().nextInt(seekBar.progress) + 1
            resultTextView.text = random.toString()
        }

        seekBar.min = 1
        seekBar.max = 20

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                quantityTextView.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }
}
