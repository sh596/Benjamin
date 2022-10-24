package com.example.benjamin

import android.app.Activity
import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.example.benjamin.model.Record
import com.example.benjamin.model.Virtue
import java.text.SimpleDateFormat

@BindingAdapter("bindMainVirtue")
fun bindVirtueAdapter(view: TextView, virtue: Virtue) {
    view.text = virtue.virtue
}

@BindingAdapter("bindVirtueAdapter")
fun bindVirtueAdapter(view: RecyclerView, activity: Activity) {
    view.adapter = MainRecyclerAdapter(activity)
}

@BindingAdapter("bindVirtueList")
fun bindVirtueList(view: RecyclerView, virtueList: ObservableArrayList<Virtue>?) {
    val adapter = view.adapter as MainRecyclerAdapter? ?: return
    if (virtueList != null) adapter.setList(virtueList)
}

@BindingAdapter("bindExceptMainVirtue")
fun bindExceptMainVirtue(view: RecyclerView, mainVirtueId: Int) {
    val adapter = view.adapter as MainRecyclerAdapter? ?: return
    adapter.removeItem(mainVirtueId)

}

@BindingAdapter("bindRecordAdapter")
fun bindRecordAdpater(view: RecyclerView, function :(Record) -> Unit){
    view.adapter = RecordRecyclerAdapter(function)
}

@BindingAdapter("bindRecordList")
fun bindRecordList(view: RecyclerView, virtueList: ObservableArrayList<Record>?) {
    val adapter = view.adapter as RecordRecyclerAdapter? ?: return
    if (virtueList != null) adapter.setList(virtueList)
    Log.d(TAG, "bindRecordList: ${virtueList}")
}

@BindingAdapter("bindVisibility")
fun bindVisibility(view: View, boolean: Boolean) {
    view.visibility = if (boolean) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("bindDate")
fun bindDate(view: TextView, date: Long) {
    val dateFormat = SimpleDateFormat("MM/dd")
    view.text = dateFormat.format(date)
}
