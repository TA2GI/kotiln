package com.ta2gi.basic

fun main() {
    var str = "abcd"
    println(str.extFunction())
}

// 기존 String 클래스에 메서드를 추가한것처럼 보이지만
// 실제로는 그냥 일반적인 메서드로 만들고 객체의 주소값을 전달받음
fun String.extFunction() : String {
    return this.toUpperCase()
}