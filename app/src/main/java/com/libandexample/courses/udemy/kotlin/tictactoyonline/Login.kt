package com.libandexample.courses.udemy.kotlin.tictactoyonline

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.libandexample.courses.udemy.kotlin.noteapp.MainActivity
import com.libandexample.R
import kotlinx.android.synthetic.main.activity_login_tictactoeonline.*


class Login : AppCompatActivity() {

    private var mAuth:FirebaseAuth?=null

    private var database= FirebaseDatabase.getInstance()
    private var myRef=database.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_tictactoeonline)
        mAuth= FirebaseAuth.getInstance()

    }


    fun buLoginEvent() {

        LoginToFireBase(etEmail.text.toString(),etPassword.text.toString())
    }


    private fun LoginToFireBase(email:String, password:String){

        mAuth!!.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){ task ->

                    if (task.isSuccessful){
                        Toast.makeText(applicationContext,"Successful login",Toast.LENGTH_LONG).show()

                        val currentUser =mAuth!!.currentUser
                        //save in database
                        if(currentUser!=null) {
                            myRef.child("Users").child(SplitString(currentUser.email.toString())).child("Request").setValue(currentUser.uid)
                        }

                        LoadMain()

                    }else
                    {
                        Toast.makeText(applicationContext,"fail login",Toast.LENGTH_LONG).show()
                    }

                }

    }

     override fun onStart() {
        super.onStart()
         LoadMain()
    }


    private fun  LoadMain(){
       val currentUser =mAuth!!.currentUser

        if(currentUser!=null) {


            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("email", currentUser.email)
            intent.putExtra("uid", currentUser.uid)

            startActivity(intent)
            finish()
        }
    }

    private fun  SplitString(str:String):String{
        val split=str.split("@")
        return split[0]
    }
}

