package com.ta2gi.basic

fun main() {
    val obj = LatClass()
    obj.letMethod()
}

class LatClass {
    lateinit var str : String

    fun letMethod() {
        // ::는 리플렉션이라 부르고 해당 객체와 관련된 클래스를 파악하기 위해 사용
        // isInitialized는 초기화 된적이 있는지 확인함
        if(!::str.isInitialized) {
            str = "문자열"
            println("$str")
        }
    }
}