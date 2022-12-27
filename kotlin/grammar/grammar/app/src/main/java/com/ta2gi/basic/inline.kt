package com.ta2gi.basic

fun main() {
    inlFunction1()
    inlFunction1()

    // inlFunction2() 함수내의 코드가 복사되어 덮어씌워짐
    inlFunction2()
    inlFunction2()

    /*
    코드가 실행되면 아래처럼 바뀜

    println("----------")
    println("inlFunction2 호출")
    println("----------")
    println("----------")
    println("inlFunction2 호출")
    println("----------")
    */
}

fun inlFunction1() {
    println("----------")
    println("inlFunction1 호출")
    println("----------")
}

inline fun inlFunction2() {
    println("----------")
    println("inlFunction2 호출")
    println("----------")
}