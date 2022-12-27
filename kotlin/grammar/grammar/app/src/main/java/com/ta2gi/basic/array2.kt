package com.ta2gi.basic

fun main() {
    // 크키는 5, 값들은 0으로 만들기
    val arr1 = Array(5, {0})
    println("arr1 : ${arr1.contentToString()}")

    // 람다를 이용
    // it에는 0부터 1씩 증가하는 값이 들어감
    val arr2 = Array(5) {it * 2}
    println("arr2 : ${arr2.contentToString()}")
}