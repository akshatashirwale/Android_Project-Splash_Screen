package com.example.splash_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.content.SharedPreferences
import android.widget.EditText
import android.widget.Toast
import java.lang.Boolean.TRUE


class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        var SharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        var editor= SharedPref.edit()
        val btlogin = findViewById<Button>(R.id.btlogin)
        val signup =  findViewById<Button>(R.id.signuplogin)
        val get = getset()

        signup.setOnClickListener {
            startActivity(Intent(applicationContext,Signup::class.java))
            finish()
        }

        btlogin.setOnClickListener {
            val usrnameid = findViewById<EditText>(R.id.edtTxt)
            get.usrname = usrnameid.text.toString()

            val passid = findViewById<EditText>(R.id.edttxtpass)
            get.pass = passid.text.toString()

            if(get.usrname.equals(get.usrnamed)&& get.pass.equals(get.passd)){
                startActivity(Intent(applicationContext,Welcome::class.java))
                finish()

                editor.putBoolean("flag", TRUE)
                editor.commit()

            }
            else{
                Toast.makeText(applicationContext,"UserName & Password Incorrect", Toast.LENGTH_SHORT).show()

            }

        }
    }
}