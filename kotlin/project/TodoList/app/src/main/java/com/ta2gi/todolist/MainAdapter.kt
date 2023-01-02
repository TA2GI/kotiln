package com.ta2gi.todolist

import android.app.AlertDialog
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainAdapter(val mainActivity : MainActivity, val todoList : MutableList<TodoEntity>) : RecyclerView.Adapter<MainAdapter.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolderClass {
        // 대충 항목의 layout은 R.layout.list_item이라는 것
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolderClass, position: Int) {
        // position 0 = 첫 번째 항목
        holder.state.isChecked = todoList[position].state
        holder.todo.text = todoList[position].todo
        holder.date.text = todoList[position].date

        // 할 일 항목을 클릭했을 경우
        holder.todo.setOnClickListener {
            mainActivity.todoDialog(holder.todo.text.toString())
        }
    }

    override fun getItemCount(): Int {
        // 리스트에 담긴 항목의 크기만큼 나오게하기
        return todoList.size
    }

    inner class ViewHolderClass(view : View) : RecyclerView.ViewHolder(view) {
        // 상태, 할 일, 날짜를 담고있는 애들
        val state = view.findViewById<CheckBox>(R.id.lis_state)
        val todo = view.findViewById<TextView>(R.id.lis_todo)
        val date = view.findViewById<TextView>(R.id.lis_date)
    }
}