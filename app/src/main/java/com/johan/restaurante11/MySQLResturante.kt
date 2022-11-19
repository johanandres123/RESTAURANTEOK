package com.johan.restaurante11

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySQLResturante (context: Context): SQLiteOpenHelper(context, "menuDB.db",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val ordenCreacion="CREATE TABLE menu"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT, correo TEXT)"
        db!!.execSQL(ordenCreacion)

    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenBorrado ="DROP TABLE IF EXISTS menu"
        db!!.execSQL(ordenBorrado)
        onCreate(db)
    }

    fun agregardatos(nombre:String,email:String){
        val datos= ContentValues()
        datos.put("nombre",nombre)
        datos.put("correo",email)

        //Guardar datos en la base de datos
        val db=this.writableDatabase
        db.insert("menu",null,datos)
        db.close()
    }

    fun eliminar(id:Int){
        val args= arrayOf(id.toString())
        val db = this.writableDatabase
        db.delete("menu","id=?",args)
        db.close()

    }
    fun editar(id:Int,nombre:String,email: String) {
        val args = arrayOf(id.toString())

        val datos=ContentValues()
        datos.put("nombre",nombre)
        datos.put("correo",email)

        val db=this.writableDatabase
        db.update("menu",datos,"id=?",args)
        db.close()
    }
}