package com.example.teste_desenvolvedor_android.DataSource

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_CLIENT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        db!!.execSQL("drop table ${DatabaseDefinitions.Client.TABLE_NAME}")
        db!!.execSQL(CREATE_TABLE_CLIENT)

    }

    companion object {
        private const val DATABASE_NAME = "client.db"
        private const val DATABASE_VERSION = 1

        private const val CREATE_TABLE_CLIENT = "CREATE TABLE ${DatabaseDefinitions.Client.TABLE_NAME} (" +
                "${DatabaseDefinitions.Client.Columns.ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${DatabaseDefinitions.Client.Columns.NAME} TEXT, " +
                "${DatabaseDefinitions.Client.Columns.EMAIL} TEXT, " +
                "${DatabaseDefinitions.Client.Columns.CEP} TEXT, " +
                "${DatabaseDefinitions.Client.Columns.STREET} TEXT, " +
                "${DatabaseDefinitions.Client.Columns.NEIGHBORHOOD} TEXT, " +
                "${DatabaseDefinitions.Client.Columns.CITY} TEXT, " +
                "${DatabaseDefinitions.Client.Columns.STATE} TEXT);"
    }
}