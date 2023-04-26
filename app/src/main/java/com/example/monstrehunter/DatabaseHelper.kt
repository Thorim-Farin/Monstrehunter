package com.example.monstrehunter

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "monstre", null, 4) {
    val db : SQLiteDatabase = writableDatabase
    init {
        db?.execSQL("CREATE TABLE IF NOT EXISTS MonstresCaptures(nom TEXT , type TEXT, description TEXT, niveau INTEGER, image TEXT)")
        db?.execSQL("CREATE TABLE IF NOT EXISTS Monstres(nom TEXT , description TEXT, image TEXT)")
        db?.execSQL("CREATE TABLE IF NOT EXISTS Cartes(nom TEXT , image TEXT)")

        //ajout de monstre
        db?.execSQL("INSERT INTO Monstres(nom, description, image) VALUES ('Loup',  'Juste un loup','monstre.')")
        db?.execSQL("INSERT INTO MonstresCaptures(nom, type, description, niveau, image) VALUES ('Loup', 'normal', 'Juste un loup', 1,'monstre.')")
        db?.execSQL("INSERT INTO Cartes(nom, image) VALUES ('Loup','monstre.')")
    }
    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertMonstreCpature(monstres: Monstre) {
        db?.execSQL("INSERT INTO MonstresCaptures(nom, type , description, niveau, image) " +
                "VALUES (nom = Monstre.nom.toString, type = Monstre.type, description = Monstre.description, niveau = Monstre.niveau, image = Monstre.image)")
    }

    fun insertMonstre(monstres: Monstre) {
        db?.execSQL("INSERT INTO Monstres(nom, description, image) VALUES (Monstre.nom,Monstre.description,Monstre.image)")
    }

    fun insertCartes(monstres: Monstre) {
        db?.execSQL("INSERT INTO Cartes(nom, image) VALUES (Monstre.nom,Monstre.image)")
    }
}
