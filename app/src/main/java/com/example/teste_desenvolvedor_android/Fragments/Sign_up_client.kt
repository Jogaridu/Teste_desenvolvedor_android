package com.example.teste_desenvolvedor_android.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.teste_desenvolvedor_android.MainViewModel
import com.example.teste_desenvolvedor_android.Model.Client
import com.example.teste_desenvolvedor_android.R
import com.example.teste_desenvolvedor_android.Repository.ClientRepository
import kotlinx.android.synthetic.main.fragment_sign_up_client.*

class Sign_up_client : Fragment(), View.OnClickListener {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up_client, container, false)

        viewModel = ViewModelProvider(
            this,
            MainViewModel.MainViewModelFactory(ClientRepository(view.context))
        ).get(MainViewModel::class.java)

        val button = view.findViewById<Button>(R.id.buttonSign)
        button.setOnClickListener(this)

        return view
    }

    override fun onClick(item: View) {
        when(item.id) {
            R.id.buttonSign -> {
                val sucesss = saveClient()

                if (sucesss) {
                    Log.i("teste","Deu certo")
                } else {
                    print("Não deeeeeu certo")
                }

            }
        }
    }

    private fun saveClient() : Boolean {
        val client = Client(
            name = name.text.toString(),
            email = email.text.toString(),
            cep = cep.text.toString(),
            street = street.text.toString(),
            neighborhood = neighborhood.text.toString(),
            city = city.text.toString(),
            state = state.text.toString()
        )

        return viewModel.save(client)
    }

}
