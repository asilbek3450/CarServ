package com.example.autoservice.fragments.main_page.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.autoservice.databinding.ItemSuggestedBinding
import com.example.autoservice.fragments.main_page.MyMethods

class SuggestedAdapter(
    var suggestedList:ArrayList<String>,
    var onItemClick:(String) -> Unit
    ) :
RecyclerView.Adapter<SuggestedAdapter.Vh>(){

    inner class Vh(var itemBinding: ItemSuggestedBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(suggested: String, position: Int) {
            itemBinding.apply {
                name.text = suggested
                card.setOnClickListener { onItemClick.invoke(suggested) }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemSuggestedBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(suggestedList[position], position)
    }

    override fun getItemCount(): Int {
        return suggestedList.size
    }
}