package com.lannstark.lec17

/*
[정리]
- 함수는 Java 에서 2급시민이지만, 코틀린에서는 1급시민이다.
    - 함수자체를 변수에 넣을 수 있고, 파라미터로도 전달 가능
-  코틀린에서 함수 타입은 (파라미터 타입) -> 반환타입
- 코틀린에서 람다 만드는 방식
    - fun 다음에 함수 이름이 없음
    - 함수이름이 없이 바로 파라미터를 받을 수 있는 즉, 이름 없는 함수 = 람다 임.

    ```
    val isApple = fun(fruit : Fruit) : Boolean {
        return fruit.name == "사과"
    }
    ```
    - 중괄호 화살표 사용하는 방법 (요게 좀 더 많이 씀.)
    ```
    val isApple2 = {fruit : Fruit -> fruit.name == "사과"}
    ```

- 코틀린에서 람다 직접 호출 방법
    - 소괄호를 쓰는 경우
    ```
    isApple(Fruit("사과",1_000))
    ```

    - invoke 를 써주는 방법
    ```
    isApple.invoke(Fruit("사과",1_000))
    ```
    - 중괄호 가 소괄호 안에 있는 게 어색할 수 있어, 소괄호 밖으로 중괄호를 밖으로 빼면  마지막 파라미터로 셋팅됨.
    ```
    filterFruits(fruits) {fruit -> fruit.name == "사과"}
    ```
    - 익명함수 파라미터가 한개면 it 이라고 해주면 it 이 fruit 그 자체가 됨.
    - 다만, it 을 사용하면 함수를 부르는 쪽 코드만 봐서는 어떤 데이터인지 판단이 어려울 수 있음.
    ```
    filterFruits(fruits) {it.name == "사과"}
    ```

- 람다의 마지막 expression 의 결과는 람다의 반환값이다. return 을 굳이 해주지 않아도 마지막 expression 이 반한이 됨.
- 코틀린에서는 Closure 를 사용하여 non-final 변수도 람다에서 사용 가능.
*/

fun main() {
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1200),
        Fruit("사과", 1200),
        Fruit("사과", 1500),
        Fruit("바나나", 3000),
        Fruit("바나나", 3200),
        Fruit("바나나", 2500),
        Fruit("수박", 10000)
    )

    /*
    1. 람다를 만드는 방법 1
        - fun 다음에 함수 이름이 없음
        - 함수이름이 없이 바로 파라미터를 받을 수 있는 즉, 이름 없는 함수 = 람다 임.
    */
    val isApple = fun(fruit : Fruit) : Boolean {
        return fruit.name == "사과"
    }

    /*
    2. 람다를 만드는 방법 2
        - 중괄호 화살표 사용하는 방법
    */
    val isApple2 = {fruit : Fruit -> fruit.name == "사과"}


    /*
    1. 람다를 직접 호출하는 방법 1
       - 소괄호를 쓰는 경우
   */
    isApple(Fruit("사과",1_000))

    /*
    2. 람다를 직접 호출하는 방법 2
       - invoke 를 써주는 방법
   */
    isApple.invoke(Fruit("사과",1_000))

    filterFruits(fruits,isApple)
    filterFruits(fruits, {fruit : Fruit -> fruit.name == "사과"})
    // 중괄호 가 소괄호 안에 있는 게 어색할 수 있어, 소괄호 밖으로 중괄호를 밖으로 빼면  마지막 파라미터로 셋팅됨.
    filterFruits(fruits) {fruit : Fruit -> fruit.name == "사과"}
    // filterFruits 함수에서 filter : (Fruit) -> Boolean 으로 타입 추론이 가능하기 때문에 타입 생략 가능.
    filterFruits(fruits) {fruit -> fruit.name == "사과"}
    // 익명함수 파라미터가 한개면 it 이라고 해주면 it 이 fruit 그 자체가 됨.
    // 굳이 -> 안해줘도 됨.
    filterFruits(fruits) {it.name == "사과"}

}

private fun filterFruits(
    fruits: List<Fruit> , filter : (Fruit) -> Boolean
) : List<Fruit> {

    val results = mutableListOf<Fruit>()
    for(fruit in fruits) {
        if(filter(fruit)) {
            results.add(fruit)
        }
    }
    return results
}