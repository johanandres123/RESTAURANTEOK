package com.johan.restaurante11


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class welcomeMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_menu)
        setSupportActionBar(R.id.my_barra)
        val fab:View=findViewById(R.id.fab)

        fab.setOnClickListener{View->
            Snackbar.make(View,"Adicionar Pedido",Snackbar.LENGTH_LONG).show()
            val llamado = Intent(this, NavigationActivity::class.java)
            startActivity(llamado)
        }

    }

    private fun setSupportActionBar(myBarra: Int) {

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bar,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean=  when (item.itemId) {
        R.id.itm_buscar_comandas ->{
            Toast.makeText( this, "Buscar ", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.itm_ayuda ->{
            Toast.makeText( this, "Ayuda ", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.itm_Eliminar ->{
            Toast.makeText( this, "Eliminar ", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.itm_crear_comanda ->{
            val intento= Intent(this,MenuActivity::class.java)
            startActivity(intento)
            Toast.makeText( this, "Menu ", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.itm_crear_cliente ->{
            Toast.makeText( this, "Informacion para su pedido ", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.itm_sugerencias->{
            Toast.makeText( this, "Informacion para Mejorar ", Toast.LENGTH_SHORT).show()
            true
        }

        else ->{
            super.onOptionsItemSelected(item)
        }
    }

}