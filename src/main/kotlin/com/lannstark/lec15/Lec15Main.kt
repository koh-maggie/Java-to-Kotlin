package com.lannstark.lec15

/*
[정리]
    - 배열의 사용법이 다름
    - 코틀린에서는 컬렉션을 만들때도 불변/가변을 지정해야함.
    - List, Set , Map 에 대한 사용법이 변경 및 확장됨.
    - 자바와 코틀린 코드를 섞어 컬렉션을 사용할 때에는 주의해야 함.
        - 자바에서 코틀린 컬렉션을 가져갈 때는 불변 컬렉션을 수정 가능
        - non-nullable 컬렉션에 null을 넣을 수 있음.
        - 코틀린 에서 자바 컬렉션을 가져갈 때는 플랫폼 타입을 주의 해야함.
*/

fun main() {

    val array = arrayOf(100,200)

    // index 를 활용한 방법
    for(i in array.indices){
        println("${i} ${array[i]}")
    }

    // index 뿐 아니라 value 까지 같이 받는 방법
    for((idx, value) in array.withIndex()){
        println("$idx $value")
    }

    // List
    // listOf 를 사용해서 불변 리스트를 만들수 있음.
    val numbers = listOf(100,200)
    // emptyList<타입> 을 사용하여 비어있는 리스트를 만들 수 있음.
    val emptyList = emptyList<Int>()


    // 아래 메소드에서 List<Int> 로 추론이 가능하기 때문에 오류 안남.
    printNumbers(emptyList())


    // 가변 리스트 만들기
    val numbers3 = mutableListOf(100,200)
    numbers3.add(300)

    // 가면 맵 만들기
    // 현재는 타입 추론이 안되기 때문에 <Int,String> 써준 것
    val oldMap = mutableMapOf<Int,String>()

    // Java 처럼 put 써도 되고, map[key] = value 를 쓸수도 있음.
    oldMap[1] = "Monday"
    oldMap[2] = "Tuseday";

    // mapOf(key to value) 를 사용해 불변 map 을 만들 수 있음.
    mapOf(1 to "Monday" , 2 to "Tuseday")


    for(key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for((key,value) in oldMap.entries) {
        println(key)
        println(value)
    }

}


private fun printNumbers(numbers:List<Int>) {

}