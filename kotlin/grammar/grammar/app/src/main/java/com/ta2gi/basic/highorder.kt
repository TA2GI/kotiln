package com.ta2gi.basic

fun main() {
    // 익명함수 사용
    val fun1 = fun(n1 : Int, n2 : Int) : Int {
        return n1 + n2
    }
    higFunction1(fun1, 100, 200)

    // 익명함수를 바로 넣어 사용 가능
    higFunction1(fun(n1 : Int, n2 : Int) : Int {
        return n1 - n2
    }, 100, 200)

    // 람다 사용
    val lambda1 = { n1 : Int, n2 : Int -> n1 * n2 }
    higFunction1(lambda1, 100, 200)

    // 람다를 바로 넣어 사용 가능
    higFunction1({n1 : Int, n2 : Int -> n1 / n2}, 200, 100)

    ///////////////////////////////////////////////////

    val fun2 = higFunction2()
    val result2 = fun2(100, 200)
    println("result2 : $result2")

    val fun3 = higFunction3()
    val result3 = fun3(100, 200)
    println("result3 : $result3")
}

// 매개 변수가 함수인 고차함수
fun higFunction1(f:(Int, Int) -> Int, num1 : Int, num2 : Int) {
    val result1 = f(num1, num2)
    println("result1 : $result1")
}

// 반환 타입이 함수인 고차함수
fun higFunction2() : (Int, Int) -> Int {
    return fun(n1 : Int, n2 : Int) : Int {
        return n1 + n2
    }
}

// 반환 타입이 람다인 고차함수
fun higFunction3() : (Int, Int) -> Int {
    return { n1 : Int, n2 : Int -> n1 - n2 }
}