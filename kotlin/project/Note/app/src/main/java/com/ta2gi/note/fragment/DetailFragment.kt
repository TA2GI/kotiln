package com.ta2gi.note.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ta2gi.note.MainActivity
import com.ta2gi.note.R
import com.ta2gi.note.databinding.FragmentDetailBinding
import com.ta2gi.note.room.NoteEntity
import kotlin.concurrent.thread

class DetailFragment(val mainActivity : MainActivity) : Fragment(), View.OnClickListener {

    lateinit var detailBinding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        detailBinding = FragmentDetailBinding.inflate(inflater)

        detailBinding.detTitle.text = mainActivity.noteDate
        detailBinding.detText.text = mainActivity.noteText

        detailBinding.detCancel.setOnClickListener(this)
        detailBinding.detEdit.setOnClickListener(this)
        detailBinding.detDelete.setOnClickListener(this)

        return detailBinding.root
    }

    override fun onClick(view : View?) {
        when(view) {
            // 돌아가기 버튼
            detailBinding.detCancel -> {
                // 홈 화면으로 돌아가면서 클릭했던 노트의 정보를 초기화
                mainActivity.noteUid = null
                mainActivity.noteText = null
                mainActivity.noteDate = null
                mainActivity.noteColor = null

                mainActivity.supportFragmentManager.popBackStack()
            }

            // 수정하기 버튼
            detailBinding.detEdit -> mainActivity.fragmentController("edit", true)

            // 삭제 버튼
            detailBinding.detDelete -> {
                thread {
                    val entity = NoteEntity(mainActivity.noteUid!!, mainActivity.noteText!!, mainActivity.noteDate!!, mainActivity.noteColor!!)
                    mainActivity.noteDatabase.noteDao().deleteNote(entity)

                    // 노트가 삭제된지 알려주기
//                    mainActivity.noteAdapter.notifyDataSetChanged()

                    // 홈 화면으로 돌아가면서 클릭했던 노트의 정보를 초기화
                    mainActivity.noteUid = null
                    mainActivity.noteText = null
                    mainActivity.noteDate = null
                    mainActivity.noteColor = null

                    mainActivity.supportFragmentManager.popBackStack()
                }
            }
        }
    }

    // 수정하고 돌아온 후 수정된 텍스트로 바꾸기 위한 용도
    override fun onResume() {
        super.onResume()

        detailBinding.detText.text = mainActivity.noteText
    }
}