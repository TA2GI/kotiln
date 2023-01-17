package com.ta2gi.searchbook

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.snackbar.Snackbar
import com.ta2gi.searchbook.databinding.ActivityMainBinding
import com.ta2gi.searchbook.fragment.HomeFragment
import com.ta2gi.searchbook.fragment.SearchFragment

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // 뷰바인딩
    lateinit var mainBinding : ActivityMainBinding

    // 프래그먼트를 담을 변수
    lateinit var currentFragment : Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰바인딩 초기화
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        // 실행 시 첫 화면 HomeFragment
        fragmentController("home", false)

        mainBinding.actMainSearchButton.setOnClickListener(this)
    }

    // 프래그먼트
    fun fragmentController(view: String, add: Boolean) {
        // 들어오는 view 값에 따라 프래그먼트 변경
        when (view) {
            "home" -> currentFragment = HomeFragment(this)
            "search" -> currentFragment = SearchFragment(this)
        }

        // 프래그먼트 교체 해주기
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.act_main_screen, currentFragment)

        // 백스텍에 추가
        if (add) fragmentTransaction.addToBackStack(view)

        // 애니메이션 효과 넣기
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)

        // 프래그먼트 실행
        fragmentTransaction.commit()
    }

    // 키보드 내리기
    fun hideKeyboard(act : Activity){
        val imm = act.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(act.currentFocus?.windowToken, 0)
    }

    override fun onClick(view : View?) {
        when(view) {
            mainBinding.actMainSearchButton -> {
                val searchText = mainBinding.actMainSearchText.text.toString().trim()

                // 공백 입력 시 리턴
                if(searchText.isEmpty()) {
                    Snackbar.make(mainBinding.root, "❗검색어를 입력해주세요", Snackbar.LENGTH_SHORT).show()
                    return
                }

                // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@보류@@@@@@@@@@@@@@@@@@@@@@@@@@@
                // 계속해서 검색한다면 SearchFragment가 겹치기때문에 뒤로가기를 눌러도 검색한 수 만큼
                // SearchFragment가 나오므로 현재 프래그먼트가 SearchFragment라면 백스텍에 쌓지 않음
//                if(currentFragment is SearchFragment) {
//                    fragmentController("search", false)
//                } else {
//                    fragmentController("search", true)
//                }

                // 검색 후 자판 내리기
                hideKeyboard(this)
            }
        }
    }
}