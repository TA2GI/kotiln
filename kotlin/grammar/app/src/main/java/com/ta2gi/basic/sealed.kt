package com.ta2gi.basic

fun main() {
    val n1 = SeaClass.SealedTwo(1)
    checkNumber(n1)

    val n2= SeaClass.SealedTwo(2)
    checkNumber(n2)

    val n3= SeaClass.SealedThree(3, 3.0)
    checkNumber(n3)
}

sealed class SeaClass {
    class SealedOne(val num : Int) : SeaClass()
    // 메서드도 작성할 수 있음
    class SealedTwo(val num : Int) : SeaClass() {
        fun seaFunction() {
            println("seaFunction 호출")
        }
    }
    class SealedThree(val num : Int, val num2 : Double) : SeaClass()
}

fun checkNumber(number : SeaClass) {
    when(number) {
        // 클래스타입 검사는 is를 쓰면 됨
        is SeaClass.SealedOne -> {
            println("SealedOne")
            println(number.num)
        }

        is SeaClass.SealedTwo -> {
            println("SealedTwo")
            println(number.num)

            when(number.num) {
                1 -> println("1입니다.")
                2 -> println("2입니다.")
                3 -> println("3입니다.")
            }

            number.seaFunction()
        }

        is SeaClass.SealedThree -> {
            println("SealedThree")
            println(number.num)

            when(number.num) {
                3 -> println("3입니다.")
            }

            when(number.num2) {
                3.0 -> println("3.0입니다.")
            }
        }
    }
}