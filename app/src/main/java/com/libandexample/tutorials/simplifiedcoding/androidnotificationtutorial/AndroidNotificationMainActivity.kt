package com.libandexample.tutorials.simplifiedcoding.androidnotificationtutorial

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.libandexample.R

import java.util.Objects

import androidx.appcompat.app.AppCompatActivity

class AndroidNotificationMainActivity : AppCompatActivity() {

    private var editTextEmail: EditText? = null
    private var editTextPassword: EditText? = null
    private var progressBar: ProgressBar? = null

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        mAuth = FirebaseAuth.getInstance()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            channel.description = CHANNEL_DESC
            val manager = getSystemService(NotificationManager::class.java)
            Objects.requireNonNull(manager).createNotificationChannel(channel)
        }

        progressBar = findViewById(R.id.progressbar)
        progressBar!!.visibility = View.INVISIBLE
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)

        findViewById<View>(R.id.buttonSignUp).setOnClickListener { createUser() }

    }

    private fun createUser() {
        val email = editTextEmail!!.text.toString().trim { it <= ' ' }
        val password = editTextEmail!!.text.toString().trim { it <= ' ' }

        if (email.isEmpty()) {
            editTextEmail!!.error = "Email required"
            editTextEmail!!.requestFocus()
            return
        }

        if (password.isEmpty()) {
            editTextPassword!!.error = "Password required"
            editTextPassword!!.requestFocus()
            return
        }

        if (password.length < 6) {
            editTextPassword!!.error = "Password should be atleast 6 char long"
            editTextPassword!!.requestFocus()
            return
        }

        progressBar!!.visibility = View.VISIBLE
        mAuth!!.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->

                    if (task.isSuccessful) {
                        startProfileActivity()
                    } else {
                        if (task.exception is FirebaseAuthUserCollisionException) {
                            userLogin(email, password)
                        } else {
                            progressBar!!.visibility = View.INVISIBLE
                            Toast.makeText(this@AndroidNotificationMainActivity, task.exception!!.message, Toast.LENGTH_LONG).show()
                        }
                    }

                }
    }

    private fun userLogin(email: String, password: String) {

        mAuth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startProfileActivity()
                    } else {
                        progressBar!!.visibility = View.INVISIBLE
                        Toast.makeText(this@AndroidNotificationMainActivity, task.exception!!.message, Toast.LENGTH_LONG).show()
                    }
                }
    }

    override fun onStart() {
        super.onStart()
        if (mAuth!!.currentUser != null) {
            startProfileActivity()
        }
    }

    private fun startProfileActivity() {
        val intent = Intent(this, ProfileActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

    companion object {

        //1. Notification Channel
        //2. Notification Builder
        //3. Notification Manager

        val CHANNEL_ID = "simplified_coding"
        private val CHANNEL_NAME = "Simplified Coding"
        private val CHANNEL_DESC = "Simplified Coding Notifications"
    }


}