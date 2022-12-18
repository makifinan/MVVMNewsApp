package com.makifinan.mvvmnewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.makifinan.mvvmnewsapp.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewsBinding.inflate(layoutInflater)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavigation,navHostFragment.navController)


        setContentView(binding.root)
    }
}