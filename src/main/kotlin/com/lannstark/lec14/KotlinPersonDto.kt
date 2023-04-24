package com.lannstark.lec14


fun main() {
    val person1 = KotlinPersonDto("고매기",100)
    val person2 = KotlinPersonDto("고매기",200)

    println( person1 == person2)
}

/*
1. Data Class 
- data 키워드를 붙여주면 equals, hashCode, toString을 자동으로 생성됨.
*/
data class KotlinPersonDto (
    val name: String,
    val age: Int

) {


}