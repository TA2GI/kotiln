package com.ta2gi.basic

fun main() {
    enuFunction1(EnuClass1.SOUTH)
    enuFunction2(EnuClass2.TWO)
}

enum class EnuClass1 {
    NORTH, SOUTH, WEST, EAST
}

enum class EnuClass2(val num : Int, val str : String) {
    ONE(1,"하나"), TWO(2,"둘"), THREE(3,"셋")
}

fun enuFunction1(what : EnuClass1) {
    when(what) {
        EnuClass1.NORTH -> println("북쪽입니다.")
        EnuClass1.SOUTH -> println("남쪽입니다.")
        EnuClass1.WEST -> println("서쪽입니다.")
        EnuClass1.EAST -> println("동쪽입니다.")
    }
}

fun enuFunction2(what : EnuClass2) {
    when(what) {
        EnuClass2.ONE -> println("ONE입니다.")
        EnuClass2.TWO -> println("TWO입니다.")
        EnuClass2.THREE -> println("THREE입니다.")
    }

    // 분기가 가능
    when(what.num) {
        1 -> println("1입니다.")
        2 -> println("2입니다.")
        3 -> println("3입니다.")
    }

    when(what.str) {
        "하나" -> println("하나입니다.")
        "둘" -> println("둘입니다.")
        "셋" -> println("셋입니다.")
    }
}