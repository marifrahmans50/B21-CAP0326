package com.example.infosungai

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.Result

class MapsAdapter(var context: Context, var arrayList: ArrayList<com.example.infosungai.Result>): RecyclerView.Adapter<MapsAdapter.ItemHolder>() {

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
        var gridListDetails: com.example.infosungai.Result =arrayList.get(position)

        //val imageUrl = gridListDetails.icon
        //Picasso.get().load(imageUrl).into(holder.icon)
        holder.title.setText(gridListDetails.nama_sungai)
        holder.vcity.setText(gridListDetails.indeks_pencemar)
        holder.rating.setText(gridListDetails.kategori)

    }

    class ItemHolder(itemview: View): RecyclerView.ViewHolder(itemview)
    {
        //var icon=itemview.findViewById<ImageView>(R.id.img_shop_image)
        var title=itemview.findViewById<TextView>(R.id.txt_Name)
        var vcity=itemview.findViewById<TextView>(R.id.txt_vcity)
        var rating=itemview.findViewById<TextView>(R.id.txt_rating)
    }
}




