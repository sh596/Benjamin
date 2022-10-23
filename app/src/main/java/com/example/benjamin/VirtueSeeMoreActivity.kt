package com.example.benjamin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.benjamin.base.BaseActivity
import com.example.benjamin.databinding.ActivityVirtueSeeMoreBinding
import com.example.benjamin.model.Virtue
import com.example.benjamin.viewmodel.VirtueSeeMoreViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VirtueSeeMoreActivity : BaseActivity<ActivityVirtueSeeMoreBinding>(R.layout.activity_virtue_see_more) {

    private lateinit var virtue : Virtue

    private val viewmodel by viewModels<VirtueSeeMoreViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        virtue = (intent.getSerializableExtra("virtue") as Virtue?)!!
        val isMain = intent.getBooleanExtra("isMain", false)
        binding.virtue = virtue
        binding.isMain = isMain
        binding.viewModel = viewmodel
        binding.activity = this

        viewmodel.getRecordListById(virtue.id)

    }

    fun clickAddRecord(view:View) {
        val intent = Intent(this, RecordActivity::class.java)
        intent.putExtra("virtueId", virtue.id)
        startActivity(intent)
    }
}