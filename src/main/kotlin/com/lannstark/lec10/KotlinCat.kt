package com.lannstark.lec10

/*
type 한칸 띄지 않고 : 처리
상속은 한칸 띄고 : 처리
 */
class KotlinCat (
    species: String

    // 상위 클래스의 생성자를 바로 호출해줘야 함.
) : KotlinAnimal(species,4) {

    // Kotlin 은 지시어를 사용
    override fun move() {
        println("고양이가 사뿐 사뿐 걸어가~")
    }
}