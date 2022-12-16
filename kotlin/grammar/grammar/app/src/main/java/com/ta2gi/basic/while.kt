package com.ta2gi.basic

fun main() {
//    var num = 0
//
//    while(num <= 10) {
//        print("$num, ")
//        num++
//    }


    var num = 0

    // 참일 경우
    do {
        print("$num, ")
        num++
    } while(num <= 10)

    println("\n──────────────")

    // 거짓일 경우
    do {
        print("$num, ")
        num++
    } while(num > 100)

}