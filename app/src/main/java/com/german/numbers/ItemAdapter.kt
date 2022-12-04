package com.german.numbers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (private val context:Context): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    private var dataset: MutableList<Registro>? = mutableListOf()

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
        val item = dataset?.get(position)
        holder.textView.text =  item?.number.toString()
    }

    override fun getItemCount(): Int {
        if(dataset != null) {
            return dataset!!.size
        }else{
            return 0
        }
    }

    fun setRegistros(listaRegistro:List<Registro>){
        if(dataset!=null){
            val count = listaRegistro.size
            this.dataset!!.add(listaRegistro[count - 1])
            notifyItemInserted(dataset!!.size-1)
        }
    }

}