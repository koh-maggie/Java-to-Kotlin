package com.lannstark.lec09


/*
[정리]
- Kotlin 에서는 필드를 만들면 getter 와 (필요에 따라) setter 가 자동으로 생김.
    (프로퍼티 = 필드 + getter + setter)
- Kotlin 에서는 주생성자가 필수 (constructor 키워드 생략 가능)
- Kotlin 에서는 constructor 키워드로 부생성자 추가 가능 ( 실행 순서는 역순 )
    (default parameter 나, 정적 팩토리 메소드 추천)
- Kotlin 에서는 실 메모리에 존재하는 것과는 무관하게 custom getter 와 setter 생성 가능. (상세 까보면 함수로 되어있음)
- custom getter , setter 에서는 무한루프를 막기위해 field 를 사용 (backing field)
*/

fun main() {

    ///////////////////////////////////////////////////////////////////////

    // 1. 클래스와 프로퍼티
//    var kotlinPerson = KotlinPerson("고매기" , 100)
//    println(kotlinPerson.age)
//    kotlinPerson.age = 29
//    println(kotlinPerson.age)
//
//    // Kotlin 에서 Java 변수 호출 할때도, .변수명으로 호출 가능
//    var javaPerson = JavaPerson("고매기" , 101)
//    println(javaPerson.age)
//    javaPerson.age = 30
//    println(javaPerson.age)

    ///////////////////////////////////////////////////////////////////////

    // 2. 생성자와 init
    // person 이름만 파라미터로 넘겨도, 호출 가능
//    var kotlinPerson2 = KotlinPerson("고매기")
//    println(kotlinPerson2.name)
//    println(kotlinPerson2.age)

    /*
    본문은 역순으로 실행된다.
    - 결과
        -> 초기화 블록
        -> 첫번째 부생성자
        -> 두번째 부생성자
        -> 홍길동
        -> 1

    */
//    var kotlinPerson3 = KotlinPerson()
//    println(kotlinPerson3.name)
//    println(kotlinPerson3.age)

    ///////////////////////////////////////////////////////////////////////

    // 3. custom getter
    val customPerson = KotlinPerson("고매기", 20)
    println(customPerson.age)
    println(customPerson.isAdult)


}


///////////////////////////////////////////////////////////////////////

/*
- 주 생성자는 class 명 옆에 써줘야 함.
- constructor 명칭은 생략 가능.
- Kotlin 은 생성자에서 프로퍼티(=필드) 를 만들어 줄 수 있음.
 */

///////////////////////////////////////////////////////////////////////
class KotlinPerson (

    val name: String ,
    var age:Int


) {

    ///////////////////////////////////////////////////////////////////////

    // 위의 생성자에서 변수별 타입 추론이 가능하기 때문에, 아래 변수에서는 타입 생략 가능
    // val name : String = name
    // var age : Int = age

    /*
    - Kotlin 에서는 필드만 만들면 getter, setter 를 자동으로 만들어 줌.
    - 프로퍼티 = 필드 + getter + setter
     */
    // val name = name
    // var age = age

    // 생성자에서 프로퍼티를 만들면 {} 요 구간에는 아무것도 없기 때문에 생략 가능

    ///////////////////////////////////////////////////////////////////////

    /*
    2. 생성자와 init
    */
    // init 은 class 가 초기화 될 때, 타는 것.
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다");
        }

        println("초기화 블록")
    }

    /*
    - 부 생성자를 만들어야 할 때는 , 최상단이 아닌 constructor 를 사용해준다.
    - 최종적으로 주생성자를 this 로 호출해줘야 함.
    - body를 가질 수 있음. 
    */
    constructor(name : String) : this(name,1) {
        println("첫번째 부생성자")
    }

    constructor() : this("홍길동") {
        println("두번째 부생성자")
    }


    ///////////////////////////////////////////////////////////////////////

    /*
    3. 커스텀 된 getter, setter
    */

//    fun isAdult() : Boolean {
//        return this.age >= 20
//    }

    // 다른 방법 .. -> KotlinPerson 클래스에 프로퍼티가 있는 것 처럼 보여줌
    // 하나의 속성으로 사용할 경우에 주로 사용.
    // 하나의 프로퍼티는 이미 getter 를 가지고 있으니까, 해당 필드를 하나의 프로퍼티로 호출하면 값이 나옴.
    val isAdult : Boolean
        get() = this.age >= 20


    ///////////////////////////////////////////////////////////////////////

    /*
    4. backing field
    */

    fun getUppercaseName() : String {
        return this.name.uppercase()
    }

    val uppercaseName : String
        get() = this.name.uppercase()

}