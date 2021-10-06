package com.brasserie.livraison

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomerAdapter(private val customers : ArrayList<Customer>) :
    RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {

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
}