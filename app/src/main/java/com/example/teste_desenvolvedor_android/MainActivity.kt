package com.example.teste_desenvolvedor_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.teste_desenvolvedor_android.Fragments.List_all_clients
import com.example.teste_desenvolvedor_android.Fragments.Sign_up_client
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var listClients: List_all_clients
    private lateinit var signUpClient: Sign_up_client

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listClients = List_all_clients()
        signUpClient = Sign_up_client()

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        setFragment(signUpClient)

    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame_fragments, fragment)
        fragmentTransition.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_sign_up -> {
                setFragment(signUpClient)
            }

            R.id.menu_list_clients -> {
                setFragment(listClients)
            }
        }

        return true
    }
}
