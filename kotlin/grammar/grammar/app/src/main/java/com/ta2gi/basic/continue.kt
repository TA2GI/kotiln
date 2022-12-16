package com.ta2gi.basic

fun main() {
    var num = 1..10

    for(item in num) {
        // item이 2와 나눴을 때 나머지가 0이면 다음 반복으로 넘어감
        if(item % 2 == 0) {
            continue
        }

        print("$item, ")
    }
}