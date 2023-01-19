package com.ta2gi.searchbook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.ta2gi.searchbook.MainActivity
import com.ta2gi.searchbook.R
import com.ta2gi.searchbook.databinding.FragmentSearchBinding
import com.ta2gi.searchbook.room.HistoryEntity
import kotlin.concurrent.thread

class SearchFragment(val mainActivity : MainActivity) : Fragment(), View.OnClickListener {

    lateinit var searchBinding : FragmentSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        searchBinding = FragmentSearchBinding.inflate(inflater)

        // 검색어 삽입
        searchBinding.fraSeaSearchText.setText(mainActivity.searchWord)

        // 어뎁터 장착
        searchBinding.fraSeaSearchList.adapter = mainActivity.searchAdapter

        // 삽입된 검색어로 검색
        mainActivity.searchResults(mainActivity.searchWord, this)

        // 클릭 리스너
        searchBinding.fraSeaBack.setOnClickListener(this)
        searchBinding.fraSeaSearchButton.setOnClickListener(this)

        return searchBinding.root
    }

    override fun onClick(view : View?) {
        when(view) {
            // 돌아가기
            searchBinding.fraSeaBack -> mainActivity.supportFragmentManager.popBackStack()

            // 검색
            searchBinding.fraSeaSearchButton -> {
                mainActivity.hideKeyboard(mainActivity)

                val searchText = searchBinding.fraSeaSearchText.text.toString().trim()

                // 공백 입력 시 리턴
                if(searchText.isEmpty()) {
                    Snackbar.make(searchBinding.root, "❗검색어를 입력해주세요", Snackbar.LENGTH_SHORT).show()
                    return
                }

                // 검색 기록에 추가
                thread {
                    val historyEntity = HistoryEntity(null, searchText)
                    mainActivity.historyDatabase.historyDao().insertHistory(historyEntity)
                }

                // 자판 내리고 검색 결과 띄우기
                mainActivity.searchResults(searchText, this)
            }
        }
    }
}