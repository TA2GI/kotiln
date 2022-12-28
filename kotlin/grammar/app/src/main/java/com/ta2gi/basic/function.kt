package com.ta2gi.basic

fun main() {
//    function1()

    // 인자 : 100, 100.0
//    function2(100, 100.0)

//    function3(100)

//    var result = function4(100, 200)
//    println("반환 값 : $result")

//    function5()
//    function5(100)
//    function5(100, 10.0)

    // 에러 발생
//    function7()

    function6()
}

fun function6() {
    println("function6 호출")

    fun function7() {
        println("function7 호출")
    }

    function7()
}

fun function5() {
    println("function5() 호출")
}

fun function5(num1 : Int) {
    println("function5(Int) 호출")
}

fun function5(num1 : Int, num2 : Double) {
    println("function5(Int, Double) 호출")
}

fun function4(num1 : Int, num2 : Int) : Int{
    println("function4 호출")
    println("$num1 + $num2 = ${num1 + num2}")
    return num1 + num2
}

fun function3(num1 : Int = 0, str1 : String = "기본값") {
    println("function3 호출")
    println("num1 : $num1, str1 : $str1")
}

// 매개변수 : num1 : Int, num2 : Double
fun function2(num1 : Int, num2 : Double) {
    println("function2 호출")
    println("num1 : $num1, num2 : $num2")
}

fun function1() {
    println("function1 호출")
}