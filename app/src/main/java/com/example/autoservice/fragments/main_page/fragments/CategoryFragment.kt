package com.example.autoservice.fragments.main_page.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.autoservice.R
import com.example.autoservice.databinding.FragmentCategoryBinding
import com.example.autoservice.fragments.main_page.FilterModel
import com.example.autoservice.fragments.main_page.MyMethods
import com.example.autoservice.fragments.main_page.database.DataLoader
import com.example.autoservice.fragments.main_page.database.DataLoaderImpl
import com.example.autoservice.fragments.main_page.fragments.adapters.CategoryAdapter
import com.example.autoservice.fragments.main_page.models.Category
import com.example.autoservice.fragments.main_page.models.autoservice.AutoService
import com.example.autoservice.fragments.main_page.models.car_wash.CarWash
import com.example.autoservice.fragments.main_page.models.petrol.PetrolFilial

private const val AUTOSERVICE = "Auto Service"
private const val CAR_WASH = "Car Wash"
private const val PETROL = "Petrol"
private const val userXLocation: Double = 41.295367
private const val userYLocation: Double = 69.225488

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private lateinit var serviceList: ArrayList<AutoService>
    private lateinit var petrolList: ArrayList<PetrolFilial>
    private lateinit var carWashList: ArrayList<CarWash>
    private lateinit var loader: DataLoader
    private lateinit var adapter: CategoryAdapter

    private lateinit var categoryList: ArrayList<Category>
    private lateinit var serviceCategory: ArrayList<Category>
    private lateinit var carWashCategory: ArrayList<Category>
    private lateinit var petrolCategory: ArrayList<Category>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(layoutInflater)

        val callBack = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finishAffinity()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callBack)
        loader = DataLoaderImpl()
        serviceList = loader.getServiceList()
        petrolList = loader.getPetrolList()
        carWashList = loader.getCarWashList()

        makeCategoryList()
        sortLists()
        categoryList.addAll(serviceCategory)
        categoryList.addAll(petrolCategory)
        categoryList.addAll(carWashCategory)

        adapter = CategoryAdapter(
            categoryList
        ) { category ->
            openInfoFragment(category)
        }
        binding.apply {
            rv.adapter = adapter

            all.setOnClickListener {
                all.setBackgroundResource(R.color.text)
                service.setBackgroundResource(R.color.enabled_button)
                carWash.setBackgroundResource(R.color.enabled_button)
                refueling.setBackgroundResource(R.color.enabled_button)

                allTv.setTextColor(Color.WHITE)
                serviceTv.setTextColor(Color.BLACK)
                carWashTv.setTextColor(Color.BLACK)
                refuelingTv.setTextColor(Color.BLACK)

                adapter = CategoryAdapter(
                    categoryList
                ) { category ->
                    openInfoFragment(category)
                }
                rv.adapter = adapter
            }

            service.setOnClickListener {
                all.setBackgroundResource(R.color.enabled_button)
                service.setBackgroundResource(R.color.text)
                carWash.setBackgroundResource(R.color.enabled_button)
                refueling.setBackgroundResource(R.color.enabled_button)

                allTv.setTextColor(Color.BLACK)
                serviceTv.setTextColor(Color.WHITE)
                carWashTv.setTextColor(Color.BLACK)
                refuelingTv.setTextColor(Color.BLACK)

                adapter = CategoryAdapter(
                    serviceCategory,
                    false
                ) { category ->
                    openInfoFragment(category)
                }
                rv.adapter = adapter
            }

            carWash.setOnClickListener {
                all.setBackgroundResource(R.color.enabled_button)
                service.setBackgroundResource(R.color.enabled_button)
                carWash.setBackgroundResource(R.color.text)
                refueling.setBackgroundResource(R.color.enabled_button)

                allTv.setTextColor(Color.BLACK)
                serviceTv.setTextColor(Color.BLACK)
                carWashTv.setTextColor(Color.WHITE)
                refuelingTv.setTextColor(Color.BLACK)

                adapter = CategoryAdapter(
                    carWashCategory,
                    false
                ) { category ->
                    openInfoFragment(category)
                }
                rv.adapter = adapter
            }

            refueling.setOnClickListener {
                all.setBackgroundResource(R.color.enabled_button)
                service.setBackgroundResource(R.color.enabled_button)
                carWash.setBackgroundResource(R.color.enabled_button)
                refueling.setBackgroundResource(R.color.text)

                allTv.setTextColor(Color.BLACK)
                serviceTv.setTextColor(Color.BLACK)
                carWashTv.setTextColor(Color.BLACK)
                refuelingTv.setTextColor(Color.WHITE)

                adapter = CategoryAdapter(
                    petrolCategory,
                    false
                ) { category ->
                    openInfoFragment(category)
                }
                rv.adapter = adapter
            }
        }
        return binding.root
    }

    private fun openInfoFragment(category: Category) {
        val navOptions: NavOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.enter)
            .setExitAnim(R.anim.exit)
            .setPopEnterAnim(R.anim.pop_enter)
            .setPopExitAnim(R.anim.pop_exit)
            .build()
        val bundle = Bundle()
        bundle.putInt("id", category.id)
        when (category.category) {
            AUTOSERVICE -> {
                findNavController().navigate(R.id.serviceInfoFragment, bundle, navOptions)
            }
            CAR_WASH -> {
                findNavController().navigate(R.id.carWashInfoFragment, bundle, navOptions)
            }
            PETROL -> {
                findNavController().navigate(R.id.petrolInfoFragment, bundle, navOptions)
            }
        }
    }

    private fun sortLists() {
        // sorting auto services
        for (i in 0 until serviceCategory.size - 1) {
            for (j in i + 1 until serviceCategory.size) {
                if (serviceCategory[i].distance > serviceCategory[j].distance) {
                    val category = serviceCategory[i]
                    serviceCategory[i] = serviceCategory[j]
                    serviceCategory[j] = category
                }
            }
        }

        // sorting petrol
        for (i in 0 until petrolCategory.size - 1) {
            for (j in i + 1 until petrolCategory.size) {
                if (petrolCategory[i].distance > petrolCategory[j].distance) {
                    val category = petrolCategory[i]
                    petrolCategory[i] = petrolCategory[j]
                    petrolCategory[j] = category
                }
            }
        }

        // sorting car wash
        for (i in 0 until carWashCategory.size - 1) {
            for (j in i + 1 until carWashCategory.size) {
                if (carWashCategory[i].distance > carWashCategory[j].distance) {
                    val category = carWashCategory[i]
                    carWashCategory[i] = carWashCategory[j]
                    carWashCategory[j] = category
                }
            }
        }
    }

    private fun makeCategoryList() {
        // auto service
        // petrol
        // car wash

        serviceCategory = ArrayList()
        carWashCategory = ArrayList()
        petrolCategory = ArrayList()

        categoryList = ArrayList()
        for (autoService in serviceList) {
            serviceCategory.add(
                Category(
                    autoService.id,
                    AUTOSERVICE,
                    autoService.name,
                    MyMethods.distance(
                        autoService.xLocation,
                        autoService.yLocation,
                        userXLocation,
                        userYLocation
                    )
                )
            )
        }
        for (petrolFilial in petrolList) {
            petrolCategory.add(
                Category(
                    petrolFilial.id,
                    PETROL,
                    petrolFilial.name,
                    MyMethods.distance(
                        petrolFilial.xLocation,
                        petrolFilial.yLocation,
                        userXLocation,
                        userYLocation
                    )
                )
            )
        }
        for (carWash in carWashList) {
            carWashCategory.add(
                Category(
                    carWash.id,
                    CAR_WASH,
                    carWash.name,
                    MyMethods.distance(
                        carWash.xLocation,
                        carWash.yLocation,
                        userXLocation,
                        userYLocation
                    )
                )
            )
        }

    }
}