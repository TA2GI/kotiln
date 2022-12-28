package com.ta2gi.basic

fun main() {
    var num = function1(10)
    println("num : $num")
}

fun function1(n : Int) : Int {
    println("function1 호출")

    // n이 10이기때문에 return -1을 만나 num에는 -1이 들어감
    if(n == 10) {
        return -1
    }

    // 위에서 return을 만났기 때문에 아래 코드들은 실행되지 않음
    return n + 100
}