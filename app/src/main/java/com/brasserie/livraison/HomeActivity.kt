package com.brasserie.livraison

import android.app.SearchManager
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brasserie.livraison.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var rvCustomers: RecyclerView
    private lateinit var customers: ArrayList<Customer>
    private lateinit var customerAdapter: CustomerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        rvCustomers = binding.rvCustomers
        customers = arrayListOf()
        customers.add(Customer("Yannick","Bar Numéro 1","02,Av. Basange"))
        customers.add(Customer("Christelle","ESIS","05,Av. Femme Katangaise"))
        customers.add(Customer("Steve","Ngwasuma","10,Av. Babemba"))
        customerAdapter = CustomerAdapter(customers)
        rvCustomers.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        rvCustomers.adapter = customerAdapter
        binding.fabNewCustomer.setOnClickListener {
            Toast.makeText(this,R.string.app_name,Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.customer_searchable,menu)
        val searchManager = getSystemService(SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.menu_customer_search)?.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                customerAdapter.filter.filter(query)
                rvCustomers.adapter = customerAdapter
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                customerAdapter.filter.filter(newText)
                rvCustomers.adapter = customerAdapter
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}