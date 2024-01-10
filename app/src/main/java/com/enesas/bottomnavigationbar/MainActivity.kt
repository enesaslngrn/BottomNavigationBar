package com.enesas.bottomnavigationbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.enesas.bottomnavigationbar.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initialize with the home fragment
        replaceFragment(HomeFragment())

        //Bu yapı böyle kuruluyor when ile yani görünce şaşırma.
        binding.bottomNavigationView.setOnItemSelectedListener {menuItem ->

            when(menuItem.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.person -> replaceFragment(ProfileFragment())
                R.id.settings -> replaceFragment(SettingsFragment())


                else -> {}
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment).commit()
    }
}
