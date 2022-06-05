package com.example.autoservice.fragments.registration

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.autoservice.R
import com.example.autoservice.database.Users
import com.example.autoservice.database.UsersDatabase
import com.example.autoservice.databinding.FragmentEnterVerificationCodeBinding
import com.example.autoservice.databinding.NameDialogBinding
import com.example.autoservice.fragments.main_page.HomePageActivity
import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.exitProcess

class EnterVerificationCodeFragment : Fragment() {

    private lateinit var binding: FragmentEnterVerificationCodeBinding
    private lateinit var phoneNumber: String
    private lateinit var code: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterVerificationCodeBinding.inflate(layoutInflater)
        code = ""
        phoneNumber = arguments?.getString("phone_number").toString()
        binding.apply {
            text.text = "${text.text} $phoneNumber"
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
            verifyButton.setOnClickListener {
                checkCode()
            }
        }
        return binding.root
    }

    private fun checkCode() {
        // TODO: checking verification code will be in next update
        val intent = Intent(requireContext(), HomePageActivity::class.java)
        intent.putExtra("phone_number", phoneNumber)
        startActivity(intent)
    }

    private fun erase() {
        code = if (code.length > 1) {
            code.substring(0, code.length - 1)
        } else ""
        binding.apply {
            verifyButton.visibility = View.INVISIBLE
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
            if (n4.isEmpty()) {
                code += number
                if (code.length == 4) {
                    verifyButton.visibility = View.VISIBLE
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
        }
    }

    private fun TextView.isEmpty(): Boolean {
        return this.text.toString().isEmpty()
    }

    private fun TextView.isNotEmpty(): Boolean {
        return this.text.toString().isNotEmpty()
    }
}