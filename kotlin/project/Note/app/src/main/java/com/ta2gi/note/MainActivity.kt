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
import com.ta2gi.note.fragment.EditFragment
import com.ta2gi.note.fragment.HomeFragment
import com.ta2gi.note.room.NoteDatabase
import com.ta2gi.note.room.NoteEntity

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    // 프래그먼트를 담을 변수
    lateinit var currentFragment: Fragment

    // 노트 리스트
    val noteList = mutableListOf<NoteEntity>()

    // 어뎁터
    val noteAdapter = NoteAdapter(this, noteList)

    // 노트 색상 카운트
    var noteCount = 0

    // 클릭한 노트 정보
    var noteText : String? = null
    var noteDate : String? = null
    var noteColor : String? = null
    var noteUid : Int? = null

    // 데이터베이스
    lateinit var noteDatabase : NoteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        // 데이터베이스 생성
        noteDatabase = NoteDatabase.getInstance(this)!!

        // 초기화면
        fragmentController("home", add = false)
    }

    // 프래그먼트
    fun fragmentController(view: String, add: Boolean) {
        // 들어오는 view 값에 따라 프래그먼트 변경
        when (view) {
            "home" -> currentFragment = HomeFragment(this)
            "add" -> currentFragment = AddFragment(this)
            "detail" -> currentFragment = DetailFragment(this)
            "edit" -> currentFragment = EditFragment(this)
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

    // 노트 색상
    fun noteColor() : String {
        var noteColor = ""

        // 7이 되면 0부터 다시 시작
        if(noteCount == 7) noteCount = 0

        when (noteCount) {
            // 빨, 주, 노, 초, 파, 남, 보
            0 -> noteColor = "#E53935"
            1 -> noteColor = "#F4511E"
            2 -> noteColor = "#FFB300"
            3 -> noteColor = "#00897B"
            4 -> noteColor = "#1E88E5"
            5 -> noteColor = "#3949AB"
            6 -> noteColor = "#5E35B1"
        }
        noteCount++

        return noteColor
    }
}