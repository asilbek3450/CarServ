package com.example.autoservice.fragments.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.autoservice.R
import com.example.autoservice.databinding.FragmentIntroTabItemBinding
import com.example.autoservice.models.IntroTabInfo

private const val ARG_PARAM1 = "param1"

class IntroTabItemFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tabInfo = it.getParcelable(ARG_PARAM1)
        }
    }

    private lateinit var binding: FragmentIntroTabItemBinding
    private var tabInfo: IntroTabInfo? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIntroTabItemBinding.inflate(layoutInflater)
        binding.apply {
            title.text = tabInfo?.title
            tabInfo?.image?.let { image.setImageResource(it) }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(introTabInfo: IntroTabInfo) =
            IntroTabItemFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, introTabInfo)
                }
            }
    }
}