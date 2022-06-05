package com.example.autoservice.fragments.main_page.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.autoservice.R
import com.example.autoservice.databinding.FragmentHomeBinding
import com.example.autoservice.fragments.main_page.FilterModel
import com.example.autoservice.fragments.main_page.MyMethods
import com.example.autoservice.fragments.main_page.adapters.AutoServiceAdapter
import com.example.autoservice.fragments.main_page.adapters.CarWashAdapter
import com.example.autoservice.fragments.main_page.adapters.PetrolAdapter
import com.example.autoservice.fragments.main_page.adapters.SuggestedAdapter
import com.example.autoservice.fragments.main_page.database.DataLoader
import com.example.autoservice.fragments.main_page.database.DataLoaderImpl
import com.example.autoservice.fragments.main_page.models.autoservice.AutoService
import com.example.autoservice.fragments.main_page.models.car_wash.CarWash
import com.example.autoservice.fragments.main_page.models.petrol.PetrolFilial

private const val AUTOSERVICE = "autoservice"
private const val CAR_WASH = "car_wash"
private const val PETROL = "petrol"

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var suggestedList: ArrayList<String>

    private lateinit var serviceList: ArrayList<AutoService>
    private lateinit var filterService: ArrayList<FilterModel>

    private lateinit var washList: ArrayList<CarWash>
    private lateinit var filterCarWash: ArrayList<FilterModel>

    private lateinit var petrolList: ArrayList<PetrolFilial>
    private lateinit var filterPetrol: ArrayList<FilterModel>

    private lateinit var loader: DataLoader

    private lateinit var serviceAdapter: AutoServiceAdapter
    private lateinit var suggestedAdapter: SuggestedAdapter
    private lateinit var petrolAdapter: PetrolAdapter
    private lateinit var carWashAdapter: CarWashAdapter

    private var userXLocation: Double = 41.295367
    private var userYLocation: Double = 69.225488

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        loadSuggestedList()
        val callBack = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finishAffinity()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callBack)

        loader = DataLoaderImpl()
        binding.apply {

            // avtoservis
            serviceList = loader.getServiceList()
            filterServices()
            serviceAdapter = AutoServiceAdapter(filterService) { filter ->
                openInfoFragment(AUTOSERVICE, filter)
            }
            serviceRv.adapter = serviceAdapter

            // moyka
            washList = loader.getCarWashList()
            filterCarWash()
            carWashAdapter = CarWashAdapter(
                filterCarWash
            ) { filter ->
                openInfoFragment(CAR_WASH, filter)
            }
            carWashRv.adapter = carWashAdapter

            // zapravka
            petrolList = loader.getPetrolList()
            filterPetrols()
            petrolAdapter = PetrolAdapter(
                filterPetrol
            ) { filter ->
                openInfoFragment(PETROL, filter)
            }
            petrolRv.adapter = petrolAdapter

            // tavsiya qilinadiganlar
            suggestedAdapter = SuggestedAdapter(
                suggestedList
            ) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
            suggestedRv.adapter = suggestedAdapter
        }

        return binding.root
    }

    private fun openInfoFragment(s: String, filter: FilterModel) {
        val navOptions: NavOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.enter)
            .setExitAnim(R.anim.exit)
            .setPopEnterAnim(R.anim.pop_enter)
            .setPopExitAnim(R.anim.pop_exit)
            .build()
        val bundle = Bundle()
        bundle.putInt("id", filter.id)
        when (s) {
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

    private fun filterPetrols() {
        filterPetrol = ArrayList()
        for (petrol in petrolList) {
            filterPetrol.add(
                FilterModel(
                    petrol.id,
                    petrol.name,
                    MyMethods.distance(
                        petrol.xLocation,
                        petrol.yLocation,
                        userXLocation,
                        userYLocation
                    )
                )
            )
        }
        for (i in 0 until filterPetrol.size - 1) {
            for (j in i + 1 until filterPetrol.size) {
                if (filterPetrol[i].distance > filterPetrol[j].distance) {
                    val filterModel = filterPetrol[i]
                    filterPetrol[i] = filterPetrol[j]
                    filterPetrol[j] = filterModel
                }
            }
        }
    }

    private fun filterCarWash() {
        filterCarWash = ArrayList()
        for (carWash in washList) {
            filterCarWash.add(
                FilterModel(
                    carWash.id,
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
        for (i in 0 until filterCarWash.size - 1) {
            for (j in i + 1 until filterCarWash.size) {
                if (filterCarWash[i].distance > filterCarWash[j].distance) {
                    val filterModel = filterCarWash[i]
                    filterCarWash[i] = filterCarWash[j]
                    filterCarWash[j] = filterModel
                }
            }
        }
    }

    private fun filterServices() {
        filterService = ArrayList()
        for (autoService in serviceList) {
            filterService.add(
                FilterModel(
                    autoService.id,
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
        for (i in 0 until filterService.size - 1) {
            for (j in i + 1 until filterService.size) {
                if (filterService[i].distance > filterService[j].distance) {
                    val filterModel = filterService[i]
                    filterService[i] = filterService[j]
                    filterService[j] = filterModel
                }
            }
        }
    }

    private fun loadSuggestedList() {
        suggestedList = ArrayList()
        suggestedList.add("Motor")
        suggestedList.add("Ai-92")
        suggestedList.add("Balon")
        suggestedList.add("Balon")
    }
}