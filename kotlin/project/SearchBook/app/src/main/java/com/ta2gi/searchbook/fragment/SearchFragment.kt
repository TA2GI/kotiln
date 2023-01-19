package com.ta2gi.searchbook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ta2gi.searchbook.MainActivity
import com.ta2gi.searchbook.R
import com.ta2gi.searchbook.databinding.FragmentSearchBinding

class SearchFragment(val mainActivity : MainActivity) : Fragment(), View.OnClickListener {

    lateinit var searchBinding : FragmentSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        searchBinding = FragmentSearchBinding.inflate(inflater)

        searchBinding.fraSeaSearchText.setText(mainActivity.searchWord)

        searchBinding.fraSeaBack.setOnClickListener(this)

        return searchBinding.root
    }

    override fun onClick(view : View?) {
        when(view) {
            // 돌아가기
            searchBinding.fraSeaBack -> mainActivity.supportFragmentManager.popBackStack()

            // 검색

        }
    }
}