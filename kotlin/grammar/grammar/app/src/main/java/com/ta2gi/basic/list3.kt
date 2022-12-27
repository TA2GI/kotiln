package com.ta2gi.basic

fun main() {
    val list1 = listOf(10, 20, 30, 40, 50)

    // 특정 값 가져오기
    println("list1 0 : ${list1.get(0)}" )
    println("list1 1 : ${list1[1]}" )

    val list2 = listOf(10, 20, 30, 40, 50, 10)

    // 특정 요소 찾기
    val index1 = list2.indexOf(10)
    println("10 index : $index1")

    // indexOf : 앞에서부터 찾음
    // lastIndexOf : 뒤에서부터 찾음
    val index2 = list2.lastIndexOf(10)
    println("10 index : $index2")

    // 특정 값을 추출해 새로운 리스트를 생성
    val list3 = list1.subList(1, 3)
    println("list3 : $list3")
}