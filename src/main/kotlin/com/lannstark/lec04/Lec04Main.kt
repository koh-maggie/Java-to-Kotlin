package com.lannstark.lec04

/*
[정리]
- 단항, 산술, 산술대입 연산자 Java 와 동일
- 비교 연산자 사용법도 Java 와 동일 ( 객체끼리도 자동 호출되는 compareTo를 이용해 비교 연산자 사용 가능)
- in, !in / a..b / a[i] / a[i] = b 와 같이 코틀린에서 생긴 것도 있음
- 객체끼리의 연산자를 코틀린에서는 직접 정의 가능
*/

fun main() {

    val money1 = JavaMoney(2000L)
    val money2 = JavaMoney(1000L)

    /*
    java 와 다르게 객체 비교 시,
    비교 연산자를 사용하면 자동으로 compareTo 를 호출해줌.
     */
    if(money1 > money2){
        println("money1이 moneny2 보다 값이 큽니다.")
    }


    // == , ===
    val money3 = JavaMoney(1000L)
    val money4 = money3
    val money5 = JavaMoney(1000L)

    println(money3 == money4)

    // Lazy 연산
    if(fun1() || fun2()) {
        println("본문")
    }

    // 연산자 오버로딩 (Ex. plus)
    val money6 = Money(1000L)
    val money7 = Money(2000L)

    // 메소드 .plus 가 아니라 + 로도 할 수 있다.
    println(money6 + money7)

}

fun fun1() : Boolean {
    print("fun1")
    return true;
}

fun fun2() : Boolean {
    print("fun2")
    return false;
}