package com.example.infosungai

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MapsAdapter(var context: Context, var arrayList: ArrayList<com.example.infosungai.data.Result>): RecyclerView.Adapter<MapsAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder=
            LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_maps,parent,false)
        return ItemHolder(
            itemHolder
        )
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var gridListDetails: com.example.infosungai.data.Result =arrayList.get(position)

        holder.namasungai.setText(gridListDetails.nama_sungai)
        holder.indeks.setText(gridListDetails.indeks_pencemar)
        holder.kategori.setText(gridListDetails.kategori)

    }

    class ItemHolder(itemview: View): RecyclerView.ViewHolder(itemview)
    {
        var namasungai=itemview.findViewById<TextView>(R.id.tv_namasungai)
        var indeks=itemview.findViewById<TextView>(R.id.tv_indeks)
        var kategori=itemview.findViewById<TextView>(R.id.tv_kategori)
    }
}




