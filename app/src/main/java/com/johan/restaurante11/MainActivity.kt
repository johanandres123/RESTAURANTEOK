package com.johan.restaurante11

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private var edtusuario: EditText? = null
    private var edtclave: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtusuario = findViewById(R.id.edtusuario)
        edtclave = findViewById(R.id.edtclave)

    }

    fun login(btnentrar: View) {
        val username: String = edtusuario!!.text.toString()
        val password: String = edtclave!!.text.toString()
        val positiveBotton = { dialog: DialogInterface, entero: Int ->
            val intento = Intent(this, welcomeMenu::class.java)
            startActivity(intento)
            Toast.makeText(this, "se lanzo otra actividad", Toast.LENGTH_LONG).show()

        }
        val negativeBotton = { xx: DialogInterface, yy: Int -> }
        if (username == "usuario@" && password == "1234") {
            Toast.makeText(this, "Credenciales correctas", Toast.LENGTH_LONG).show()
            val dialogo = AlertDialog.Builder(this)
                .setTitle("Bienvenido" + username)
                .setMessage(R.string.alert_mensaje)
                .setPositiveButton("OK", positiveBotton)
                .setNegativeButton("cancel", negativeBotton)
                .create().show()


        } else {
            Toast.makeText(this, "contraseña o usuario incorrecto", Toast.LENGTH_LONG).show()
        }
    }
}