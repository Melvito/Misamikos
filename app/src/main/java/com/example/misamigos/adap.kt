package com.example.misamigos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class adap constructor(private val listfriend:List<classdatos>):
RecyclerView.Adapter<adap.MyViewHolder>() {
    private var clickListener: ClickListener<classdatos>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adap.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.resicleview, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: adap.MyViewHolder, position: Int) {
        val amikum = listfriend[position]
        holder.title.text = amikum.name
        holder.imgbro.setBackgroundResource(amikum.fotito)
        holder.card.setOnClickListener { clickListener!!.onItemClick(amikum) }
        holder.des.text = "${amikum.descrp}"
    }

    override fun getItemCount(): Int {
        return listfriend.size
    }
    fun setOnItemClickListener(amikoClickListener: ClickListener<classdatos>){
        clickListener = amikoClickListener
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.nombre)
        val imgbro: ImageView = itemView.findViewById(R.id.imgamigo)
        val des: TextView = itemView.findViewById(R.id.description)
        val card: CardView = itemView.findViewById(R.id.carView)

    }

}

interface ClickListener <T>{
    fun onItemClick(data:T)
}