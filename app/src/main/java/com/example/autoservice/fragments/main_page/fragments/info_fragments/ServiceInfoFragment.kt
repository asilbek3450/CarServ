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
import com.example.autoservice.databinding.FragmentServiceInfoBinding
import com.example.autoservice.fragments.main_page.database.DataLoader
import com.example.autoservice.fragments.main_page.database.DataLoaderImpl
import com.example.autoservice.fragments.main_page.fragments.info_fragments.adapters.CarWashInfoAdapter
import com.example.autoservice.fragments.main_page.fragments.info_fragments.adapters.ServiceInfoAdapter
import com.example.autoservice.fragments.main_page.models.autoservice.AutoService
import nl.joery.animatedbottombar.AnimatedBottomBar

class ServiceInfoFragment : Fragment() {

    private lateinit var binding: FragmentServiceInfoBinding
    private lateinit var loader: DataLoader
    private var serviceId: Int? = null
    private lateinit var service: AutoService
    private lateinit var adapter: ServiceInfoAdapter
    private var isLiked: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentServiceInfoBinding.inflate(layoutInflater)
        val callBack = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callBack)
        loader = DataLoaderImpl()
        serviceId = arguments?.getInt("id")
        if (serviceId != null) {
            service = (loader as DataLoaderImpl).getServiceById(serviceId!!)
        }
        adapter = ServiceInfoAdapter(
            service.jobList
        ) {
            autoServiceJob -> showDialog(autoServiceJob.description)
        }
        binding.apply {
            rv.adapter = adapter
            name.text = service.name
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

    private fun showDialog(task: String) {
        val builder = AlertDialog.Builder(requireContext())
        val dialogBinding = CarWashInfoDialogBinding.inflate(layoutInflater)
        builder.setView(dialogBinding.root)
        val alertDialog = builder.create()
        dialogBinding.task.text = task
        dialogBinding.okBtn.setOnClickListener { alertDialog.dismiss() }
        dialogBinding.orderBtn.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Arizangiz qabul qilindi ✅\nTez orada siz bilan bog'lanamiz",
                Toast.LENGTH_SHORT
            ).show()
            alertDialog.dismiss()
        }
        alertDialog.show()
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