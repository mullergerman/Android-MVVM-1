package com.german.numbers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (private val context:Context, private val viewmodel:NumberViewModel): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val dataset = viewmodel.getDataset()
        val item = dataset[position]
        holder.textView.text =  item.number.toString()
    }

    override fun getItemCount(): Int {
        val dataset = viewmodel.getDataset()
        return dataset.size
    }

    fun updateRegistros(){
        val dataset = viewmodel.getDataset()
        notifyItemInserted(dataset.size-1)
    }

}