package com.example.teste_desenvolvedor_android.Repository

import android.content.ContentValues
import android.content.Context
import com.example.teste_desenvolvedor_android.DataSource.DatabaseDefinitions
import com.example.teste_desenvolvedor_android.DataSource.DatabaseHelper
import com.example.teste_desenvolvedor_android.Model.Client

class ClientRepository(context: Context) {

    private val dbHelper = DatabaseHelper(context)

    fun save(client: Client) : Int {

        val database = dbHelper.writableDatabase

        val newClient = ContentValues()

        newClient.put(DatabaseDefinitions.Client.Columns.NAME, client.name)
        newClient.put(DatabaseDefinitions.Client.Columns.EMAIL, client.email)
        newClient.put(DatabaseDefinitions.Client.Columns.STREET, client.street)
        newClient.put(DatabaseDefinitions.Client.Columns.NEIGHBORHOOD, client.neighborhood)
        newClient.put(DatabaseDefinitions.Client.Columns.CEP, client.cep)
        newClient.put(DatabaseDefinitions.Client.Columns.CITY, client.city)
        newClient.put(DatabaseDefinitions.Client.Columns.STATE, client.state)

        val id = database.insert(DatabaseDefinitions.Client.TABLE_NAME, null, newClient)

        return id.toInt()
    }

    fun getClients() : ArrayList<Client> {
        val database = dbHelper.readableDatabase

        val cursor = database.query(DatabaseDefinitions.Client.TABLE_NAME,
            null, null, null, null, null, null)

        var clients = ArrayList<Client>()

        if (cursor !== null) {
            while (cursor.moveToNext()) {
                var client = Client(
                    id = cursor.getInt(cursor.getColumnIndex(DatabaseDefinitions.Client.Columns.ID)),
                    name = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Client.Columns.NAME)),
                    email = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Client.Columns.EMAIL)),
                    cep= cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Client.Columns.CEP)),
                    street = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Client.Columns.STREET)),
                    neighborhood = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Client.Columns.NEIGHBORHOOD)),
                    city = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Client.Columns.CITY)),
                    state = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Client.Columns.STATE))

                )

                clients.add(client)
            }
        }

        return clients
    }
}