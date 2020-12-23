package com.example.teste_desenvolvedor_android.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teste_desenvolvedor_android.Model.Client
import com.example.teste_desenvolvedor_android.R
import com.example.teste_desenvolvedor_android.ViewHolder.ClientViewHolder

class ClientAdapter : RecyclerView.Adapter<ClientViewHolder>() {

    private var listClients = listOf<Client>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_client, parent, false)
        return ClientViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listClients.size
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        val client = listClients[position]
        holder.bind(client, position)
    }

    fun updateItemClient(newClient: List<Client>) {
        this.listClients = newClient
        notifyDataSetChanged()
    }

}