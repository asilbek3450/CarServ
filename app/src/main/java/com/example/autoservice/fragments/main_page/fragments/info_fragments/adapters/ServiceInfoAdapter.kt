package com.example.autoservice.fragments.main_page.fragments.info_fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.autoservice.databinding.ItemCarWashInfoBinding
import com.example.autoservice.fragments.main_page.models.autoservice.AutoServiceJob
import com.example.autoservice.fragments.main_page.models.car_wash.CarWashJob

class ServiceInfoAdapter(
    var jobList: ArrayList<AutoServiceJob>,
    var onItemClick: (AutoServiceJob) -> Unit
) :
    RecyclerView.Adapter<ServiceInfoAdapter.Vh>() {

    inner class Vh(var itembinding: ItemCarWashInfoBinding) :
        RecyclerView.ViewHolder(itembinding.root) {
        fun onBind(service: AutoServiceJob) {
            itembinding.apply {
                jobName.text = service.jobName
                cost.text = service.cost.toString()
                layout.setOnClickListener { onItemClick.invoke(service) }
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