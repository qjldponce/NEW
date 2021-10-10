package com.example.labact6_supplementary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import retrofit2.Response

class ImageAdapter(private val data: List<CardAttributes>) : RecyclerView.Adapter<ImageAdapter.MyViewHolder>()  {

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){

        fun bind(response: CardAttributes){
            val id = view.findViewById<TextView>(R.id.IdView)
            val title = view.findViewById<TextView>(R.id.nameView)
            val imageView = view.findViewById<ImageView>(R.id.imageview)

            id.text = response.id.toString()
            title.text = response.author

            Glide.with(view.context).load(response.download_url).centerCrop().into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.image, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

}