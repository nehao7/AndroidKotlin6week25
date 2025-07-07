package com.o7.androidkotlin6week25.firbase

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.o7.androidkotlin6week25.databinding.CategoryListItemBinding


class CategoriesListAdapter(var context: Context, var arrayList: ArrayList<CategoriesListModel>, var clickIntrface:onClick):RecyclerView.Adapter<CategoriesListAdapter.ViewHolder>() {

    class ViewHolder(var binding: CategoryListItemBinding):RecyclerView.ViewHolder(binding.root) {


    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding=CategoryListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            binding.tvcategory.setText(arrayList[position].categoryName)

            binding.imgDelete.setOnClickListener{
               clickIntrface.delete(position)
            }
            binding.tvUpdate.setOnClickListener{
               clickIntrface.update(position)
            }


        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    interface onClick {
        fun delete(position: Int)
        fun update(position: Int)
    }
}