package com.ta2gi.basic

fun main() {
    val obj1 = GenClass1<Int>()
    obj1.genClass1function(100)

    val obj2 = GenClass2<Double>(100.0)
    obj2.genClass2function(200.0)

    val obj3 = GenClass3<Int, Double>()
    obj3.genClass3function(100, 100.0)

    val obj4 = GenClass4<Int, Double, String, Boolean>(100,100.0)
    obj4.genClass4function("가나다", false)
}

// 객체를 만들 때 <>안에 타입을 넣어준다면 해당 타입만 넣을 수 있음
class GenClass1<T> {
    fun genClass1function(what : T) {
        println("genClass1function what : $what")
    }
}

class GenClass2<T>(var what1 : T) {
    fun genClass2function(what2 : T) {
        println("GenClass2 what : $what1")
        println("genClass2function what : $what2")
    }
}

// 한 개 이상의 타입을 넣을 수 있음
class GenClass3<A, B> {
    fun genClass3function(what1 : A, what2 : B) {
        println("genClass3function what1 : $what1")
        println("genClass3function what2 : $what2")
    }
}

class GenClass4<A, B, C, D>(var what1 : A, var what2 : B) {
    fun genClass4function(what3 : C, what4 : D) {
        println("GenClass4 what1 : $what1")
        println("GenClass4 what2 : $what2")
        println("genClass4function what3 : $what3")
        println("genClass4function what4 : $what4")
    }
}