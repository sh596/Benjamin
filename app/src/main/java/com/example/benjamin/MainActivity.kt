package com.example.benjamin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.benjamin.base.BaseActivity
import com.example.benjamin.databinding.ActivityMainBinding
import com.example.benjamin.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main){

    private val viewmodel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.activity = this
        binding.viewModel = viewmodel

        viewmodel.getData()


    }

    fun clickMainVirtue(view: View) {
        val intent = Intent(this, VirtueSeeMoreActivity::class.java)
        intent.putExtra("virtue", viewmodel.virtue.value!!.virtue[viewmodel.virtue.value!!.mainVirtueId])
        startActivity(intent)
    }
}