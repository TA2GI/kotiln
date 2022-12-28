package com.ta2gi.basic

fun main() {
    var num = 1..10

    for(item in num) {
        print("$item, ")

        // item이 5일경우 반복문 종료
        if(item >= 5) {
            break
        }
    }
}