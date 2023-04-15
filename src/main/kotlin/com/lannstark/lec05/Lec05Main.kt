package com.lannstark.lec05

import java.util.Objects


/*
[정리]
- if / if-else / if-else if- else 모두 Java 와 문법이 동일
- 단, Kotlin 에서는 Expression 으로 취급하기 때문에 Kotlin에서는 삼항연산자가 없음.
- Java의 switch는 Kotlin 에서 when 으로 대체됨.

*/

fun main() {

    validateScoreIsNotNegative2(99)

    getGrade(98)
}

fun validateScoreIsNotNegative(score : Int) {

    if(score < 0) {
        throw IllegalArgumentException("${score} 는 0보다 작을 수 없습니다.")
    }

}


/*
* Statement : 프로그램의 문장, 하나의 값으로 도출되지 않는다.
* Expression : 하나의 값으로 도출되는 문장
* -> Statement 가 Expression 보다 더 큰 개념
* Java 에서는 if-else 는 Statement 이지만, Kotlin 에서는 Expression
* -> Ex. String test = if(){}else{} 이렇게 대입이 불가.
* -> Kotlin 에선 하나의 expression 으로 처리가 가능하여 3항 연산자 기능은 없음.
* */
fun getPassOrFail(score: Int) :String {
    return if(score >= 50) {
        "P"
    }else{
        "F"
    }
}

fun getGrade(score : Int) : String {
    return if(score >= 90 ){
        return "A"
    }else if (score >= 88) {
        return "B"
    }else if (score >= 70) {
        return "C"
    }else{
        return "D"
    }
}

fun validateScoreIsNotNegative2(score : Int) : String {

    // score 라는 값이 0 ~ 100 사이의 범위에 있지 않으면 if 탐.
    return if(score !in 0..100) {
        return throw IllegalArgumentException("${score} 의 범위는 0~ 100 입니다. ")
    }else{
        return "범위 내임"
    }

}

// 코틀린에서는 switch case default가 사라지고 when 사용 .
/*
when(값) {
    조건부 -> 어떠한 구문
    조건부 -> 어떠한 구문
    ..
    else -> 어떠한 구문
}
*/
fun getGradeWithSwitch(score : Int) : String {

   return when(score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

fun startsWithA (obj : Any) : Boolean {
    return when(obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber (number : Int) {
    when(number){
        1,0,-1 -> println("어디서 많이 본 숫자입니다.")
        else -> println("1,0,-1 이 아닙니다.")
    }
}

// when이 값이 없게 early return 처럼 활용 가능.
fun judgeNumber2(number: Int) {
    when {
        number == 0 -> println("주어진 숫자는 0입니다")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다")
        else -> println("주어지는 숫자는 홀수입니다")
    }
}