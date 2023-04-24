package com.example.monstrehunter

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "monstre", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE MonstresCaptures(id INTEGER PRIMARY KEY, nom TEXT, description TEXT, niveau INTEGER, image TEXT)")
        db?.execSQL("CREATE TABLE Monstres(id INTEGER PRIMARY KEY, nom TEXT, description TEXT, image TEXT)")
        db?.execSQL("CREATE TABLE Cartes(id INTEGER PRIMARY KEY, nom TEXT, image TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS MonstresCaptures")
        db?.execSQL("DROP TABLE IF EXISTS Monstres")
        db?.execSQL("DROP TABLE IF EXISTS Cartes")
        onCreate(db)
    }
}
