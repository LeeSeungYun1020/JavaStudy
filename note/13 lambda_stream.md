# 람다와 스트림

## 람다식

### 람다식이란?

- 함수형 언어의 장점 접목
- 람다식: 메소드를 하나의 식으로 표현, 익명 함수라고도 함
- 메소드의 매개변수로 전달하거나 결과로 반환 가능

### 람다식 작성

- (매개변수 선언) -> { 실행할 문장; }
- 반환값이 있는 메소드는 식으로 변환 가능
  - (int a, int b) -> a > b ? a : b
- 매개변수 타입은 추론 가능할 경우 생략 가능
  - (a, b) -> a > b ? a : b
- 선언된 매개변수가 하나뿐이고 타입을 생략 가능한 경우 괄호 생략 가능
  - a -> a * a
- 중괄호 안의 문장이 하나일 때는 중괄호 생략 가능, 문장이 return문인 경우 생략 불가
  - (String name) -> System.out.println("Hi, " + name)

### 함수형 인터페이스

- 람다식은 익명 클래스의 객체와 동등
- 람다식을 다루기 위한 인터페이스를 함수형 인터페이스라 함
- 람다식과 인터페이스의 메소드가 일대일로 대응되기 위해 하나의 추상 메소드만 정의, static, default 메소드에는 제약 없음
- @FunctionalInterface를 붙이면 컴파일러가 함수형 인터페이스 올바르게 정의했는지 확인
- 함수형 인터페이스 타입의 매개변수와 반환타입으로 람다식 전달 가능
- 람다식은 익명 객체이므로 타입의 이름을 알 수 없음 -> 원래는 함수형 인터페이스로 형변환 필요하나 생략 가능
- 람다식 내에서 참조하는 지역변수는 상수로 간주되어 값 변경이 불가

### java.util.function 패키지

- 자주 쓰이는 형식의 메소드를 함수형 인터페이스로 미리 정의해둔 패키지
- 기본형 함수형 인터페이스
  - java.lang.Runnable: void run()
  - Supplier\<T\>: T get()
  - Consumer\<T\>: void accept(T t)
  - Function\<T, R\>: R apply(T t)
  - Predicate\<T\>: boolean test(T t)
- 매개변수 2개인 함수형 인터페이스
  - BiConsumer\<T, U\>: void accept(T t, U u)
  - BiPredicate\<T, U\>: boolean test(T t, U u)
  - BiFunction\<T, U, R\>: R apply(T t, U u)
- 매개변수와 반환타입이 일치하는 함수형 인터페이스
  - UnaryOperator\<T\>: T apply(T t)
  - BinaryOperator\<T\>: T apply(T t, T t)
- 컬렉션 프레임워크의 메소드에서 함수형 인터페이스 이용(forEach, removeIf, replaceAll, compute 등)
- 기본형을 사용하는 함수형 인터페이스
  - AtoBFunction: B applyAsB(A a)
  - ToAFunction\<T\>: A applyAsA(T value)
  - AFunction\<R\>: R apply(A value)
  - ObjAConsumer\<T\>: void accept(T t, A value)
  - AUnaryOperator: A applyAsA(A operand)

### Function 합성과 Predicate 결합

- Function 인터페이스의 andThen(after), compose(before)로 합성 가능
- Function 인터페이스의 identity()는 항등 함수로 map 변환 작업에서 변환없이 그대로 처리할 때 주로 사용
- Predicate 인터페이스의 and(), or(), negate()로 논리식 결합 가능
- Predicate 인터페이스의 isEqual()은 두 대상을 비교(equals)하는 Predicate 생성

### 메소드 참조

- 하나의 메소드만 호출하는 람다식은 클래스명::메소드명 또는 참조변수::메소드명으로 변환 가능
  - Function\<String, Integer\> f = Integer::parseInt;
  - BiFunction\<String, String, Boolean\> f = String::equals;
- 생성자를 호출하는 람다식도 메소드 참조로 변환 가능
  - Supplier\<MyClass\> s = MyClass::new;
  - Function\<Integer, int[]\> f = int[]::new;

