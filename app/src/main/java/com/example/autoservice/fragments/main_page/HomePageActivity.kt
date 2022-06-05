package com.example.autoservice.fragments.main_page

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.autoservice.R
import com.example.autoservice.database.Users
import com.example.autoservice.database.UsersDatabase
import com.example.autoservice.databinding.ActivityHomePageBinding
import com.example.autoservice.databinding.ActivityMainBinding
import com.example.autoservice.databinding.NameDialogBinding
import com.example.autoservice.fragments.main_page.fragments.CategoryFragment
import com.example.autoservice.fragments.main_page.fragments.HomeFragment
import com.example.autoservice.fragments.main_page.fragments.ProfileFragment
import kotlin.system.exitProcess

class HomePageActivity : AppCompatActivity() {

    private lateinit var binding:ActivityHomePageBinding
    private lateinit var phoneNumber: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        phoneNumber = intent.getStringExtra("phone_number").toString()
        val listUsers = UsersDatabase.getInstance(this).usersDao().listUsers()
        if (listUsers.isEmpty()) getNameLanguage()
        binding.apply {
            bottomBar.onTabSelected = {
                when (it.title) {
                    "Asosiy" -> {
                        loadFragment(HomeFragment())
                    }
                    "Kategoriya" -> {
                        loadFragment(CategoryFragment())
                    }
                    "Profil" -> {
                        loadFragment(ProfileFragment())
                    }
                }
            }
        }
    }

    private fun getNameLanguage() {
        val builder = AlertDialog.Builder(this)
        val nameBinding = NameDialogBinding.inflate(layoutInflater)
        builder.setView(nameBinding.root)
        val alertDialog = builder.create()
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.setCancelable(false)
        nameBinding.apply {
            val languageList = ArrayList<String>()
            languageList.add("Uzbek")
            languageList.add("Ingliz")
            languageList.add("Rus")
            val arrayAdapter =
                ArrayAdapter(this@HomePageActivity, android.R.layout.simple_spinner_dropdown_item, languageList)
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = arrayAdapter
            okBtn.setOnClickListener {
                val name = nameEt.editText?.text.toString()
                if (name.isEmpty()) {
                    nameEt.error = "Ismingizni kiriting"
                } else {
                    nameEt.error = null
                    val user = Users(
                        name = name,
                        phoneNumber = phoneNumber,
                        language = spinner.selectedItemPosition
                    )
                    UsersDatabase.getInstance(this@HomePageActivity).usersDao().addUser(user)
                    alertDialog.dismiss()
                }
            }
        }
        alertDialog.show()
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView2,fragment)
        transaction.commit()
    }
}