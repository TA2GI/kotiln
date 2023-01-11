package com.ta2gi.note.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.ta2gi.note.MainActivity
import com.ta2gi.note.room.NoteEntity
import com.ta2gi.note.databinding.FragmentEditBinding
import kotlin.concurrent.thread

class EditFragment(val mainActivity : MainActivity) : Fragment(), View.OnClickListener {

    lateinit var editBinding : FragmentEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        editBinding = FragmentEditBinding.inflate(inflater)

        // 수정할 텍스트 가져오기
        editBinding.ediEdittext.setText(mainActivity.noteText)

        editBinding.ediCancel.setOnClickListener(this)
        editBinding.ediComplete.setOnClickListener(this)

        return editBinding.root
    }

    override fun onClick(view : View?) {
        when(view) {
            // 돌아가기 버튼
            editBinding.ediCancel -> mainActivity.supportFragmentManager.popBackStack()

            // 완료 버튼
            editBinding.ediComplete -> {
                // 텍스트에 적힌 내용 가져오기
                val editText = editBinding.ediEdittext.text.toString().trim()

                // 공백일 경우
                if(editText.isEmpty()) {
                    mainActivity.hideKeyboard(mainActivity)
                    Snackbar.make(editBinding.root, "❗내용을 입력해주세요", Snackbar.LENGTH_SHORT).show()
                    return
                }

                // 수정한 노트 정보 객체에 넣기
                val entity = NoteEntity(mainActivity.noteUid!!, editText, mainActivity.noteDate!!, mainActivity.noteColor!!)
                thread {
                    mainActivity.noteDatabase.noteDao().updateNote(entity)

                    // 완료하고 돌아갈 때 프래그먼트 텍스트를 수정한 텍스트로 바꿔주기
                    mainActivity.noteText = editText

                    // 어뎁터에 리스트 변경 사항 알려주고 키보드 내리기
//                    mainActivity.noteAdapter.notifyDataSetChanged()
                    mainActivity.hideKeyboard(mainActivity)

                    mainActivity.supportFragmentManager.popBackStack()
                }
            }
        }
    }
}