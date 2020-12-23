package com.example.teste_desenvolvedor_android.DataSource

class DatabaseDefinitions {
    object Client {
        const val TABLE_NAME = "client"

        object Columns {
            const val ID = "id"
            const val NAME = "name"
            const val EMAIL = "email"
            const val CEP = "cep"
            const val STREET = "street"
            const val NEIGHBORHOOD = "neighborhood"
            const val CITY = "city"
            const val STATE = "state"
        }
    }
}