package com.ta2gi.searchbook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ta2gi.searchbook.MainActivity
import com.ta2gi.searchbook.R
import com.ta2gi.searchbook.databinding.FragmentSearchBinding

class SearchFragment(val mainActivity : MainActivity) : Fragment() {

    lateinit var searchFragment : FragmentSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        searchFragment = FragmentSearchBinding.inflate(inflater)

        return searchFragment.root
    }
}