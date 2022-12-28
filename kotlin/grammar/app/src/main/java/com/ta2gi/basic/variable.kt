package com.ta2gi.basic

fun main() {
    // 변수
    // var는 값 변경 가능
    var a : Int = 100
    a = 200

    // val는 값 변경 불가능
    val b : Double = 10.0
    //b = 20.0 // 오류

    // 타입을 안적어주면 값에 따라 자동으로 타입이 바뀜
    var c = "가나다"

    // null 허용 변수
    var d : Int? = 1000
    var e : Int? = null

    println(d)
    println(e)

    // null 불허용 변수
    // 변수 e에는 이미 null이 들어가 있기 때문에 오류 발생
    //var f : Int = e!! // 오류

    e = 100

    var f : Int = e!!
    println(f)
}