package com.ta2gi.basic

fun main() {
//    val obj1 = TestClass()
//    val obj2 = TestClass(10)
//    val obj3 = TestClass(10, 20)

    val obj = TestClass(10)
}

//class TestClass {
////    init {
////        println("init 코드입니다")
////    }
//    constructor() {
//        println("매개 변수가 없는 생성자")
//    }
//
//    constructor(num1 : Int) {
//        println("매개 변수가 한 개인 생성자")
//    }
//
//    constructor(num1 : Int, num2 : Int) {
//        println("매개 변수가 두 개인 생성자")
//    }
//}

//class TestClass1 constructor(var num1 : Int, var num2 : Int)
//// constructor 생략 가능
//class TestClass2 (var num1 : Int, var num2 : Int)

class TestClass constructor(var num1 : Int, var num2 : Int) {
    // 보조 생성자
    constructor(num : Int) : this(num, 30) {
        println("보조 생성자 호출")
   }
}