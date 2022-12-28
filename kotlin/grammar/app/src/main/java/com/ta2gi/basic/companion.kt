package com.ta2gi.basic

fun main() {
    // 객체를 생성해야 그 안의 내용들을 쓸 수 있음
    val obj = ComClass()

    println("obj.num1 : ${obj.num1}")
    obj.comFunction1()

    // companion은 객체를 생성하지 않고 바로 사용 가능
    println("obj.num2 : ${ComClass.num2}")
    ComClass.comFunction2()
}

class ComClass {
    var num1 = 100

    fun comFunction1() {
        println("comFunction1 호출")
    }

    companion object {
        var num2 = 200

        fun comFunction2() {
            println("comFunction2 호출")
        }
    }
}