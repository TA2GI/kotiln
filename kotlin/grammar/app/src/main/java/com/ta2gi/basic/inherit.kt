package com.ta2gi.basic

fun main() {
//    val sub = SubClass()
//
//    println("${sub.subMember}")
//    sub.subMethod()
//
//    // 상속을 받았기때문에 부모의 멤버 변수, 메서드를 쓸 수 있음
//    println("${sub.superMember}")
//    sub.superMethod()
}

//// 상속을 해줘야 하기 때문에 oepn을 붙여주자
//open class SuperClass {
//    var superMember = 100
//
//    fun superMethod() {
//        println("superMethod 호출")
//    }
//}
//
//// 상속을 받을 경우 부모 클래스의 생성자를 호출해야 함
//// 매개 변수가 없으므로 ()만 해줌
//class SubClass : SuperClass() {
//    var subMember = 100
//
//    fun subMethod() {
//        println("subMethod 호출")
//    }
//}

open class SuperClass(var num : Int)

class SubClass1 : SuperClass(100)
class SubClass2 : SuperClass {
    constructor() : super(100)
}