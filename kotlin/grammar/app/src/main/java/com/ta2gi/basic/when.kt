package com.ta2gi.basic

fun main() {
    val num = 100

//    when(num) {
//        1 -> {
//            println("num은 1입니다.")
//        }
//
//        10 -> {
//            println("num은 10입니다.")
//        }
//
//        100 -> {
//            println("num은 100입니다.")
//        }
//
//        else -> {
//            println("모두 아닙니다.")
//        }
//    }

    fun setString(num : Int) = when(num) {
        100 -> println("맞습니다")
        else -> println("틀렸습니다")
    }

    setString(num)
}