package com.ta2gi.basic

fun main() {
    // 이름으로 사용 할 타입, 객체의 타입을 작성해줘야 함
    // 추론이 가능하다면 생략 가능
    // 불변형
    val map1 = mapOf("key1" to 10, "key2" to 20, "key3" to 30)
    println("map1 : $map1")

    // 가변형
    val map2 = mutableMapOf<String, Int>()
    println("map2 : $map2")

    // 타입을 다양하게 쓴다면 Any를 쓰면 됨
    val map3 = mutableMapOf<String, Any>("key1" to 10, "key2" to "가", "key3" to false)
    println("map3 : $map3")

    // 객체 가져오기
    println("map1 key1 : ${map1.get("key1")}")
    println("map1 key2 : ${map1["key2"]}")

    // 메서드
    println("map1 size : ${map1.size}")
    println("map1 keys : ${map1.keys}")
    println("map1 values : ${map1.values}")

    // key로 유무 확인
    println("map1 containts key1 : ${map1.containsKey("key1")}")
    println("map1 containts key100 : ${map1.containsKey("key100")}")

    // value로 유무 확인
    println("map1 containts value 10 : ${map1.containsValue(10)}")
    println("map1 containts value 100 : ${map1.containsValue(100)}")

    // 가변형 Map의 메서드
    println("map2 : $map2")

    // 추가하기
    map2.put("key1", 100)
    println("map2 : $map2")

    // 없는 이름으로 추가하면 자동으로 추가가 됨
    map2["key2"] = 200
    println("map2 : $map2")

    // 같은 이름이 존재한다면 value 변경
    map2.put("key1", 1000)
    map2["key2"] = 2000
    println("map2 : $map2")

    // 삭제
    map2.remove("key1")
    println("map2 : $map2")

    // 불변형 -> 가변형
    val map100 = map1.toMutableMap()
    map100["key100"] = 1000
    println("map100 : $map100")

    // 가변형 -> 불변형
    val map200 = map100.toMap()
    // 불변형이므로 오류
    //map200["key100"] = 1000
}