package com.brasserie.livraison

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomerAdapter(private val customers: ArrayList<Customer>) :
    RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>(), Filterable{
    var filteredCustomers: ArrayList<Customer> = arrayListOf()

    class CustomerViewHolder(cardview: View) : RecyclerView.ViewHolder(cardview) {
        val tvCustomerEstablishmentName = cardview.findViewById<TextView>(R.id.tv_customer_establishment_name)!!
        val tvCustomerNameAddress = cardview.findViewById<TextView>(R.id.tv_customer_name_address)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        return CustomerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cardview_customer,parent,false))
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val customer = customers[position]
        val customerNameAddress = StringBuilder(customer.name + " - " + customer.address)
        holder.tvCustomerEstablishmentName.text = customer.establishmentName
        holder.tvCustomerNameAddress.text = customerNameAddress
    }

    override fun getItemCount(): Int {
        return customers.size
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filter = constraint.toString().lowercase()
                Log.e("FILTER",filter)
                Log.e("FILTERED_CUSTOMERS", filteredCustomers.size.toString())
                if(filter.isEmpty())
                    filteredCustomers = customers
                else{
                    val filteredList: ArrayList<Customer> = ArrayList()
                    Log.e("FILTERED_LIST_BEFORE",filteredList.size.toString())
                    for (customer in customers){
                        if(customer.establishmentName.lowercase().contains(filter) ||
                            customer.name.lowercase().contains(filter) ||
                            customer.address.lowercase().contains(filter)){
                            filteredList.add(customer)
                        }
                    }
                    Log.e("FILTERED_LIST_AFTER",filteredList.size.toString())
                    filteredCustomers = filteredList
                }
                val results = FilterResults()
                results.values = filteredCustomers
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredCustomers = results?.values as ArrayList<Customer>
                Log.e("RESULTS",filteredCustomers.size.toString())
                notifyDataSetChanged()
            }
        }
    }
}