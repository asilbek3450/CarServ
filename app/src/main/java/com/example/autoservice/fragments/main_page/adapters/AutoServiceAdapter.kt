package com.example.autoservice.fragments.main_page.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.autoservice.R
import com.example.autoservice.databinding.ItemAutoServiceBinding
import com.example.autoservice.fragments.main_page.FilterModel
import com.example.autoservice.fragments.main_page.MyMethods
import com.example.autoservice.fragments.main_page.models.autoservice.AutoService

class AutoServiceAdapter(
    var serviceList: ArrayList<FilterModel>,
    var onItemClick:(FilterModel) -> Unit
) :
    RecyclerView.Adapter<AutoServiceAdapter.Vh>() {

    inner class Vh(var itemBinding: ItemAutoServiceBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(filter: FilterModel, position: Int) {
            itemBinding.apply {
                name.text = filter.name
                distance.text = "${filter.distance} km"
                card.setOnClickListener { onItemClick.invoke(filter) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemAutoServiceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(serviceList[position], position)
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }
}