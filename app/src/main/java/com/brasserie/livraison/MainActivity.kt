package com.brasserie.livraison

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brasserie.livraison.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Thread{
            Thread.sleep(3000)
            startActivity(Intent(this,HomeActivity::class.java))
        }.start()
    }
}