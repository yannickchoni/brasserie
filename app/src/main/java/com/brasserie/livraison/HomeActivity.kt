package com.brasserie.livraison

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brasserie.livraison.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val rvCustomers = binding.rvCustomers
        val customers = arrayListOf<Customer>()
        customers.add(Customer("Yannick","Bar Numéro 1","02,Av. Basange"))
        customers.add(Customer("Christelle","ESIS","05,Av. Femme Katangaise"))
        customers.add(Customer("Steve","Ngwasuma","10,Av. Babemba"))
        rvCustomers.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        rvCustomers.adapter = CustomerAdapter(customers)
        binding.fabNewCustomer.setOnClickListener { view ->
            Toast.makeText(this,R.string.app_name,Toast.LENGTH_LONG).show()
        }
    }
}