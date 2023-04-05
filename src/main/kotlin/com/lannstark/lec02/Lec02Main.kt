package com.lannstark.lec02

/*
[정리]
- null 이 들어갈 수 있는 타입은 완전히 다르게 간주
  ( 한번 null 검사하면 not null 임을 컴파일러가 알수 있음.)

- Safe Call : null 이 아닐 경우만 호출됨. (?.)
- Elvis : null 일 경우에 호출됨. (?:)
- null 아님 단언 : null이 절대 아닐 때 사용할 수 있는 선언
- 코틀린은 null 어노테이션을 사용하지 않으면 알 수 없는 플랫폼 타입이라, 사용 시 유의 필요.
  (java 코드로 null 가능성 확인 , 코틀린으로 wrapping )
*/
fun main() {
    // safeCall()
    // elvis()

    // true
    // print( startsWith("ABC") );
    // false
    // print( startsWith("BC") );
    // Runtime 시, Exception 발생
    // print( startsWith(null) );

    /*
    만약, platformTypeStartsWithA 메소드 내 파라미터에 null 미허용일시,
    Person 이라는 객체 내, name의 @Nullable 처리가 되어있다면, 오류 발생
    @NotNull 일 경우는 사용 가능.

    만약, @Nullable , @NotNull 이 없고,
    null 이 아닌 값 입력 시,  코틀린 입장에서는 일단 되게 동작 시킴.
    null 값 입력 시, 빨간줄은 안뜨나, 컴파일 단이 아닌 런타임에서 NPE 발생 .

    -> Null 처리를 꼼꼼하게, 라이브러리 같은 경우는 까서 null 허용 유무 판단 필요.
     */
    // var person = Person("공부하는 고매기")
    var person = Person(null)
    platformTypeStartsWithA(person.name)
}

/* **************************************************** */

// java code : public boolean startsWithA1(String str) {...}
// boolean type 은 null이 들어갈 수 없으므로 반환 타입만 지정하면 됨.
fun startsWithA1(str:String?) : Boolean {
    if (str == null) {
        throw IllegalArgumentException("null이 들어왔습니다");
    }
    return str.startsWith("A")
}

// java code : public Boolean startsWithA2(String str) {...}
// Boolean type 은 null이 들어갈 수 있으므로 반환 타입에 ? 필수
fun startWithA2(str: String?) : Boolean?  {
    if (str == null) {
        return null
    }
    return str.startsWith("A")
}

fun startsWithA3(str: String?) : Boolean {
    if (str == null) {
        return false
    }
    return str.startsWith("A")
}

// 만약 파라미터가 null 이 들어올 수도 있을 경우에 바로 메소드콜 불가.
// 코틀린에서 자동으로 막아줌.

/* **************************************************** */
// Safe Call : null 이 아니면 실행하고, null 이면 실행하지 않는다.
fun safeCall() {
    // val str:String? = "ABC"
    // 오류 반환 : calls are allowed on a nullable receiver of type String?
    // print(str.length)

    val str:String? = null
    // 3
    // 만약 str 이 null 이었다면 ? null 을 그대로 반환한다.
    print(str?.length)
}

// elvis
fun elvis() {
    val str:String? = null

    // 이 자체가 0이 됨.
    print(str?.length ?: 0)
}

/* **************************************************** */
// 좀 더 코틀린스럽게 바꿔보자 ~!
// 대박 .. !

fun kotlinStartsWithA1(str:String?) : Boolean {

   /*
   str 이 null 이 아닐 경우에는 startsWith 가 안전하게 호출되고,
   null이면 elvis 연산자 뒤에 지정한 Exception 으로 반환.
    */
   return str?.startsWith("A")
       ?: throw IllegalArgumentException("null이 들어왔습니다");
}

fun kotlinStartWithA2(str: String?) : Boolean?  {

    /*
    str 이 null 이 아닐 경우에는 startsWith 가 안전하게 호출되고,
    null이면 반환값 자체가 null 허용이기 때문에, null로 반환
    */
    return str?.startsWith("A")

}

fun kotlinStartsWithA3(str: String?) : Boolean {

    /*
    str 이 null 이 아닐 경우에는 startsWith 가 안전하게 호출되고,
    null이면 elvis 연산자 뒤에 지정한 false 값으로 반환.
    */
    return str?.startsWith("A") ?: false

}

/* **************************************************** */
// null 아님 단언 : nullable type 이지만, 아무리 생각해도 null 이 될 수 없는 경우
// Ex. 처음 DB에 값이 null로 셋팅 되었다가, 모종의 값 변경 이후, null로 돌아가지 않는 경우
// str 에 null이 들어오면 Runtime 시, NullPointException을 발생시키키 때문에 ,반드시 null이 아닐 경우만 사용해야함.

fun startsWith(str: String?) : Boolean {
    return str!!.startsWith("A")
}

/* **************************************************** */
// 플랫폼 타입

fun platformTypeStartsWithA(str: String) : Boolean {
    return str.startsWith("A")
}