package com.ta2gi.note.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.ta2gi.note.MainActivity
import com.ta2gi.note.room.NoteEntity
import com.ta2gi.note.databinding.FragmentAddBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

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
                val editText = addBinding.addEdittext.text.toString().trim()

                // 공백일 경우
                if(editText.isEmpty()) {
                    mainActivity.hideKeyboard(mainActivity)
                    Snackbar.make(addBinding.root, "❗내용을 입력해주세요", Snackbar.LENGTH_SHORT).show()
                    return
                }

                // 오늘 날짜 가져오기(작성일)
                val sdf = SimpleDateFormat("yyyy.MM.dd", Locale.KOREAN)
                val date =  sdf.format(System.currentTimeMillis())

                // 노트 색상 정하기
                val noteColor = mainActivity.noteColor()

                // 노트 정보 객체에 넣기
                val entity = NoteEntity(null, editText, date, noteColor)
                // 데이터베이스에 노트 추가
                thread {
                    mainActivity.noteDatabase.noteDao().insertNote(entity)

                    // 어뎁터에 리스트 변경 사항 알려주고 키보드 내리기
//                    mainActivity.noteAdapter.notifyDataSetChanged()
                    mainActivity.hideKeyboard(mainActivity)

                    mainActivity.supportFragmentManager.popBackStack()
                }
            }
        }
    }
}