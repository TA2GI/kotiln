package com.ta2gi.basic

fun main() {
    // 추상 클래스는 객체를 생성할 수 없음
    //val obj = AbsClass1()

    val obj = AbsClass2()
    obj.absMethod()
}

open abstract class AbsClass1 {
    open abstract fun absMethod()
}

class AbsClass2 : AbsClass1() {
    override fun absMethod() {
        println("absMethod 호출")
    }
}