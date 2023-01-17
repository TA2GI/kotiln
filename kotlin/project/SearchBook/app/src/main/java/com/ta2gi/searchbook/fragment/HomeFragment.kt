package com.ta2gi.searchbook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ta2gi.searchbook.MainActivity
import com.ta2gi.searchbook.R
import com.ta2gi.searchbook.databinding.FragmentHomeBinding

class HomeFragment(val mainActivity : MainActivity) : Fragment() {

    // 뷰바인딩
    lateinit var homeBinding : FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // 뷰바인딩 초기화
        homeBinding = FragmentHomeBinding.inflate(inflater)

        return homeBinding.root
    }
}