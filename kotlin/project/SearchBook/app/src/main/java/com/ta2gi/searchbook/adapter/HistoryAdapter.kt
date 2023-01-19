package com.ta2gi.searchbook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ta2gi.searchbook.MainActivity
import com.ta2gi.searchbook.R
import com.ta2gi.searchbook.fragment.HomeFragment
import com.ta2gi.searchbook.room.HistoryEntity
import kotlin.concurrent.thread

class HistoryAdapter(val mainActivity: MainActivity, val historyList : MutableList<HistoryEntity>, val fragment : HomeFragment) : RecyclerView.Adapter<HistoryAdapter.ViewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdapter.ViewHolderClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_list_item, parent, false)
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        holder.searchWord.text = historyList[position].searchWord

        // 검색 기록 삭제
        holder.searchWordDelete.setOnClickListener {
            thread {
                val historyEntity = HistoryEntity(historyList[position].bookUid, holder.searchWord.text.toString())
                mainActivity.historyDatabase.historyDao().deleteHistory(historyEntity)

                mainActivity.historyList.clear()
                mainActivity.historyList.addAll(mainActivity.historyDatabase.historyDao().getHistory())

                mainActivity.runOnUiThread {
                    notifyDataSetChanged()

                    // 리스트가 비어 있으면 empty 보여주기
                    if(mainActivity.historyList.isEmpty()) {
                        mainActivity.runOnUiThread {
                            fragment.homeBinding.fraHomEmptyHistory.visibility = View.VISIBLE
                            fragment.homeBinding.fraHomHistory.visibility = View.GONE
                        }
                    }
                }

                Snackbar.make(mainActivity.mainBinding.root, "❗검색 기록을 지웠습니다", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    inner class ViewHolderClass(view : View) : RecyclerView.ViewHolder(view) {
        val searchWord = view.findViewById<TextView>(R.id.history_list_item_search_word)
        val searchWordDelete = view.findViewById<ImageView>(R.id.history_list_item_delete)
    }
}