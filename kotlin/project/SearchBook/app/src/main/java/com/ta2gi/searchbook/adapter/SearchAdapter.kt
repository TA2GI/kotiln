package com.ta2gi.searchbook.adapter

import android.content.Intent
import android.net.Uri
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.ta2gi.searchbook.MainActivity
import com.ta2gi.searchbook.R
import com.ta2gi.searchbook.retrofit2.BookDto
import kotlin.concurrent.thread

class SearchAdapter(val mainActivity: MainActivity, val searchList : MutableList<BookDto>) : RecyclerView.Adapter<SearchAdapter.ViewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.ViewHolderClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_list_item, parent, false)
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: SearchAdapter.ViewHolderClass, position: Int) {
        // 이미지, 제목, 저자, 줄거리, 정가, 판매여부, 링크
        Glide.with(mainActivity).load(searchList[position].thumbnail).into(holder.thumbnail)
        holder.title.text = searchList[position].title
        holder.authors.text = searchList[position].authors.toString()
        holder.contents.text = searchList[position].contents
        holder.price.text = "${searchList[position].price}원"
        holder.status.text = searchList[position].status
        holder.url.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(searchList[position].url))
            mainActivity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    inner class ViewHolderClass(view : View) : RecyclerView.ViewHolder(view) {
        val thumbnail = view.findViewById<ImageView>(R.id.search_list_item_thumbnail)
        val title = view.findViewById<TextView>(R.id.search_list_item_title)
        val authors = view.findViewById<TextView>(R.id.search_list_item_authors)
        val contents = view.findViewById<TextView>(R.id.search_list_item_contents)
        val price = view.findViewById<TextView>(R.id.search_list_item_price)
        val status = view.findViewById<TextView>(R.id.search_list_item_status)
        val url = view.findViewById<TextView>(R.id.search_list_item_url)
    }
}