package com.ta2gi.note

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ta2gi.note.room.NoteEntity

class NoteAdapter(val mainActivity : MainActivity, val noteList : MutableList<NoteEntity>) : RecyclerView.Adapter<NoteAdapter.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.ViewHolderClass {
        // 항목의 layout은 R.layout.list_item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolderClass, position: Int) {
        // 노트 내용 넣기
        holder.note.text = noteList[position].note
        // 노트 색상 넣기
        holder.background.backgroundTintList = ColorStateList.valueOf(Color.parseColor(noteList[position].color))

        holder.note.setOnClickListener {
            // 클릭한 노트 정보 담고 프래그먼트 이동
            mainActivity.noteUid = noteList[position].uid
            mainActivity.noteText = holder.note.text.toString()
            mainActivity.noteDate = noteList[position].date
            mainActivity.noteColor = noteList[position].color
            mainActivity.fragmentController("detail", true)
        }
    }

    override fun getItemCount(): Int {
        // 리스트에 담긴 항목의 크기만큼 나오게하기
        return noteList.size
    }

    inner class ViewHolderClass(view : View) : RecyclerView.ViewHolder(view) {
        val background = view.findViewById<LinearLayout>(R.id.ite_layout)
        val note = view.findViewById<TextView>(R.id.ite_text)
    }
}