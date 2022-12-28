package com.ta2gi.basic

fun main() {
    val obj = IntClass()
    obj.inter1Method()
    obj.inter2Method()
}

interface Inter1 {
    fun inter1Method() {
        println("inter1Method1 호출")
    }
}

interface Inter2 {
    fun inter2Method() {
        println("inter2Method 호출")
    }
}

class IntClass() : Inter1, Inter2 {
    override fun inter1Method() {
        super.inter1Method()
        println("IntClass에서 inter1Method 호출")
    }

    override fun inter2Method() {
        super.inter2Method()
        println("IntClass에서 inter2Method 호출")
    }
}