package com.lannstark.lec03

import com.lannstark.lec03.Person
import java.util.Objects

/*
[정리]
- 코틀린의 변수는 초기값을 보고 변수 추론, 기본 타입들 간 변환은 암시적x 명시적으로 선언함.
- 코틀린에서 is , !is , as , as? 이용해 타입을 학인하고 캐스팅한다.
- 코틀린의 Any, Unit , Nothing
- 문자열 가공시 , ${변수} , """""" 사용하면 깔끔 코딩 가능
- 특정 문자열 가져올 때 인덱스를 사용하여 출력
*/

fun main (){

    /* **************************************************** */
    // 1. 기본타입

    // java 에서는 암시적으로 큰 byte 형으로 바꿔주지만, 코틀린에서는 명시적으로 작성해야 함.
    // to반환타입 사용해야함.
    var number1 = 3
    var number2 : Long = number1.toLong()


    // 변수가 nullable 이라면 적절한 처리 필요
    var number3 : Int? = 3
    var number4 : Long = number3?.toLong() ?: 0L

    /* **************************************************** */
    // 2. 일반 타입 - 2 ( null 이 허용된다면? )
    printAgeIfPersonNull(null) // NPE 발생
    printAgeIfPersonNull(Person("",100)) // 정상 출력

    /* **************************************************** */
    // 4. String interpolation
    StringInterpolation()

    // String indexing
    StringIndexing()
}

/* **************************************************** */
// 2. 일반 타입 - 1
fun printAgeIfPerson(obj : Any) {

    /*
    java code : if (obj instanceof Person) { ... }
    instanceof는 코틀린에서 is 로 사용
    instanceof의 반대의 의미로 사용하고 싶다면 !is 로 사용
     */
    if (obj is Person ) {

        /*
        - java code :  Person person = (Person) obj;
        - 코틀린에서는 형변환을 () 가아닌 as 로 사용
        - as Person 생략 가능 . ( = 스마트 캐스트) 자바 컴파일러가 if 내에서 체크해주면
           그대로 사용해도 된다고 간주가능
        */
        var person = obj as Person
        println(person.age)
        println(obj.age)
    }
}

/* **************************************************** */
// 2. 일반 타입 - 2 ( null 이 허용된다면? )
fun printAgeIfPersonNull(obj : Any?) {

    /*
    obj 가 null 이 아니라면 Person 으로 casting
    obj 가 null 이면 obj as? Person safe Call 처럼 자체가 null 이된다.
     */
    var person = obj as? Person
    println(person?.age) // null
}


/* **************************************************** */
// 3. 코틀린의 특이 타입 3가지
/*
- Any
    자바의 Object
    모든 Primitive Type 의 최상의 타입도 Any
    null 표현 하고싶으면 Any?
    equals/hashCode/toString 존재

- Unit
    자바의 void 와 동일한 역할
    자바의 void 와 다르게 Unit은 그 자체로 타입 인자로 사용 가능

- Noting
    함수가 정상적으로 끝나지 않았음을 표시
    무조건 예외 반환 함수 / 무한 루프 함수 .. 의 사용
*/

/* **************************************************** */
// 4. String interpolation / String indexing
// ${변수} 로 사용하면 된다.
fun StringInterpolation() {
    var person = Person("고매기", 20);
    var message = "내 별명은 ${person.name}이고 , 나이는 ${person.age} 살 이다."
    println(message)

    // 바로 $변수 써도됨.
    val name = "매기고"
    println("나는 $name 이다.")

}

fun StringIndexing() {

   val name = "고매기"

   var str =
   """
      안녕하세요.
      ${name}은 오늘도 
      공부를 합니다. 
   """.trimIndent()

    println(str)
    // 코틀린에서는 특정 문자열 가져올 때, 리스트 인덱스 꺼내듯이 처리하면 됨.
    println(str[1])
}














