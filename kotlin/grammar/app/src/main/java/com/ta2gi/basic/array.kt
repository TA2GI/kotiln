package com.ta2gi.basic

fun main() {
    // 내용을 출력하려면 contentToString()
    val arr1 = arrayOf(10, 20, 30, 40, 50)
    println("arr1 : $arr1")
    println("arr1 : ${arr1.contentToString()}")

    // 다양한 타입을 넣기
    val arr2 = arrayOf(10, 20.0, "가나다", true)
    println("arr2 : ${arr2.contentToString()}")

    // 한 가지 타입만 넣기
    // 맨 앞에 타입+ArrayOf를 붙이거나 제네릭 사용
    val arr3 = intArrayOf(10, 20, 30, 40, 50)
    val arr4 = arrayOf<Double>(1.0, 2.0, 3.0, 4.0, 5.0)
    println("arr3 : ${arr3.contentToString()}")
    println("arr4 : ${arr4.contentToString()}")
}