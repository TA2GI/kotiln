package com.ta2gi.note.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ta2gi.note.MainActivity
import com.ta2gi.note.NoteEntity
import com.ta2gi.note.R
import com.ta2gi.note.databinding.FragmentAddBinding
import java.text.SimpleDateFormat
import java.util.*

class AddFragment(val mainActivity : MainActivity) : Fragment(), View.OnClickListener {

    lateinit var addBinding : FragmentAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        addBinding = FragmentAddBinding.inflate(inflater)

        addBinding.addCancel.setOnClickListener(this)
        addBinding.addComplete.setOnClickListener(this)

        return addBinding.root
    }

    override fun onClick(view : View?) {
        when(view) {
            // 돌아가기 버튼
            // 이전의 프래그먼트로 돌아가기
            addBinding.addCancel -> mainActivity.supportFragmentManager.popBackStack()

            // 완료 버튼
            addBinding.addComplete -> {
                // 텍스트에 적힌 내용 가져오기
                val editText = addBinding.addEdittext.text.toString()

                // 오늘 날짜 가져오기(작성일)
                val sdf = SimpleDateFormat("yyyy.MM.dd", Locale.KOREAN)
                val date =  sdf.format(System.currentTimeMillis())

                // 노트 색상 랜덤으로 정하기
                // 해야됨

                val entity = NoteEntity(editText, date, "#000000")
                // 리스트에 추가한 노트 넣기
                mainActivity.noteList.add(entity)

                // 어뎁터에 리스트 변경 사항 알려주고 키보드 내리기
                mainActivity.noteAdapter.notifyDataSetChanged()
                mainActivity.hideKeyboard(mainActivity)

                mainActivity.supportFragmentManager.popBackStack()
            }
        }
    }
}