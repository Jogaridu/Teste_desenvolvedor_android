package com.example.teste_desenvolvedor_android.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teste_desenvolvedor_android.Adapter.ClientAdapter
import com.example.teste_desenvolvedor_android.MainViewModel
import com.example.teste_desenvolvedor_android.R
import com.example.teste_desenvolvedor_android.Repository.ClientRepository


class List_all_clients : Fragment() {

    private lateinit var recyclerViewClients: RecyclerView
    private val clientsAdapter = ClientAdapter()

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list_all_clients, container, false)

        viewModel = ViewModelProvider(
            this,
            MainViewModel.MainViewModelFactory(ClientRepository(view.context))
        ).get(MainViewModel::class.java)

        recyclerViewClients = view.findViewById(R.id.recyclerViewClients)
        recyclerViewClients.layoutManager = LinearLayoutManager(view.context)
        recyclerViewClients.adapter = clientsAdapter

        clientsAdapter.updateItemClient(viewModel.getClients())

        return view
    }


}
