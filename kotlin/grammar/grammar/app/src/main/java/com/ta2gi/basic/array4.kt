package com.ta2gi.basic

fun main() {
    val arr1 = arrayOf(arrayOf(10, 20, 30), arrayOf(40, 50, 60), arrayOf(70, 80, 90))
    // 주소값만 나옴
    println("arr1 : $arr1")
    println("arr1 : ${arr1.contentToString()}")
    // 값들을 나오게 하려면 contentDeepToString()
    println("arr1 : ${arr1.contentDeepToString()}")

    // 다 차원 배열을 for문에 사용
    for(item1 in arr1) {
        for(item2 in item1) {
            print("$item2, ")
        }
    }
}