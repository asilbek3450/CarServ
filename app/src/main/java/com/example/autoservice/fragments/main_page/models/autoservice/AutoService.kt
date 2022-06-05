package com.example.autoservice.fragments.main_page.models.autoservice

data class AutoService(
    val id: Int,
    val name: String,
    val jobList: ArrayList<AutoServiceJob>,
    val xLocation: Double,
    val yLocation: Double
)