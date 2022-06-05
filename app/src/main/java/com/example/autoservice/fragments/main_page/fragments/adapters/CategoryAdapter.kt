package com.example.autoservice.fragments.main_page.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.autoservice.R
import com.example.autoservice.databinding.ItemCategoryBinding
import com.example.autoservice.fragments.main_page.models.Category

class CategoryAdapter(
    var categoryList: ArrayList<Category>,
    var isAll: Boolean = true,
    var onItemClick: (Category) -> Unit
) :
    RecyclerView.Adapter<CategoryAdapter.Vh>() {

    inner class Vh(var itembinding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(itembinding.root) {
        fun onBind(category: Category) {
            itembinding.apply {
                itembinding.category.text = category.category
                name.text = category.name
                if (!isAll) {
                    layout.setBackgroundResource(getBackgroundColor(category.category))
                }
                distance.text = "${category.distance} km"
                card.setOnClickListener { onItemClick.invoke(category) }
            }
        }

    }

    private fun getBackgroundColor(category: String) : Int {
        return when (category) {
            "Auto Service" -> R.color.service_color
            "Car Wash" -> R.color.car_wash_color
            "Petrol" -> R.color.refueling_color
            else -> R.color.all_color
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(categoryList[position])
    }

    override fun getItemCount(): Int = categoryList.size
}