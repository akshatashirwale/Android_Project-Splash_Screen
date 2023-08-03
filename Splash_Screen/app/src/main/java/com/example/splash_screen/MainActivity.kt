package com.example.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Timer
import java.util.TimerTask
import java.lang.Boolean
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var get = getset()
        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        var flag: kotlin.Boolean = sharedPref.getBoolean("flag", Boolean.FALSE)
        Timer().schedule(object : TimerTask() {
            override fun run() {
                if (flag) {
                    startActivity(Intent(applicationContext, Welcome::class.java))
                    finish()
                } else {
                    startActivity(Intent(applicationContext, LoginScreen::class.java))
                    finish()
                }
            }
        }, 1000)
    }
}


