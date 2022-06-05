package com.example.autoservice.fragments.intro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.autoservice.R
import com.example.autoservice.adapters.IntroTabAdapter
import com.example.autoservice.database.Users
import com.example.autoservice.database.UsersDatabase
import com.example.autoservice.databinding.FragmentIntroBinding
import com.example.autoservice.fragments.main_page.HomePageActivity
import com.example.autoservice.models.IntroTabInfo
import com.example.autoservice.transforms.DepthPageTransformer

class IntroFragment : Fragment() {

    private lateinit var binding: FragmentIntroBinding
    private lateinit var introTabAdapter: IntroTabAdapter
    private lateinit var tabList: ArrayList<IntroTabInfo>
    private lateinit var usersList: List<Users>

    private val TAG = "IntroFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")
        binding = FragmentIntroBinding.inflate(layoutInflater)
        if (UsersDatabase.getInstance(requireContext()).usersDao().listUsers()
                .isNotEmpty()
        ) {
            val intent = Intent(requireContext(), HomePageActivity::class.java)
            startActivity(intent)
        }
        usersList = UsersDatabase.getInstance(requireContext()).usersDao().listUsers()
        if (usersList.isEmpty()) {
            loadList()
            introTabAdapter = IntroTabAdapter(
                this,
                tabList
            )
            binding.apply {
                viewPager.adapter = introTabAdapter
                viewPager.setPageTransformer(DepthPageTransformer())
                wormDotsIndicator.setViewPager2(viewPager)
                viewPager.setCurrentItem(0, true)
                continueBtn.setOnClickListener {
                    val navOptions: NavOptions = NavOptions.Builder()
                        .setEnterAnim(R.anim.enter)
                        .setExitAnim(R.anim.exit)
                        .setPopEnterAnim(R.anim.pop_enter)
                        .setPopExitAnim(R.anim.pop_exit)
                        .build()
                    findNavController().navigate(
                        R.id.enterPhoneNumberFragment,
                        null,
                        navOptions
                    )
                }
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.viewPager.setCurrentItem(0, true)
    }

    private fun loadList() {
        tabList = ArrayList()
        tabList.add(IntroTabInfo("Hamyonbop narxlarda professional avtoservis", R.drawable.repair))
        tabList.add(IntroTabInfo("Bizning sifatli xizmatlarimiz har doim mijozlar ehtiyojini qondirish imkonini beradi", R.drawable.car_wash))
        tabList.add(IntroTabInfo("Bir umrlik sayohatlar uchun yoqilg'ini to'ldiring", R.drawable.petrol_svg))
    }
}