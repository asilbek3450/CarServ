package com.example.autoservice.fragments.main_page.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.autoservice.databinding.ItemCarWashBinding
import com.example.autoservice.fragments.main_page.FilterModel
import com.example.autoservice.fragments.main_page.MyMethods

class CarWashAdapter (
    var filterList: ArrayList<FilterModel>,
    var onItemCLick:(FilterModel) -> Unit
) :
    RecyclerView.Adapter<CarWashAdapter.Vh>() {

    inner class Vh(var itemBinding: ItemCarWashBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(filter: FilterModel, position: Int) {
            itemBinding.apply {
                name.text = filter.name
                distance.text = "${filter.distance} km"
                card.setOnClickListener { onItemCLick.invoke(filter) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemCarWashBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(filterList[position], position)
    }

    override fun getItemCount(): Int = filterList.size
}