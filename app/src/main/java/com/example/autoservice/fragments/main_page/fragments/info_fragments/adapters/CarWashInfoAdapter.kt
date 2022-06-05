package com.example.autoservice.fragments.main_page.fragments.info_fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.autoservice.databinding.ItemCarWashInfoBinding
import com.example.autoservice.fragments.main_page.models.car_wash.CarWashJob

class CarWashInfoAdapter(
    var jobList: ArrayList<CarWashJob>,
    var onItemClick: (CarWashJob) -> Unit
) :
    RecyclerView.Adapter<CarWashInfoAdapter.Vh>() {

    inner class Vh(var itembinding: ItemCarWashInfoBinding) :
        RecyclerView.ViewHolder(itembinding.root) {
        fun onBind(carWashJob: CarWashJob) {
            itembinding.apply {
                jobName.text = carWashJob.jobName
                cost.text = carWashJob.cost.toString()
                layout.setOnClickListener { onItemClick.invoke(carWashJob) }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemCarWashInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(jobList[position])
    }

    override fun getItemCount(): Int = jobList.size
}