package com.ta2gi.searchbook

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.snackbar.Snackbar
import com.ta2gi.searchbook.databinding.ActivityMainBinding
import com.ta2gi.searchbook.fragment.HomeFragment
import com.ta2gi.searchbook.fragment.SearchFragment
import com.ta2gi.searchbook.retrofit2.KakaoData
import com.ta2gi.searchbook.retrofit2.KakaoInfo.Companion.API_KEY
import com.ta2gi.searchbook.retrofit2.RetrofitService.kakaoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    // 뷰바인딩
    lateinit var mainBinding : ActivityMainBinding

    // 프래그먼트를 담을 변수
    lateinit var currentFragment : Fragment

    // 검색어 저장 용도
    var searchWord = ""

    // 검색 기록, 검색 리스트
    var historyList = mutableListOf<String>()
    var searchList =

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰바인딩 초기화
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        // 실행 시 첫 화면 HomeFragment
        fragmentController("home", false)
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

    // 자판 내리기
    fun hideKeyboard(act : Activity){
        val imm = act.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(act.currentFocus?.windowToken, 0)
    }

    // 레트로핏
    fun searchResults(searchWord : String) {
        val book = kakaoService.getSearchBook(API_KEY, searchWord)

        book.enqueue(object: Callback<KakaoData> {
            override fun onResponse(call: Call<KakaoData>, response: Response<KakaoData>) {
                Log.d("로그", "통신 성공 : ${response.body()!!.documents}")
            }

            override fun onFailure(call: Call<KakaoData>, t: Throwable) {
                Log.d("로그", "통신 실패 : ${t.message}")
            }
        })
    }
}