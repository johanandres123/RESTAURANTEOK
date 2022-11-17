package com.johan.restaurante11.adapter

import android.view.LayoutInflater
import android.view.Menu
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.johan.restaurante11.MenuProveer.Companion.Menulist
import com.johan.restaurante11.R


class MenuAdapter (private val Menulist:List<Menu>):RecyclerView.Adapter<MenuviewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuviewHolder {
        var layoutInflater=LayoutInflater.from(parent.context)

        return MenuviewHolder(layoutInflater.inflate(R.layout.item_menu,parent,false))

    }

    override fun onBindViewHolder(holder: MenuviewHolder, position: Int) {
        val item=Menulist[position]
        holder .render(item)
    }

    override fun getItemCount(): Int {
        return Menulist.size
    }

}
