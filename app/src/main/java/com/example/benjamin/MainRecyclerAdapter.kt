package com.example.benjamin

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.benjamin.databinding.ItemVirtueBinding
import com.example.benjamin.model.Virtue

class MainRecyclerAdapter(
    private val activity: Activity
) : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {
    private var list = mutableListOf<Virtue>()
    private lateinit var binding: ItemVirtueBinding

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(item: Virtue) {
            binding.virtue = item
            Log.d(TAG, "onBind: $item")
            binding.root.setOnClickListener {
                val intent = Intent(activity, VirtueSeeMoreActivity::class.java)
                intent.putExtra("virtue", item)
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_virtue,
            parent,
            false
        )
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setList(list: List<Virtue>) {
        if (list.isNotEmpty()) {
            this.list.clear()
        }
        this.list = list as MutableList<Virtue>
        notifyDataSetChanged()
    }

    fun removeItem(id: Int) {
        this.list.remove(this.list.filter { it.id == id }[0])
        notifyDataSetChanged()
    }
}