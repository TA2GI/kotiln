package com.ta2gi.note

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.ta2gi.note.databinding.ActivityMainBinding
import com.ta2gi.note.fragment.AddFragment
import com.ta2gi.note.fragment.DetailFragment
import com.ta2gi.note.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    // 프래그먼트를 담을 변수
    lateinit var currentFragment: Fragment

    // 노트 리스트
    val noteList = mutableListOf<NoteEntity>()

    // 어뎁터
    val noteAdapter = NoteAdapter(this, noteList)

    // 노트 색상 순번 변수
    var noteCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        // 초기화면
        fragmentController("home", add = false)
    }

    // 프래그먼트
    fun fragmentController(view: String, add: Boolean) {
        // 들어오는 view 값에 따라 프래그먼트 변경
        when (view) {
            "home" -> currentFragment = HomeFragment(this)
            "add" -> currentFragment = AddFragment(this)
            "detail" -> currentFragment = DetailFragment()
        }

        // 프래그먼트 교체 해주기
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mai_screen, currentFragment)

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
}