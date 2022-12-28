package com.ta2gi.basic

fun main() {
    // 불변형 리스트
    val list1 = listOf(10, 20, 30, 40, 50)
    println("list1 : $list1")

    // 가변형 리스트
    // 값이 없다면 제네릭으로 타입을 정해줘야 함
    val list2 = mutableListOf<Int>()
    // String 타입의 값이 들어있기 때문에 타입 추론 가능
    val list3 = mutableListOf("가", "나", "다")
    println("list2 : $list2")
    println("list3 : $list3")

    // 비어져있는 불변형리스트
    val list4 = emptyList<Int>()
    println("list4 : $list4")

    // null을 제외한 값들을 사용
    val list5 = listOfNotNull(10, 20, null, 30, null, 40, 50)
    println("list5 : $list5")
}