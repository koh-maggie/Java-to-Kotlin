package com.lannstark.lec01

fun main () {

    /*
    var : 가변
    val : 불변 (read-only)

    [정리]
    - 코틀린은 자동으로 변수 타입을 컴파일러가 추론 해줌.
    - 변수 타입 지정하고 싶을 경우 : 타입 지정하면 됨.
    - 모든 변수는 우선 val 로 만들고 , 필요 시 var 로 변경해야 클린 코드 가능.
    - 코틀린은 null이 들어갈 수 있다면 `타입?` 를 사용해야 함.
    - 코틀린에서 객체 인스턴스 시, new 를 붙이지 않아야 함.
    - 코틀린 -> 자바 코드 디컴파일 하는 방법 (Tools > Kotlin > Show Kotlin Byte Code)
     */

    /* **************************************************** */
    // 가변
    // var number1:Long = 10L;
    // number1 = 5L;

    // val number2 = 10L;
    // number2 = 5L; // Val cannot be reassigned

    /* **************************************************** */
    // 초기 값을 지정해주지 않는 경우는 Type 지정 필요
    // var number : ...

    // var number1 : Long = 5L;
    // 초기화 되지 않은 값으로 number1은 오류 발생
    // 초기화 된 값은 정상적으로 출력
    // print(number1);

    /* **************************************************** */
    // Primitive type , Reference type 상관없이, 코틀린이 알아서 처리해줌.
    // java code :  long number1 = 10L; // (1)
     // var number1 : Long = 10L;

    // java code : Long number3 = 1_000L; // (3)
    // var number3 : Long = 1_000L;

    /* **************************************************** */
    // 기본적으로 변수에 null을 넣을 수 없게 되어 있음.
    // 코틀린은 null이 들어갈 수 있다면 `타입?` 를 사용해야 함.
    // var number3 : Long? = 1_000L
    // number3 = null

    /* **************************************************** */
    // java code : Person person = new Person("최태현"); // (4)
    // 코틀린에서 객체 인스턴스 시, new 를 붙이지 않아야 함.
    var person = Person("고매기")


}