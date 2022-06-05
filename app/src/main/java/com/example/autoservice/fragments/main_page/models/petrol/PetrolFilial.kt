package com.example.autoservice.fragments.main_page.models.petrol

data class PetrolFilial(
    val id: Int = 0,
    val name: String,
    val ai95Cost: Int,
    val ai92Cost: Int,
    val ai91Cost: Int,
    val ai80Cost: Int,
    val dpCost: Int,
    val metanCost: Int,
    val xLocation: Double,
    val yLocation: Double
)
