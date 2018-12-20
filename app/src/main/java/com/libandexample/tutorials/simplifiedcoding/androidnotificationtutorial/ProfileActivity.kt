package com.libandexample.tutorials.simplifiedcoding.androidnotificationtutorial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.iid.FirebaseInstanceId
import com.libandexample.R

class ProfileActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mAuth = FirebaseAuth.getInstance()

        FirebaseInstanceId.getInstance().instanceId
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val token = task.result!!.token
                        saveToken(token)
                    }
                }
    }

    override fun onStart() {
        super.onStart()

        if (mAuth!!.currentUser == null) {
            val intent = Intent(this, AndroidNotificationMainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
    }

    private fun saveToken(token: String) {
        val email = mAuth!!.currentUser!!.email
        val user = User(email!!, token)

        val dbUsers = FirebaseDatabase.getInstance().getReference(NODE_USERS)

        dbUsers.child(mAuth!!.currentUser!!.uid)
                .setValue(user).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@ProfileActivity, "Token Saved", Toast.LENGTH_LONG).show()
                    }
                }

    }

    companion object {

        private val NODE_USERS = "users"
    }
}
