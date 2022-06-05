package com.example.autoservice.fragments.main_page.fragments.info_fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.autoservice.databinding.ItemCarWashInfoBinding
import com.example.autoservice.databinding.ItemPetrolInfoBinding
import com.example.autoservice.fragments.main_page.fragments.info_fragments.models.Fuel
import com.example.autoservice.fragments.main_page.models.autoservice.AutoServiceJob
import com.example.autoservice.fragments.main_page.models.car_wash.CarWashJob
import com.example.autoservice.fragments.main_page.models.petrol.PetrolFilial

class PetrolInfoAdapter(
    var list: ArrayList<Fuel>,
) :
    RecyclerView.Adapter<PetrolInfoAdapter.Vh>() {

    inner class Vh(var itembinding: ItemPetrolInfoBinding) :
        RecyclerView.ViewHolder(itembinding.root) {
        fun onBind(fuel: Fuel) {
            itembinding.apply {
                jobName.text = fuel.name
                cost.text = fuel.cost.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemPetrolInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}