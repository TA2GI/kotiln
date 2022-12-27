package com.ta2gi.basic

fun main() {
    val result1 = 100 add2 100
    println("result1 : $result1")

    val result2 = 100 minus2 100
    println("result2 : $result2")
}

infix fun Int.add2(num : Int) : Int {
    return this + num
}

infix fun Int.minus2(num : Int) : Int {
    return this - num
}