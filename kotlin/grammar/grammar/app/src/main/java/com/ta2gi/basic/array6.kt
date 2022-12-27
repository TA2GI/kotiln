package com.ta2gi.basic

fun main() {
    val arr1 = arrayOf(10, 20, 30, 40, 50)

    // 배열 추가하기
    val arr2 = arr1.plus(60)
    println("arr2 : ${arr2.contentToString()}")

    // 특정 부분 가져오기 (1 ~ 3)
    val arr3 = arr1.sliceArray(1..3)
    println("arr3 : ${arr3.contentToString()}")

    println("첫 번째 값 : ${arr1.first()}")
    println("마지막 값 : ${arr1.last()}")
    println("30의 위치 : ${arr1.indexOf(30)}")
    println("평균 값 : ${arr1.average()}")
    println("합친 값 : ${arr1.sum()}")
    println("개수 : ${arr1.count()}")
    println("개수 : ${arr1.size}")
    println("30을 포함하는지 : ${arr1.contains(30)}")
    println("1000을 포함하는지 : ${arr1.contains(1000)}")
    println("30을 포함하는지 : ${30 in arr1}")
    println("1000을 포함하는지 : ${1000 in arr1}")

    val arr4 = arrayOf(5, 1, 3, 4, 2)
    // 오름차순
    val arr5 = arr4.sortedArray()
    println("arr5 : ${arr5.contentToString()}")
    // 내림차순
    val arr6 = arr4.sortedArrayDescending()
    println("arr6 : ${arr6.contentToString()}")
}