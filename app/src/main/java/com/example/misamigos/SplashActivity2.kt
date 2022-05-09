package com.example.misamigos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_splash2.*

class SplashActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)
        Glide.with(applicationContext).load(R.drawable.splaht).into(fondi)
        startTimer()
    }
    // se cre una funcion para crear un timer par que se pase en un cierto tiempo a la otra activity
    fun startTimer(){
        object: CountDownTimer(5000,1000){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                val intento = Intent(applicationContext, MainActivity::class.java)
                startActivity(intento)
                finish()
            }
        }.start()
    }
    }
