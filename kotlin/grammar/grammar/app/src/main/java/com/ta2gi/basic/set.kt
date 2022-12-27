package com.ta2gi.basic

fun main() {
    val set1 = setOf(1, 5, 10, 1, 5, 10)
    println("set1 : $set1")

    val set2 = mutableSetOf<Int>()
    println("set2 : $set2")

    // for문을 통해 객체를 순회해야 함
    for(item in set1) {
        println("$item")
    }

    // 크기
    println("set1 : ${set1.size}")

    // 추가를 할 수 있지만 같은 객체일 경우 추가되지 않음
    set2.add(10)
    set2.add(20)
    set2.addAll(listOf(30, 40, 50, 1, 5, 10))
    println("set2 : $set2")

    // 값에 해당하는 것만 삭제
    set2.remove(5)
    println("set2 : $set2")

    // 불변형 -> 가변형, 가변형 -> 불변형 변경은 List와 Map이랑 똑같음
    // Set은 List로, List는 Set으로 서로 변경 가능
}