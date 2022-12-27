package com.ta2gi.basic

fun main() {
    val list1 = mutableListOf<Int>()

    // 추가하기
    list1.add(10)
    list1.add(20)
    list1.add(30)
    println("list1 : $list1")

    // 배열이나 리스트 추가
    list1.addAll(listOf(40, 50, 60))
    println("list1 : $list1")

    // 특정 요소 삽입 (index 1을 100으로 변경)
    list1.add(1, 100)
    println("list1 : $list1")

    // 전체 삽입
    list1.addAll(2, listOf(400, 500, 600))
    println("list1 : $list1")

    // 특정 요소 삭제
    list1.remove(100)
    println("list1 : $list1")

    // 특정 요소들 삭제
    list1.removeAll(listOf(400, 500))
    println("list1 : $list1")

    // 해당 인덱스 삭제
    list1.removeAt(1)
    println("list1 : $list1")

    // 값 변경
    list1.set(0, 100)
    list1[1] = 200
    println("list1 : $list1")

    val list2 = listOf<Int>()

    // 불변형 -> 가변형
    // 값들을 그대로 가져와 가변형으로 바꾼다
    val list3 = list2.toMutableList()
    list3.add(100)
    println("list3 : $list3")

    // 가변형 -> 불변형
    val list4 = list3.toList()
    // 가변형이므로 오류가 뜸
    //list4.add(200)
}