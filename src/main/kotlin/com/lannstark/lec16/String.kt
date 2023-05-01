package com.lannstark.lec16

/*
[정리]
- 자바가 코드가 있는 상황에서, 코트린 코드로 추가 기능을 개발하기 위해, 확장함수와 확장프로퍼티가 등장함.
```
fun 확장하려는클래스.함수이름(파라미터): 리턴타입 {
    //this (수신객체) 를 이용해 실제 클래스 안이 값에 접근 가능
}
```
- 확장함수
    - 원본 클래스의 private, protected 멤버 접근이 안됨.
    - 멤버함수, 확장함수 중 멤버함수에 우선권이 있음.
    - 확장함수는 현재 타입을 기준으로 호출됨.
    - 자바에서는 static 함수를 쓰는 것 처럼 코틀린의 확장함수를 쓸 수 있음.

- infix 함수
    - 함수 호출 방식을 바꿔주는 방식
    - A.함수이름(B) 가 아니라 A 함수이름 B

- inline 함수
    - 함수를 복사-붙여넣기 하는 함수

- 지역함수
    - 코틀린에서는 함수 안에 함수를 선언할 수 있고, 지역함수라고 함.
*/

fun main() {

    val str = "ABC"
    println( str.lastChar())

    // 확장함수와 멤버함수가 동일하면 멤버함수가 우선적으로 호출됨.
    val person = Person("A", "B" , 100)
    println(person)

}

/*
1. 확장함수
- String. -> 아 ~ String 클래스를 확장하는구나
- 함수안에서는 this를 통해 인스턴스 접근 가능

    fun 확장하려는클래스.함수이름(파라미터): 리턴타입 {
        //this (수신객체) 를 이용해 실제 클래스 안이 값에 접근 가능
    }
- 확장함수는 클래스에 있는 private , protected 멤버를 가져올 수 없음.
*/
fun String.lastChar() : Char {
    return this[this.length-1]
}

fun Person.nextYearAge() : Int {
    println("확장함수")
    return this.age + 1
}