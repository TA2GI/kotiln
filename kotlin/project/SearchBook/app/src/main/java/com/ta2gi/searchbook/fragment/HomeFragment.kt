package com.ta2gi.searchbook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.ta2gi.searchbook.MainActivity
import com.ta2gi.searchbook.R
import com.ta2gi.searchbook.adapter.HistoryAdapter
import com.ta2gi.searchbook.databinding.FragmentHomeBinding
import com.ta2gi.searchbook.room.HistoryEntity
import kotlin.concurrent.thread

class HomeFragment(val mainActivity : MainActivity) : Fragment(), View.OnClickListener {

    // 뷰바인딩
    lateinit var homeBinding : FragmentHomeBinding

    // 어뎁터
    val historyAdapter = HistoryAdapter(mainActivity, mainActivity.historyList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // 뷰바인딩 초기화
        homeBinding = FragmentHomeBinding.inflate(inflater)

        // 실행 시 자판 올라오는 현상 막기
        homeBinding.fraHomSearchText.clearFocus()
        mainActivity.hideKeyboard(mainActivity)

        // 검색 기록 띄우기
        thread {
            homeBinding.fraHomHistoryList.adapter = historyAdapter

            mainActivity.historyList.clear()
            mainActivity.historyList.addAll(mainActivity.historyDatabase.historyDao().getHistory())
            historyAdapter.notifyDataSetChanged()

            // 리스트가 비어 있으면 empty 보여주기
            if(mainActivity.historyList.isEmpty()) {
                mainActivity.runOnUiThread {
                    homeBinding.fraHomEmptyHistory.visibility = View.VISIBLE
                    homeBinding.fraHomHistory.visibility = View.GONE
                }
            } else { // 리스트가 있으면 보여주기
                mainActivity.runOnUiThread {
                    homeBinding.fraHomHistory.visibility = View.VISIBLE
                    homeBinding.fraHomEmptyHistory.visibility = View.GONE
                }
            }
        }

        homeBinding.fraHomSearchButton.setOnClickListener(this)
        homeBinding.fraHomHistoryDeleteAll.setOnClickListener(this)

        return homeBinding.root
    }

    override fun onClick(view : View?) {
        when(view) {
            // 검색 버튼
            homeBinding.fraHomSearchButton -> {
                // 검색어 변수에 담기
                val searchText = homeBinding.fraHomSearchText.text.toString().trim()

                // 공백 입력 시 리턴
                if(searchText.isEmpty()) {
                    Snackbar.make(homeBinding.root, "❗검색어를 입력해주세요", Snackbar.LENGTH_SHORT).show()
                    return
                }

                // 메인에 검색어 담아두기
                mainActivity.searchWord = searchText

                // 돌아왔을 경우 검색어 비워두기
                homeBinding.fraHomSearchText.setText("")

                // 자판 내리기
                mainActivity.hideKeyboard(mainActivity)

                thread {
                    val historyEntity = HistoryEntity(null, searchText)
                    mainActivity.historyDatabase.historyDao().insertHistory(historyEntity)

                    // 프래그먼트 전환
                    mainActivity.fragmentController("search", true)
                }
            }

            // 검색 기록 비우기
            homeBinding.fraHomHistoryDeleteAll -> {
                thread {
                    mainActivity.historyDatabase.historyDao().deleteAllHistory()

                    mainActivity.runOnUiThread {
                        mainActivity.historyList.clear()
                        historyAdapter.notifyDataSetChanged()

                        homeBinding.fraHomEmptyHistory.visibility = View.VISIBLE
                        homeBinding.fraHomHistory.visibility = View.GONE
                    }

                    Snackbar.make(homeBinding.root, "❗검색 기록이 비워졌습니다", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
}