package com.example.autoservice.fragments.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.autoservice.R
import com.example.autoservice.databinding.FragmentEnterPhoneNumberBinding

class EnterPhoneNumberFragment : Fragment() {

    private lateinit var binding: FragmentEnterPhoneNumberBinding
    private lateinit var phoneNumber: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterPhoneNumberBinding.inflate(layoutInflater)
        phoneNumber = "998"
        binding.apply {
            backButton.setOnClickListener { findNavController().popBackStack() }
            zero.setOnClickListener { write("0") }
            one.setOnClickListener { write("1") }
            two.setOnClickListener { write("2") }
            three.setOnClickListener { write("3") }
            four.setOnClickListener { write("4") }
            five.setOnClickListener { write("5") }

            six.setOnClickListener { write("6") }
            seven.setOnClickListener { write("7") }
            eight.setOnClickListener { write("8") }
            nine.setOnClickListener { write("9") }
            backspace.setOnClickListener { erase() }
            nextButton.setOnClickListener {
                if (phoneNumber.length == 12) {
                    val bundle = Bundle()
                    bundle.putString("phone_number", phoneNumber)
                    val navOptions: NavOptions = NavOptions.Builder()
                        .setEnterAnim(R.anim.enter)
                        .setExitAnim(R.anim.exit)
                        .setPopEnterAnim(R.anim.pop_enter)
                        .setPopExitAnim(R.anim.pop_exit)
                        .build()
                    findNavController().navigate(R.id.enterVerificationCodeFragment, bundle, navOptions)
                }
            }
        }

        return binding.root
    }

    private fun erase() {
        binding.apply {
            if (n1.isNotEmpty()) {
                phoneNumber = phoneNumber.substring(0, phoneNumber.length - 1)
                nextButton.isClickable = false
                nextButton.setBackgroundResource(R.drawable.disabled_circle)
            }
            if (n9.isNotEmpty()) {
                n9.text = ""
                return
            }
            if (n8.isNotEmpty()) {
                n8.text = ""
                return
            }
            if (n7.isNotEmpty()) {
                n7.text = ""
                return
            }
            if (n6.isNotEmpty()) {
                n6.text = ""
                return
            }
            if (n5.isNotEmpty()) {
                n5.text = ""
                return
            }
            if (n4.isNotEmpty()) {
                n4.text = ""
                return
            }
            if (n3.isNotEmpty()) {
                n3.text = ""
                return
            }
            if (n2.isNotEmpty()) {
                n2.text = ""
                return
            }
            if (n1.isNotEmpty()) {
                n1.text = ""
                return
            }
        }
    }

    private fun write(number: String) {
        binding.apply {
            if (n9.isEmpty()) {
                phoneNumber += number
                if (phoneNumber.length == 12) {
                    nextButton.isClickable = true
                    nextButton.setBackgroundResource(R.drawable.enabled_circle)
                }
            }
            if (n1.isEmpty()) {
                n1.text = number
                return
            }
            if (n2.isEmpty()) {
                n2.text = number
                return
            }
            if (n3.isEmpty()) {
                n3.text = number
                return
            }
            if (n4.isEmpty()) {
                n4.text = number
                return
            }
            if (n5.isEmpty()) {
                n5.text = number
                return
            }
            if (n6.isEmpty()) {
                n6.text = number
                return
            }
            if (n7.isEmpty()) {
                n7.text = number
                return
            }
            if (n8.isEmpty()) {
                n8.text = number
                return
            }
            if (n9.isEmpty()) {
                n9.text = number
                return
            }
        }
    }

    private fun TextView.isEmpty(): Boolean {
        return this.text.toString().isEmpty()
    }

    private fun TextView.isNotEmpty(): Boolean {
        return this.text.toString().isNotEmpty()
    }
}