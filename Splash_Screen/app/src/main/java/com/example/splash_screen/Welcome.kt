package com.example.splash_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        var sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor =  sharedPref.edit()


        val logout = findViewById<Button>(R.id.btlogout)
        logout.setOnClickListener {
            editor.clear()
            editor.commit()

            startActivity(Intent(applicationContext,LoginScreen::class.java))
            finish()
        }
    }
}

class Signup : AppCompatActivity(){

}
