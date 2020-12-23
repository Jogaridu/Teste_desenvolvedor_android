package com.example.teste_desenvolvedor_android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.teste_desenvolvedor_android.Model.Client
import com.example.teste_desenvolvedor_android.Repository.ClientRepository

class MainViewModel(private val repository: ClientRepository): ViewModel() {

    private var clientLiveData = MutableLiveData<Client>()
    val listAllClients = MutableLiveData<ArrayList<Client>>()

    fun save(client: Client) : Boolean {

        val id = repository.save(client)

        if (id !== null) {
            return true
        }

        return false

    }

    fun getClients() : ArrayList<Client> {
        return repository.getClients()
    }

    class MainViewModelFactory(
        private val repository: ClientRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }
    }


}