package com.johan.restaurante11.adapter

import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.johan.restaurante11.Menu
import com.johan.restaurante11.R

class MenuviewHolder (view:View):RecyclerView.ViewHolder(view){

    val Menu=view.findViewById<TextView>(R.id.tvMenuname)
    val realname=view.findViewById<TextView>(R.id.tvrealname)
    val publisher=view.findViewById<TextView>(R.id.tvpublisher)
    val foto=view.findViewById<ImageView>(R.id.ivMenu)

    fun render(menumodel: Menu) {
        Menu.text=menumodel.Menu
        realname.text=menumodel.realname
        publisher.text=menumodel.publisher

        Glide.with(foto.context).load(menumodel.foto).into(foto)

    }
}