package com.example.autoservice.fragments.main_page.database

import com.example.autoservice.fragments.main_page.models.autoservice.AutoService
import com.example.autoservice.fragments.main_page.models.car_wash.CarWash
import com.example.autoservice.fragments.main_page.models.petrol.PetrolFilial

interface DataLoader {
    fun getServiceList(): ArrayList<AutoService>

    fun getCarWashList(): ArrayList<CarWash>

    fun getPetrolList(): ArrayList<PetrolFilial>

    fun getServiceById(id: Int): AutoService

    fun getCarWashById(id: Int): CarWash

    fun getPetrolById(id: Int): PetrolFilial
}