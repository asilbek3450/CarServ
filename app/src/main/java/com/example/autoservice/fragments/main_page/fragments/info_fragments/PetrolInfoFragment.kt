package com.example.autoservice.fragments.main_page.fragments.info_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.autoservice.R
import com.example.autoservice.databinding.CarWashInfoDialogBinding
import com.example.autoservice.databinding.FragmentPetrolInfoBinding
import com.example.autoservice.fragments.main_page.database.DataLoader
import com.example.autoservice.fragments.main_page.database.DataLoaderImpl
import com.example.autoservice.fragments.main_page.fragments.info_fragments.adapters.PetrolInfoAdapter
import com.example.autoservice.fragments.main_page.fragments.info_fragments.adapters.ServiceInfoAdapter
import com.example.autoservice.fragments.main_page.fragments.info_fragments.models.Fuel
import com.example.autoservice.fragments.main_page.models.autoservice.AutoService
import com.example.autoservice.fragments.main_page.models.petrol.PetrolFilial
import nl.joery.animatedbottombar.AnimatedBottomBar

class PetrolInfoFragment : Fragment() {

    private lateinit var binding: FragmentPetrolInfoBinding
    private lateinit var loader: DataLoader
    private var petrolId: Int? = null
    private lateinit var petrolFilial: PetrolFilial
    private lateinit var adapter: PetrolInfoAdapter
    private var isLiked: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPetrolInfoBinding.inflate(layoutInflater)

        val callBack = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callBack)
        loader = DataLoaderImpl()
        petrolId = arguments?.getInt("id")
        if (petrolId != null) {
            petrolFilial = (loader as DataLoaderImpl).getPetrolById(petrolId!!)
        }
        val list: ArrayList<Fuel> = getFuels()
        adapter = PetrolInfoAdapter(list)
        binding.apply {
            rv.adapter = adapter
            name.text = petrolFilial.name
            like.setOnClickListener {
                if (isLiked) {
                    // liked turibdi
                    // disliked qilamiz
                    isLiked = false
                    like.setImageResource(R.drawable.ic_unliked)
                    Toast.makeText(
                        requireContext(),
                        "Liked bo'limidan olib tashlandi",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // disliked turibdi
                    // liked qilamiz
                    isLiked = true
                    like.setImageResource(R.drawable.ic_liked)
                    Toast.makeText(
                        requireContext(),
                        "Liked bo'limiga qo'shildi",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        return binding.root
    }

    private fun getFuels(): ArrayList<Fuel> {
        val list = ArrayList<Fuel>()
        if (petrolFilial.ai95Cost != 0) list.add(Fuel("Ai-95", petrolFilial.ai95Cost))
        if (petrolFilial.ai92Cost != 0) list.add(Fuel("Ai-92", petrolFilial.ai92Cost))
        if (petrolFilial.ai91Cost != 0) list.add(Fuel("Ai-91", petrolFilial.ai91Cost))
        if (petrolFilial.ai80Cost != 0) list.add(Fuel("Ai-80", petrolFilial.ai80Cost))
        if (petrolFilial.dpCost != 0) list.add(Fuel("DP", petrolFilial.dpCost))
        if (petrolFilial.metanCost != 0) list.add(Fuel("Metan", petrolFilial.metanCost))
        return list
    }

    override fun onResume() {
        super.onResume()
        val bottomBar = requireActivity().findViewById<AnimatedBottomBar>(R.id.bottom_bar)
        bottomBar.visibility = View.INVISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val bottomBar = requireActivity().findViewById<AnimatedBottomBar>(R.id.bottom_bar)
        bottomBar.visibility = View.VISIBLE
    }
}