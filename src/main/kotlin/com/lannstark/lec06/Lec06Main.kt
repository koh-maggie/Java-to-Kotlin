package com.lannstark.lec06

/*
[정리]
1. for-each : Java 는 : Kotlin 은 in 을 사용한다.
2. 전통적인 for문 : Kotlin 에서 전통적인 for문은 등차수열을 이용.
    - Progression (등차수열) : 시작값, 끝값 ,공차  이 세값이 필요함.
    - Range
    -> .. 은 IntRange는 IntProgression 을 상속받고  IntProgression의 step 은 1로 지정되어 있음.
3. while / do-while은 Java 와 동일하다.
*/

fun main() {

    // for-each
    // listof 는 컬렉션
    val numbers = listOf<Long>(1L,2L,3L)

    // Java 는 : 으로 구분하지만, Kotlin 에서는 in 으로 사용
    // Iterable (=반복 가능한 객체) 타입이라면 모두 들어갈 수 있음.
    for(number in numbers) {
        println(number)
    }


    // 전통적인 for 문
    // ++
    // 1..3 -> 1에서 시작하고, 3으로 끝나는 등차수열을 만들어줘 라는 뜻.
    for(i in 1..3){
        println(i)
    }

    // --
    // downTo, step 모두 함수다.
    for(i in 3 downTo 1){
        println(i)
    }

    // 특정 step 만큼 증가
    for(i in 1..5 step 2){
        println(i)
    }
}
