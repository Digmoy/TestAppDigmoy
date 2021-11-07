package com.example.testappdigmoy

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testappdigmoy.databinding.CustomListItemBinding

class ItemAdapter(private val context : Context, private val modeList : ArrayList<String>,private val deleteItem: DeleteItem) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    inner class ViewHolder (private val binding : CustomListItemBinding) :
        RecyclerView.ViewHolder(binding.root){

            fun setDataToView(position: Int){
                binding.textView.text = modeList[position]

                binding.close.setOnClickListener{
                    deleteItem.delete(position)
                }
            }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        return ViewHolder(CustomListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        holder.setDataToView(position)
    }

    override fun getItemCount(): Int {
       return modeList.size
    }

    interface DeleteItem{
        fun delete(position: Int)
    }
}