package com.brasserie.livraison

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.brasserie.livraison.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Thread{
            Thread.sleep(3000)
            Log.e("H","HELLO")
        }.start()
    }
}