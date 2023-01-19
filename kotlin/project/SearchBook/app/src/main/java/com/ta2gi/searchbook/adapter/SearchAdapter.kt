package com.ta2gi.searchbook.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ta2gi.searchbook.MainActivity
import com.ta2gi.searchbook.R
import kotlin.concurrent.thread

class SearchAdapter(val mainActivity: MainActivity, val searchList : MutableList<BookDto>) : RecyclerView.Adapter<SearchAdapter.ViewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.ViewHolderClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_list_item, parent, false)
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: SearchAdapter.ViewHolderClass, position: Int) {

    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    inner class ViewHolderClass(view : View) : RecyclerView.ViewHolder(view) {

    }
}