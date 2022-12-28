package com.ta2gi.basic

fun main() {
    // 특정 값 가져오기
    val arr1 = arrayOf(10, 20, 30, 40, 50)
    println("arr1 0 : ${arr1[0]}")
    println("arr1 1 : ${arr1[1]}")
    println("arr1 2 : ${arr1[2]}")
    println("arr1 3 : ${arr1[3]}")
    println("arr1 4 : ${arr1[4]}")

    // 값 수정하기
    arr1[0] = 100
    arr1.set(1, 200)
    println("arr1 : ${arr1.contentToString()}")

    // 배열의 크기
    println("arr1 size : ${arr1.size}")
}