package com.ta2gi.basic

fun main() {
    val obj = BylClass()

    println("str : ${obj.str}")
}

class BylClass {
    val str by lazy {
        println("str 사용")
        "문자열"
    }
}