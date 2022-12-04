package com.german.numbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var myViewModel: NumberViewModel ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProviders.of(this).get(NumberViewModel::class.java)

        // Set RycyclerView Adapter
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val myAdapter = ItemAdapter(this, myViewModel!!)
        recyclerView.adapter = myAdapter
        recyclerView.setHasFixedSize(true)

        // Set Listener for RecycledView
        myViewModel!!.listener ={
            myAdapter.updateRegistros()
            val count = myAdapter.getItemCount()
            if (count > 1) {
                recyclerView.smoothScrollToPosition(myAdapter.getItemCount() - 1)
            }
        }

        // Get UI Events
        val btn = findViewById<Button>(R.id.btnGo)
        btn.setOnClickListener(){
            val range = 1..6
            val newNumber = range.random()
            myViewModel!!.add(Registro(null, newNumber))
        }
    }
}