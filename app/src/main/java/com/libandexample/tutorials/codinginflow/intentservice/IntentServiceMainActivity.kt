package com.libandexample.tutorials.codinginflow.intentservice

import android.content.Intent
import android.os.Bundle
import android.widget.EditText

import com.libandexample.R

import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class IntentServiceMainActivity : AppCompatActivity() {
    private val editTextInput: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

    }

    fun startService() {
        val input = editTextInput!!.text.toString()

        val serviceIntent = Intent(this, ExampleIntentService::class.java)
        serviceIntent.putExtra("inputExtra", input)

        ContextCompat.startForegroundService(this, serviceIntent)
    }
}
