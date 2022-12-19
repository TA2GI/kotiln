package com.ta2gi.basic

fun main() {
//    val obj1 = TestObject()
//    val obj2 = TestObject()
//    val obj3 = obj1
//    println("obj1 : $obj1")
//    println("obj2 : $obj2")
//    println("obj3 : $obj3")

    val obj = TestObject()

    println("num1, num2 : ${obj.num1}, ${obj.num2}")

    // num1은 val로 선언했기 때문에 값을 바꿀 수 없음
//  ㄴobj.num1 = 20
    obj.num2 = 200

    println("num1, num2 : ${obj.num1}, ${obj.num2}")

    obj.testMethod()
}

class TestObject {
    val num1 = 10
    var num2 = 100

    fun testMethod() {
        println("testMethod 호출")
    }
}