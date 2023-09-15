package com.ulyanenko.randomroute

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ulyanenko.randomroute.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
           startActivity(MyMapActivity.newIntent(this))
        }

    }
}