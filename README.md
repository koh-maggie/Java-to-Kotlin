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