package com.lannstark.lec10

/*
[정리]
- 상속, 구현을 할 때에 : 을 사용해야 함.
- 상위 클래스 상속을 구현할 때, 생성자를 반드시 호출해줘야함.
- override 를 필수로 붙여야 함.
- 추상 멤버가 아니라면 기본적으로 오버라이드가 불가능.
    (open 을 사용해야함.)
- 상위 클래스의 생성자 또는 초기화 블록에서 open 프로퍼티를 사용하면 버그 발생 가능있음.
- 상위 클래스의 init 블록 실행 : Base Class
    - 상위 클래스의 생성자가 실행되는 동안, 하위 클래스의 number를 호출하는데 이값이 초기화가 안되서 엉뚱한 값이 출력됨. (0)
        ( =하위 클래스에서 override 하고 있는 프로퍼티에 접근하면 안됨.)
    - 하위 클래스의 init 블록 실행 : Derived Class
*/

fun main() {

    /*
    출력 순서 ( 버그가 될 수 있음 )
    - 상위 클래스의 init 블록 실행 : Base Class
    - 상위 클래스의 생성자가 실행되는 동안, 하위 클래스의 number를 호출하는데 이값이 초기화가 안되서 엉뚱한 값이 출력됨. (0)
        ( =하위 클래스에서 override 하고 있는 프로퍼티에 접근하면 안됨.)
    - 하위 클래스의 init 블록 실행 : Derived Class
    */
    Derived(300)

}

open class Base(
    open val number : Int = 100
){
    init {
        println("Base Class")
        println(number)
    }
}


class Derived (

    override val number : Int

) : Base(number){
    init {
        println("Derived Class")
    }
}