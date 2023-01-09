package com.ta2gi.note.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ta2gi.note.MainActivity
import com.ta2gi.note.R
import com.ta2gi.note.databinding.FragmentHomeBinding

class HomeFragment(val mainActivity : MainActivity) : Fragment(), View.OnClickListener {

    lateinit var homeBinding : FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeBinding = FragmentHomeBinding.inflate(inflater)

        // 어뎁터 끼우기
        homeBinding.homRecyclerview.adapter = mainActivity.noteAdapter

        // 클릭 이벤트가 있는 친구들은 setOnClickListener를 달아줘야 함
        homeBinding.homAdd.setOnClickListener(this)

        return homeBinding.root
    }

    override fun onClick(view : View?) {
        when(view) {
            // 추가 버튼
            // +를 누르면 AddFragment로 이동
            homeBinding.homAdd -> mainActivity.fragmentController("add", true)
        }
    }
}