package com.example.autoservice.fragments.main_page.models.car_wash

data class CarWash(
    val id: Int,
    val name: String,
    val jobList: ArrayList<CarWashJob>,
    val xLocation: Double,
    val yLocation: Double
)
