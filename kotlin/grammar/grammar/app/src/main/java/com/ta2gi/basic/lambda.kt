package com.ta2gi.basic

fun main() {
    val lambda1 : (Int, Int) -> Int = { num1 : Int, num2 : Int -> num1 + num2 }
    val result1 = lambda1(100, 200)
    println(result1)

    // 람다 또한 타입 생략이 가능
    val lambda2 = { num1 : Int, num2 : Int -> num1 + num2 }
    val result2 = lambda2(200, 300)
    println(result2)

    // 앞의 타입을 보고 추론이 가능하기 때문에 괄호안의 타입 생략 가능
    val lambda3 : (Int, Int) -> Int = { num1, num2 -> num1 + num2 }
    val result3 = lambda2(300, 400)
    println(result3)

    val lambda4 = { num1 : Int, num2 : Int ->
        val result1 = num1 + num2
        val result2 = num1 - num2

        // 람다식에선 마지막이 return값
        result1 * result2
    }
    val result4 = lambda4(400, 500)
    println(result4)
}