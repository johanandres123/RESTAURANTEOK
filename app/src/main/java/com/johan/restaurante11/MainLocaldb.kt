package com.johan.restaurante11

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.johan.restaurante11.databinding.ActivityLocaldbBinding


class MainLocaldb : AppCompatActivity() {
    lateinit var binding: ActivityLocaldbBinding
    lateinit var menuDBRestaurante: MySQLResturante


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLocaldbBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menuDBRestaurante = MySQLResturante(this)

        binding.btnguardar.setOnClickListener {
            val nombre = binding.etnombre.text.toString()
            val correo = binding.etcorreo.text.toString()
            if (nombre.isNotBlank() && correo.isNotBlank()) {
                menuDBRestaurante.agregardatos(nombre, correo)

                binding.etnombre.text.clear()
                binding.etcorreo.text.clear()
                Toast.makeText(this, "Guardado con Exito", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No se Pudo Guardar", Toast.LENGTH_SHORT).show()

            }
        }
        binding.btnlistar.setOnClickListener {
            binding.tvinfo.text = ""
            val db: SQLiteDatabase = menuDBRestaurante.readableDatabase
            val cursor = db.rawQuery("SELECT * FROM menu", null)
            if (cursor.moveToFirst()) {
                do {
                    binding.tvinfo.append(cursor.getInt(0).toString() + ": ")
                    binding.tvinfo.append(cursor.getString(1).toString() + " Usuario Restaurante ")
                    binding.tvinfo.append(cursor.getString(2).toString() + " \n")

                } while (cursor.moveToNext())
            }
        }

        binding.btnborrar.setOnClickListener {
            var ID = binding.etid.text
            if (ID.isNotBlank()) {
                menuDBRestaurante.eliminar(ID.toString().toInt())
                binding.etid.text.clear()
                Toast.makeText(this, "Registro Eliminado", Toast.LENGTH_SHORT).show()


            } else {
                Toast.makeText(this, "Debe Ingresar el ID", Toast.LENGTH_SHORT).show()


            }
        }
        binding.btnactualizar.setOnClickListener {
            val ID = binding.etid.text
            val nombre = binding.etnombre.text
            val correo = binding.etcorreo.text
            if (ID.isNotBlank() && nombre.isNotBlank() && correo.isNotBlank()) {

                menuDBRestaurante.editar(ID.toString().toInt(),
                    nombre.toString(),
                    correo.toString())

                ID.clear()
                nombre.clear()
                correo.clear()
                Toast.makeText(this, "Se actualizo Satisfactoriamente", Toast.LENGTH_SHORT)
                    .show()


            } else {
                Toast.makeText(this, "Debe ingresar el ID", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnlistar1.setOnClickListener {
            val ID = binding.etid.text
            if (ID.isNotBlank()) {
                val db: SQLiteDatabase = menuDBRestaurante.readableDatabase
                val cursor = db.rawQuery("SELECT * FROM menu WHERE id=" + ID, null)
                if (cursor.moveToFirst()) {
                    binding.etnombre.setText(cursor.getString(1).toString())
                    binding.etcorreo.setText(cursor.getString(2).toString())
                } else {
                    Toast.makeText(this, "El ID no Existe", Toast.LENGTH_SHORT).show()  }

            } else {
                Toast.makeText(this, "Debe ingresar el ID", Toast.LENGTH_SHORT).show() }

        }
    }
}





