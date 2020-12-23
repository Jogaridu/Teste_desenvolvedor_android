package com.example.teste_desenvolvedor_android.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.teste_desenvolvedor_android.Model.Client
import kotlinx.android.synthetic.main.card_client.view.*

class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun bind(item: Client, position: Int) {
        itemView.cardClientName.text = item.name
        itemView.cardClientEmail.text = item.email
        itemView.cardClientCep.text = item.cep
        itemView.cardClientStreet.text = item.street
        itemView.cardClientCity.text = item.city
        itemView.cardClientState.text = item.state
    }
}