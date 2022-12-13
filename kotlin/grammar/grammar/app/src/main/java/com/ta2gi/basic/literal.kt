package com.ta2gi.basic

fun main() {
    // 리터럴(Literal) : 코드 작성시 값을 작성하는 문법
    // 정수 리터럴
    println(100)
    println(10000000000)
    println(10000000000L)
    println(123_456_789_000)
    
    // 실수 리터럴
    println(11.11)
    println(22.22F)
    
    // 문자 리터럴
    println('A')
    println('가')
    
    // 문자열 리터럴
    println("문자열")

    // Raw String
    println("""
        동해물과 백두산이
        마르고 닳도록
        하느님이 보우하사
        우리나라 만세
    """.trimIndent())
    
    // 논리 리터럴
    println(true)
    println(false)
}