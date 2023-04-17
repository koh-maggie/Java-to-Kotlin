package com.lannstark.lec11


/*
[정리]
- Java
    - public : 모든 곳에서 접근 가능
    - protected  : 같은 패키지 , 하위 클래스에서만 접근 가능
    - default : 같은 패키지에서만 접근 가능
    - private : 선언된 클래스 내에서만 접근 가능

- Kotlin ( 패키지는 패키지일뿐으로 봄. namespace 관리용으로 봄. )
    - public : 모든 곳에서 접근 가능
    - protected : 선언된 클래스 , 하위클래스에서만 접근 가능
    - internal : 같은 모듈에서만 접근 가능
    - private : 선언된 클래스 내에서만 접근 가능

- 생성자에 접근 지시어 붙일경우 , constructor 명시적으로 붙여야함. (기본 public)
- 유틸성함수는 최상단에 써주는 것이 편함.
- 프로퍼티의 custom setter 의 접근 지시어를 붙일 수 있음.
- Java 에서 Kotlin 코드를 사용할 때, internal 과 protected 는 주의 필요.
    - internal 이라도, Java 에서는 같은 패키지에서 사용 가능

*/

// 접근지시어 가시성별로 부여 가능

class Car(
    val name: String ,
    val owner : String ,
    price : Int

) {

    // var 앞에 public 이 숨겨져 있기 때문에, getter 는 public 이지만, setter 는 private 이다.
    var price = price
        private set

}