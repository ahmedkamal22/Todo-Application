package com.kamal.todoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplachScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splach_screen)
        Handler(Looper.getMainLooper()).postDelayed({
            GoToHomeActivity()
        },2000)
    }

    private fun GoToHomeActivity() {
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}