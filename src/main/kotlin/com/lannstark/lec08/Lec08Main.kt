package com.lannstark.lec08

/*
[정리]
- 함수의 문버의 Java 다름
    접근지시어 fun 함수이름(파라미터): 반환타입 {
    }
- body가 하나의 값으로 간주될 경우, block 을 없앨수도 있고, block 이 없다면 반환 타입을 없앨 수 있음.
- 함수 파라미터에 기본값을 설정해줄 수 있음.
- 함수를 호출할 때 특정 파라미터를 지정하여 넣어줄 수 있음.
- 가변인자에는 vararg 키워드를 사용하며, 가변인자 함수를 배열과 호출할 때는 * 을 붙여주어야 함.
*/


fun main() {

    // 2. default parameter 호출
    repeat2("hi koh maggie" )


    // 3. named argument
    repeat2("hi koh maggie" , useNewLine = false)
    // builder 를 직접 만들지 않고 builder 의 장점을 가질 수 있음.
    // 동일한 타입을 갖는 파라미터의 값이 잘 못 들어 갔을 경우 확인 가능.
    printNameAndGender("F","고매기")


    //4. 가변인자 (= 같은 타입의 여러 파라미터 받기 )
    printAll("A","B","C")

    val array = arrayOf("A","B","C")
    // * 은 spread 해준다라는 연산자
    printAll(*array)
}


/*
1. 함수 선언 문법
- 접근지시어 public 생략 가능
- fun : 함수를 뜻하는 표현
- 함수가 하나의 결과 값이라면 block 대신 = 사용 가능
- 파라미터 값이 모두 Int 형이고, block 타입이아니라, = 이기 때문에 타입 추론이 가능하여 반환 값 생략 가능
    (만약, block 을 사용하는 경우에 반환타입이 unit이 아니라면 명시적으로 작성 필요 )
- if 문을 하나의 문장으로 올려 작성 가능 ( 한줄로작성 가능 )
- if 문의 중괄호도 간단하기 때문에 생략 가능
*/
fun max( a : Int , b : Int) = if(a > b) a else b



/*
2. default parameter
- 오버로딩 된 여러개의 Java 로된 함수를 Kotlin 에서는 default parameter 로 하나로 표현가능 함.
- 파라미터가 없는 경우에는 기본 default 값 사용 / 물론 파라미터 지정하면 지정한대로 처리 가능
- Kotlin 에서는 Java 처럼 오버라이딩된 여러 소스코드가 불필요 함.
*/

fun repeat(str:String , num:Int , useNewLine : Boolean) {
    for(i in 1..num){
        if(useNewLine) {
            println(str)
        }else{
            print(str)
        }
    }
}

fun repeat2(str:String , num:Int =3 , useNewLine :Boolean = true) {
    for(i in 1..num){
        if(useNewLine) {
            println(str)
        }else{
            print(str)
        }
    }
}


/*
3. named Argument (= 이름있는 argument(parameter))
- Kotlin 에서 Java 함수ㅡㄹ 가져다 사용할 때는 named argument를 사용할 수 없다.
    ( Java 가 JVM 에 의해 바이트 코드로 변환되엇을 때, parameter 이름을 보존하고 있지 않아 사용 불가. )
*/
fun printNameAndGender(name: String , gender : String) {
    println(name)
    println(gender)
}


/*
4. 가변인자 (= 같은 타입의 여러 파라미터 받기 )
- Java에서는 ... 해줬던 가변인자를 Kotlin 에서는 앞에 vararg 를 붙여줘야 함.
- 호출하는 쪽에서는 배열을 바로 넣는 대신 spread 연산자 (*) 을 붙여 줘야함.
- 그냥 바로 문자열 , (콤마)로 구분하는 경우에는 바로 사용 가능.
*/
fun printAll (vararg strings : String) {
    for( str in strings) {
        println(str)
    }
}
