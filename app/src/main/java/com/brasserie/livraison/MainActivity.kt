package com.brasserie.livraison

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.brasserie.livraison.databinding.ActivityMainBinding
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val auth = FirebaseAuth.getInstance()
        val starterIntent = Intent(this,HomeActivity::class.java)
        val signInLauncher = registerForActivityResult(FirebaseAuthUIActivityResultContract()) { result ->
            if(result.resultCode == RESULT_OK && auth.currentUser != null) {
                Log.e("USER", Gson().toJson(auth.currentUser))
                startActivity(starterIntent)
            }
        }

        Thread{
            Thread.sleep(3000)
            if (auth.currentUser != null){
                val authProviders = arrayListOf(AuthUI.IdpConfig.PhoneBuilder().build())
                val signInIntent = AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(authProviders)
                    .setLogo(R.drawable.logo_brasimba_rdcongo)
                    .build()
                signInLauncher.launch(signInIntent)
            }
            else
                startActivity(starterIntent)
        }.start()
    }
}