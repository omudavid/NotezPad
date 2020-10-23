package com.hackerman.notezpad.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class SplashActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Intent(this,MainActivity::class.java).also {
            GlobalScope.launch {
                withContext(Dispatchers.IO){
                    delay(3000)
                }
                startActivity(it)
                finish()
            }

        }
    }
}