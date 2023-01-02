package com.ta2gi.todolist

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.ta2gi.todolist.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // binding 선언
    lateinit var binding: ActivityMainBinding

    // 할 일 목록을 담을 리스트 선언
    val todoList = mutableListOf<TodoEntity>()

    // adapter 선언
    val mainAdapter = MainAdapter(this, todoList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // binding 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // adapter 장착
        binding.maiList.adapter = mainAdapter

        // 클릭 리스너
        binding.maiAddButton.setOnClickListener(this)
    }

    override fun onClick(view : View?) {
        when(view) {
            binding.maiAddButton -> {
                // 입력한 문자열 가져오기
                val writeText = binding.maiTodoText.text.toString().trim()

                if(writeText.isEmpty()) {
                    // 스낵바 알림창 띄우기
                    Snackbar.make(binding.root, "❗공백은 입력할 수 없습니다", Snackbar.LENGTH_SHORT).show()
                    return
                }

                // 오늘 날짜 가져오기
                val sdf = SimpleDateFormat("YY.MM.dd", Locale.KOREAN)
                val date =  sdf.format(System.currentTimeMillis())

                // 리스트에 추가하기
                val todoEntity = TodoEntity(false, writeText, date)
                todoList.add(todoEntity)

                // adapter에 리스트가 변경된지 알려주기
                mainAdapter.notifyDataSetChanged()

                // 텍스트 비워주고 키보드 내리기
                binding.maiTodoText.setText("")
                hideKeyboard(this)
            }
        }
    }

    // 키보드 내리기
    fun hideKeyboard(act : Activity){
        val imm = act.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(act.currentFocus?.windowToken, 0)
    }

    // 다이얼로그
    fun todoDialog(todo : String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("할 일")
        builder.setMessage("$todo")
        builder.show()
    }
}