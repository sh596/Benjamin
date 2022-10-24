package com.example.benjamin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.benjamin.base.BaseActivity
import com.example.benjamin.databinding.ActivityRecordBinding
import com.example.benjamin.model.Record
import com.example.benjamin.viewmodel.RecordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecordActivity : BaseActivity<ActivityRecordBinding>(R.layout.activity_record) {

    private val viewModel by viewModels<RecordViewModel>()
    private var id = 13
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        id = intent.getIntExtra("virtueId", 13)
        binding.viewModel = viewModel
        binding.activity = this
        binding.lifecycleOwner = this

    }

    fun addRecord(view: View) {
        viewModel.addRecord(id)
        finish()
    }

    fun clickBackButton(view: View) {
        finish()
    }
}