package com.lannstark.lec14


/*
[정리]
- Kotlin 의 Data Class 사용하면 equals , hashCode, toString 을 자동으로 생성해줌.
- When Expression 은 Enum Class 와 같이 쓸 때 시너지 발생함.
- Enum Class 보다 유연하지만, 하위 클래스를 제한하는 Sealed Class 역시, when 과 주로 사용됨.

*/

/*
- When Expression 은 Enum 과 Sealed 클래스와 같이 쓸 때 시너지 발생함.
- 컴파이러가 country의 모든 타입을 알고 있어 다른 타입에 대한 로직(else)를 작성하지 않아도됨.
- Kotlin 의 경우, Enum 이 변경되었을 때 알아서 when 에서 경고를 날려줌.
*/
fun handleCountry(country: KotlinCountry) {
    when (country) {
        KotlinCountry.KOREA -> TODO()
        KotlinCountry.AMERICA -> TODO()
    }
}

enum class KotlinCountry (
    val code: String
) {
    KOREA("KO"),
    AMERICA("US")
}