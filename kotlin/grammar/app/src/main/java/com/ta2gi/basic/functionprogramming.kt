package com.ta2gi.basic

fun main() {
    val result1 = fun1(100, 200)
    println(result1)

    val result2 = fun2(200, 300)
    println(result2)

    val result3 = fun2(300, 400)
    println(result3)
}

fun fun1(num1 : Int, num2 : Int) : Int {
    return num1 + num2
}

// fun1처럼 간단한 함수는 한 줄로 작성이 가능
fun fun2(num1 : Int, num2 : Int) : Int = num1 + num2

// 자동으로 타입을 알아낼 수 있으므로 반환 타입 생략 가능
fun fun3(num1 : Int, num2 : Int) = num1 + num2