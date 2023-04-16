package com.lannstark.lec07

/*
[정리]
- try ~ catch ~ finally 는 Java, Kotlin 모두 문법적으로 동일
    ( Kotlin 에서는 try ~ catch 가 하나의 Expression으로 바로 return 가능
- Kotlin 에서 모든 예외는 Unchecked Exception 임.
- Kotlin 에서는 try ~ with ~ resources 구문이 없음. 대신 코틀린의 언어적 특징을 활용해 close 호출해줌.
*/


/*
1.try ~ catch ~ finally
- 문법은 Java 와 Kotlin 과 동일
- 하나의 Expression 이기 때문에 return 으로 바로 반환 가능
 */
fun parseIntOrThrow(str : String) : Int {
    try {
        return str.toInt()
    }catch (e : NumberFormatException){
        throw IllegalArgumentException("주어진 ${str}은 숫자가 아닙니다.")
    }
}

fun parseIntOrThrow2(str : String) : Int? {
    return try {
        str.toInt()
    }catch (e : NumberFormatException) {
        null
    }
}

/*
2.Checked Exception / UnChecked Exception
- Kotlin 에서는 Checked Exception 과 Unchecked Exception을 구분하지 않음.
모두 Unchecked Exception 임.
 */
// KotlinFilePrinter.kt 파일참고


/*
3. try ~ with ~ resources
- use 라는 걸 사용함
*/
// KotlinFilePrinter.kt 파일참고


















