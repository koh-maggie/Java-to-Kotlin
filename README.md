# 1. 코틀린에서 변수를 다루는 방법
- var : 가변
- val : 불변 (read-only)
- 코틀린은 자동으로 변수 타입을 컴파일러가 추론 해줌.
- 변수 타입 지정하고 싶을 경우 : 타입 지정하면 됨.
- 모든 변수는 우선 val 로 만들고 , 필요 시 var 로 변경해야 클린 코드 가능.
- 코틀린은 null이 들어갈 수 있다면 `타입?` 를 사용해야 함.
- 코틀린에서 객체 인스턴스 시, new 를 붙이지 않아야 함.
- 코틀린 -> 자바 코드 디컴파일 하는 방법
    - Tools > Kotlin > Show Kotlin Byte Code

# 2. 코틀린에서 null을 다루는 방법
- null 이 들어갈 수 있는 타입은 완전히 다르게 간주.
    - 한번 null 검사하면 not null 임을 컴파일러가 알수 있음.
- Safe Call : null 이 아닐 경우만 호출됨. (?.)
- Elvis : null 일 경우에 호출됨. (?:)
- null 아님 단언 : null이 절대 아닐 때 사용할 수 있는 선언.
- 코틀린은 null 어노테이션을 사용하지 않으면 알 수 없는 플랫폼 타입이라, 사용 시 유의 필요.
    - java 코드로 null 가능성 확인 , 코틀린으로 wrapping.

# 3. 코틀린에서 Type을 다루는 방법
- 코틀린의 변수는 초기값을 보고 변수 추론.
- 기본 타입들 간 변환은 암시적x 명시적으로 선언함.
- 코틀린에서 is , !is , as , as? 이용해 타입을 학인하고 캐스팅.
- 코틀린의 Any(=Object), Unit(=void) , Nothing.
- 문자열 가공시 , ${변수} , """""" 사용하면 깔끔 코딩 가능.
- 특정 문자열 가져올 때 인덱스를 사용하여 출력.

# 4. 코틀린에서 연산자를 다루는 방법
- 단항, 산술, 산술대입 연산자 Java 와 동일.
- 비교 연산자 사용법도 Java 와 동일.
    - 객체끼리도 자동 호출되는 compareTo를 이용해 비교 연산자 사용 가능.
- in, !in / a..b / a[i] / a[i] = b 와 같이 코틀린에서 생긴 것도 있음.
- 객체끼리의 연산자를 코틀린에서는 직접 정의 가능.

# 5. 코틀린에서 제어문을 다루는 방법
- if / if-else / if-else if- else 모두 Java 와 문법이 동일.
- 단, Kotlin 에서는 Expression 으로 취급하기 때문에 Kotlin에서는 삼항연산자가 없음.
- Java의 switch는 Kotlin 에서 when 으로 대체됨.
- when의 값이 없는 early return 처럼 활용 가능.
- Statement : 프로그램의 문장, 하나의 값으로 도출되지 않음.
- Expression : 하나의 값으로 도출되는 문장.
- Statement 가 Expression 보다 더 큰 개념.

# 6. 코틀린에서 반복문을 다루는 방법
- for-each : Java 는 : Kotlin 은 in 을 사용.
- 전통적인 for문 : Kotlin 에서 전통적인 for문은 등차수열을 이용.
    - Progression (등차수열) : 시작값, 끝값 ,공차  이 세값이 필요함.
    - Range
        - .. 은 IntRange는 IntProgression 을 상속받고  IntProgression의 step 은 1로 지정되어 있음.
- while / do-while은 Java 와 동일.

# 7. 코틀린에서 예외를 다루는 방법
- try ~ catch ~ finally 는 Java, Kotlin 모두 문법적으로 동일.
    - Kotlin 에서는 try ~ catch 가 하나의 Expression으로 바로 return 가능.
- Kotlin 에서 모든 예외는 Unchecked Exception 임.
- Kotlin 에서는 try ~ with ~ resources 구문이 없음. 대신 코틀린의 언어적 특징을 활용해 close 호출해줌.

# 8. 코틀린에서 함수를 다루는 방법
- 함수의 문버의 Java 다름
```
접근지시어 fun 함수이름(파라미터): 반환타입 {

}
```
- body가 하나의 값으로 간주될 경우, block 을 없앨수도 있고, block 이 없다면 반환 타입을 없앨 수 있음.
- 함수 파라미터에 기본값을 설정해줄 수 있음.
- 함수를 호출할 때 특정 파라미터를 지정하여 넣어줄 수 있음.
- 가변인자에는 vararg 키워드를 사용하며, 가변인자 함수를 배열과 호출할 때는 * 을 붙여주어야 함.

# 9. 코틀린에서 클래스를 다루는 방법
- Kotlin 에서는 필드를 만들면 getter 와 (필요에 따라) setter 가 자동으로 생김.
    - 프로퍼티 = 필드 + getter + setter
- Kotlin 에서는 주생성자가 필수 (constructor 키워드 생략 가능)
- Kotlin 에서는 constructor 키워드로 부생성자 추가 가능
    - 실행 순서는 역순
    - default parameter, 정적 팩토리 메소드 추천
- Kotlin 에서는 실 메모리에 존재하는 것과는 무관하게 custom getter 와 setter 생성 가능.
    - 상세 까보면 함수로 되어있음.
- custom getter , setter 에서는 무한루프를 막기위해 field 를 사용 (backing field)

# 10. 코틀린에서 상속을 다루는 방법
- 상속, 구현을 할 때에 : 을 사용해야 함.
- 상위 클래스 상속을 구현할 때, 생성자를 반드시 호출해줘야함.
- override 를 필수로 붙여야 함.
  - 추상 멤버가 아니라면 기본적으로 오버라이드가 불가능.
    - open 을 사용해야함.
- 상위 클래스의 생성자 또는 초기화 블록에서 open 프로퍼티를 사용하면 버그 발생 가능있음.
- 상위 클래스의 init 블록 실행 : Base Class
    - 상위 클래스의 생성자가 실행되는 동안, 하위 클래스의 number를 호출하는데 이값이 초기화가 안되서 엉뚱한 값이 출력됨. (0)
      - = 하위 클래스에서 override 하고 있는 프로퍼티에 접근하면 안됨.
    - 하위 클래스의 init 블록 실행 : Derived Class

# 11. 코틀린에서 접근 제어를 다루는 방법 
- Java
  - public : 모든 곳에서 접근 가능
  - protected  : 같은 패키지 , 하위 클래스에서만 접근 가능
  - default : 같은 패키지에서만 접근 가능
  - private : 선언된 클래스 내에서만 접근 가능

- Kotlin ( 패키지는 패키지일뿐으로 봄. namespace 관리용으로 봄. )
  - public : 모든 곳에서 접근 가능
  - protected : 선언된 클래스 , 하위클래스에서만 접근 가능
  - internal : 같은 모듈에서만 접근 가능
  - private : 선언된 클래스 내에서만 접근 가능

- 생성자에 접근 지시어 붙일경우 , constructor 명시적으로 붙여야함. (기본 public)
- 유틸성함수는 최상단에 써주는 것이 편함.
- 프로퍼티의 custom setter 의 접근 지시어를 붙일 수 있음.
- Java 에서 Kotlin 코드를 사용할 때, internal 과 protected 는 주의 필요.
  - internal 이라도, Java 에서는 같은 패키지에서 사용 가능

# 12. 코틀린에서 object 키워드를 다루는 방법
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

# 13. 코틀린에서 중첩 클래스를 다루는 방법
- 클래스 안에 클래스가 있는 경우 종류는 두가지.
    - (Java 기준) static 사용 클래스 -> (Kotlin 기준) 클래스 안의 클래스
    - (Java 기준) static 사용 x 클래스 -> (Kotlin 기준) 클래스 안의 inner 클래스
- Kotlin은 기본적으로 바깥 클래스에 대한 연결이 없는 중첩 클래스.
- Kotlin에서 권장되지 않는 바깥 클래스 연결하려면 앞의 inner 라는 키워드를 작성.
- Kotlin inner class 에서 바깥 클래스 참조하려면 this@바깥 클래스 사용해야함.

# 14. 코틀린에서 다양한 클래스를 다루는 방법
- Kotlin 의 Data Class 사용하면 equals , hashCode, toString 을 자동으로 생성해줌.
- When Expression 은 Enum Class 와 같이 쓸 때 시너지 발생함.
- Enum Class 보다 유연하지만, 하위 클래스를 제한하는 Sealed Class 역시, when 과 주로 사용됨.

# 15. 코틀린에서 배열과 컬렉션을 다루는 방법
- 배열의 사용법이 다름
- 코틀린에서는 컬렉션을 만들때도 불변/가변을 지정해야함.
- List, Set , Map 에 대한 사용법이 변경 및 확장됨.
- 자바와 코틀린 코드를 섞어 컬렉션을 사용할 때에는 주의해야 함.
    - 자바에서 코틀린 컬렉션을 가져갈 때는 불변 컬렉션을 수정 가능
    - non-nullable 컬렉션에 null을 넣을 수 있음.
    - 코틀린 에서 자바 컬렉션을 가져갈 때는 플랫폼 타입을 주의 해야함.

# 16. 코틀린에서 다양한 함수를 다루는 방법
- 자바가 코드가 있는 상황에서, 코트린 코드로 추가 기능을 개발하기 위해, 확장함수와 확장프로퍼티가 등장함.
```
fun 확장하려는클래스.함수이름(파라미터): 리턴타입 {
    //this (수신객체) 를 이용해 실제 클래스 안이 값에 접근 가능
}
```
- 확장함수
    - 원본 클래스의 private, protected 멤버 접근이 안됨.
    - 멤버함수, 확장함수 중 멤버함수에 우선권이 있음.
    - 확장함수는 현재 타입을 기준으로 호출됨.
    - 자바에서는 static 함수를 쓰는 것 처럼 코틀린의 확장함수를 쓸 수 있음.

- infix 함수
    - 함수 호출 방식을 바꿔주는 방식
    - A.함수이름(B) 가 아니라 A 함수이름 B

- inline 함수
    - 함수를 복사-붙여넣기 하는 함수

- 지역함수
    - 코틀린에서는 함수 안에 함수를 선언할 수 있고, 지역함수라고 함.

# 17. 코틀린에서 람다를 다루는 방법 
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

# 18. 코틀린에서 컬레션을 함수로 다루는 방법
- 필터와 맵
    - .filter
    - filter 에서 index 가 필요할 때, .filterIndexed 
    - .map 기능을 사용해서 특정 속성 값을 가져올 수 있다. 
    - .mapIndexed 
    - Mapping 의 결과가 null 이 아닌 것만 가져오고 싶다면 ?! 
        -  .mapNotNull 이라는 걸 쓸 수도 있음.

- 다양한 컬렉션 처리 기능 
    - all : 조건을 모두 만족하면 true , 그렇지 않으면 false
    - none : 조건을 모두 불만족하면 true , 그렇지 않으면 false 
    - any : 조건을 하나라도 만족하면 true , 그렇지 않으면 false
    - count : 갯수를 센다. List 에서 size 기능과 동일하닥 보면됨.
    - sortedBy : 기본적으로 오름차순, 정렬 함.
    - sortedByDescending : 기본적으로 내림차순 , 정렬 함. 
    - distinctBy : 변형된 값을 기준으로 중복 제거
    - first : 첫번째 값을 가져옴. (무조건 null 이 아니어야 함. )
        - 첫번째 값이 null 이면 Exception 발생. 
    - firstOrNull : 첫번째 값 또는 null을 가져옴. 
    - last : 마지막 값을 가져옴. (무조건 null 이 아니어야 함. )
    - lastOrNull : 마지막 값 또는 null을 가져옴.
  
- List 를 Map 으로 
    - group by : { } 안의 기준 잡은 걸로 그룹핑이 됨.
    - associateBy : id 를 통해서 , 즉 중복되지 않은 키를 가지고 map 을 만들때 사용 (단일객체)
    - {} 안에 써주는게 convention 임.
    - 필터링 같이 앞선 기능하고 같이 사용할 수 있음. 

- 중첩된 컬렉션 처리
    - flatMap : List 가 단일 list 로 바뀜. , 단일 List 로 바뀔 때, 조건에 람다 걸어서 사용 가능 
    - flatten() : 중첩되어 있는 컬렉션이 중첩해제되서 모두 평탄화 되는 List<?>로 바뀜. 