package com.o7.androidkotlin6week25.recyclerpackage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.o7.androidkotlin6week25.R

class RecyclerAdapter(var list :ArrayList<NotesEntity>
//,var clickInterface: OnClick
)
    :RecyclerView.Adapter<RecyclerAdapter.Viewholder>(){
    class Viewholder (var view: View):RecyclerView.ViewHolder(view){
        var name=view.findViewById<TextView>(R.id.tvStuName)
        var update=view.findViewById<Button>(R.id.btnUpdate)
        var delete=view.findViewById<Button>(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.Viewholder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.base_item_layout,parent,false)
        return Viewholder(view)

    }

    override fun onBindViewHolder(holder: RecyclerAdapter.Viewholder, position: Int) {
        holder.apply {
            name.setText(list[position].title)
            update.setOnClickListener{
//                clickInterface.update(position)
            }
            delete.setOnClickListener{
//                clickInterface.delete(position)
            }
}    }

    override fun getItemCount(): Int {
        return  list.size
    }
    interface OnClick{
        fun update(position: Int)
        fun delete(position: Int)
    }
}