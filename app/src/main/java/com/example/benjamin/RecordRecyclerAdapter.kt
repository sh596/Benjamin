package com.example.benjamin

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.benjamin.databinding.ItemVirtueBinding
import com.example.benjamin.databinding.ItemVirtueRecordBinding
import com.example.benjamin.model.Record
import com.example.benjamin.room.RecordDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class RecordRecyclerAdapter(private val function: (Record) -> Unit) :
    RecyclerView.Adapter<RecordRecyclerAdapter.ViewHolder>() {
    private var list = mutableListOf<Record>()
    private lateinit var binding: ItemVirtueRecordBinding

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(item: Record) {
            binding.record = item
            binding.root.setOnLongClickListener {
                list.remove(item)
                function(item)
                notifyDataSetChanged()
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_virtue_record,
            parent,
            false
        )
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setList(list: List<Record>) {
        this.list = list as MutableList<Record>
        notifyDataSetChanged()
    }


}
