package com.lannstark.lec13

/*
[정리]
- 클래스 안에 클래스가 있는 경우 종류는 두가지.
    - (Java 기준) static 사용 클래스 -> (Kotlin 기준) 클래스 안의 클래스
    - (Java 기준) static 사용 x 클래스 -> (Kotlin 기준) 클래스 안의 inner 클래스
- Kotlin은 기본적으로 바깥 클래스에 대한 연결이 없는 중첩 클래스.
- Kotlin에서 권장되지 않는 바깥 클래스 연결하려면 앞의 inner 라는 키워드를 작성.
- Kotlin inner class 에서 바깥 클래스 참조하려면 this@바깥 클래스 사용해야함.
*/


class KotlinHouse (

    private val address: String,
    private val livingRoom: LivingRoom

) {

    /*
     - static을 쓰지 않는 Kotlin에서는 그냥 class 라고 써주면 된다.
     - Kotlin은 기본적으로 바깥 클래스에 대한 연결이 없는 중첩 클래스가 만들어진다.
    */
//    class LivingRoom (
//        private val area: Double
//    )

    /*
     - Kotlin에서 권장되지 않는 바깥 클래스 연결하려면 앞의 inner 라는 키워드를 작성해준다.
     - 바깥 클래스 참조를 위해 this@바깥클래스 사용 필요
     */
    inner class LivingRoom (
        private val area: Double
    ) {
        val address: String
            get() = this@KotlinHouse.address
    }

}



