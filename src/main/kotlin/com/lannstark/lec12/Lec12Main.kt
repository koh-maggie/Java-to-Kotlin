package com.lannstark.lec12

/*
[정리]
- static 함수와 변수
    - Kotlin에서는 static 이 없고, companion object (동행 객체) 를 사용
    - static : 클래스가 인스턴스화 될 때 새로운 값이 복제되는게 아니라 정적으로 인스턴스끼리의 값을 공유
    - companion object : 클래스와 동행하는 유일한 오브젝트
    - val : 런타임 시에 변수가 할당됨.
    - const : 컴파일 시에 변수가 할당됨.
    - Java 에서 Kotlin companion object를 사용하려면 @JvmStatic 을 붙여줘야 함.
        - Java 에서 static을 쓰는 것처럼 바로 호출하여 사용 가능.
    - companion object 도 하나의 객체로 간주되기 때문에 이름을 붙일 수 있고, 다른타입을 상속 받을 수 있음.

- 싱글톤
    - object 키워드 사용

- 익명클래스
    - object : 타입 사용
    - 특정 인터페이스나 클래스를 상속받은 구현체를 일회성으로 사용할 때 쓰는 클래스
    - Java 에서는 new 타입이름() Kotlin 에서는 object : 타입이름{}

*/

fun main() {


    // 싱글톤
    println(Singleton.a) // 0
    Singleton.a += 10
    println(Singleton.a) // 10


    moveSomething(object : KotlinMovable {
            override fun move() {
                println("무브무브")
            }

            override fun fly() {
                println("날다날다")
            }
        }
    )
}

class KotlinPerson private constructor(
    var name: String ,
    var age: Int
) {

    /*
    - static 함수와 변수
    - Kotlin에서는 static 이 없고, companion object (동행 객체) 를 사용
    - static : 클래스가 인스턴스화 될 때 새로운 값이 복제되는게 아니라,
               정적으로 인스턴스끼리의 값을 공유
    - companion object : 클래스와 동행하는 유일한 오브젝트
    - val : 런타임 시에 변수가 할당됨.
    - const : 컴파일 시에 변수가 할당됨.
    - Java 에서 Kotlin companion object를 사용하려면 @JvmStatic 을 붙여줘야 함.
      Java 에서 static을 쓰는 것처럼 바로 호출하여 사용 가능.

    */
    companion object Factory : Log {
        private const val MIN_AGE: Int = 1

        @JvmStatic
        fun newBaby(name: String) : KotlinPerson {
            return KotlinPerson(name , MIN_AGE)
        }

        override fun log(){
            println("나는 Person 클래스의 동행 객체 Factory 예요 ")
        }
    }

}

/*
- 싱글톤
*/
object Singleton {
    var a : Int = 0
}

/*
- 익명클래스: 특정 인터페이스나 클래스를 상속받은 구현체를 일회성으로 사용할 때 쓰는 클래스
- Java 에서는 new 타입이름() Kotlin 에서는 object : 타입이름{}
*/

private fun moveSomething(movable: KotlinMovable) {
    movable.move()
    movable.fly()
}
