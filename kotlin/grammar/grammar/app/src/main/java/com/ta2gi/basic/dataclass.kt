package com.ta2gi.basic

fun main() {
    val obj1 = DatClass("짱구", 10)
    val obj2 = DatClass("철수", 20)
    val obj3 = DatClass("맹구", 30)

    println("obj1 : ${obj1.name}, ${obj1.age}")
    println("obj2 : ${obj2.name}, ${obj2.age}")
    println("obj3 : ${obj3.name}, ${obj3.age}")
}

data class DatClass(
    val name : String,
    val age : Int
)