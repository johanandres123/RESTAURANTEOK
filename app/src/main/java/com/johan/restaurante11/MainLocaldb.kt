package com.johan.restaurante11

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.johan.restaurante11.databinding.ActivityLocaldbBinding


class MainLocaldb : AppCompatActivity() {
    lateinit var binding: ActivityLocaldbBinding
    lateinit var menuDBRestaurante:MySQLResturante


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityLocaldbBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menuDBRestaurante=MySQLResturante(this)

        binding.btnguardar.setOnClickListener{
            val nombre=binding.etnombre.text.toString()
            val correo=binding.etcorreo.text.toString()
            if(nombre.isNotBlank() && correo.isNotBlank()){
                menuDBRestaurante.agregardatos(nombre,correo)

                binding.etnombre.text.clear()
                binding.etcorreo.text.clear()
                Toast.makeText(this, "Guardado con Exito", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "No se Pudo Guardar", Toast.LENGTH_SHORT).show()

            }}
        binding.btnlistar.setOnClickListener{
            binding.tvinfo.text=""
            val db: SQLiteDatabase =menuDBRestaurante.readableDatabase
            val cursor =db.rawQuery("SELECT * FROM menu",null)
            if (cursor.moveToFirst()){
                do{
                    binding.tvinfo.append(cursor.getInt(0).toString()+": ")
                    binding.tvinfo.append(cursor.getString(1).toString()+" Usuario Restaurante ")
                    binding.tvinfo.append(cursor.getString(2).toString()+" \n")

                }while (cursor.moveToNext())
            }
        }
    }
}