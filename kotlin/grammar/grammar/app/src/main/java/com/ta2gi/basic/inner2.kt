package com.ta2gi.basic

fun main() {
    val obj1 = InnClass1()
    obj1.innAbsFunction()

    val obj2 = InnClass2()
    obj2.innIntFunction()

    // 익명 중첩 클래스
    val obj3 = object : InnClass1() {
        override fun innAbsFunction() {
            println("익명 중첩 클래스의 innAbsFunction 호출")
        }
    }
    obj3.innAbsFunction()

    val obj4 = object : InnClass2() {
        override fun innIntFunction() {
            println("익명 중첩 클래스의 innIntFunction 호출")
        }
    }
    obj4.innIntFunction()
}

abstract class InnAbsClass {
    abstract fun innAbsFunction()
}

interface InnIntClass {
    fun innIntFunction()
}

// 추상 클래스를 상속받은 클래스
open class InnClass1 : InnAbsClass() {
    override fun innAbsFunction() {
        println("innAbsFunction 호출")
    }
}

// 인터페이스를 구현한 클래스
open class InnClass2 : InnIntClass {
    override fun innIntFunction() {
        println("innIntFunction 호출")
    }
}