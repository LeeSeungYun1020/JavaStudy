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

## 스트림

### 스트림이란?

- 컬렉션과 배열에 데이터를 담고 반복문을 이용하는 코드는 길고 가독성이 떨어지며, 재사용성도 떨어짐
- 각 컬렉션 클래스마다 같은 기능의 메소드가 중복 정의되어 있음(Ex: Arrays.sort(), Collections.sort())
- 스트림은 데이터 소스를 추상화하여 같은 방식으로 다룰 수 있게 하여 코드의 재사용성을 높임

#### 스트림의 특징

- 스트림은 데이터 소스를 변경하지 않음(필요하다면 결과를 컬렉션(또는 배열)에 담아 반환해야)
- 스트림은 일회용(한번 사용하면 닫혀서 재생성 필요)
- 스트림은 작업을 내부 반복으로 처리

#### 스트림의 연산

- 중간 연산: 연산 결과가 스트림인 연산, 스트림에 연속해서 중간 연산 가능
  - map, flatMap, distinct, filter, limit, skip, peek, sorted
- 최종 연산: 연산 결과가 스트림이 아닌 연산, 스트림의 요소를 소모하므로 단 한번만 가능
  - reduce, collect, forEach, count, max, min, find, match, toArray
- 지연된 연산: 최종 연산이 실행되기 전까지 중간 연산은 실행되지 않음
- 병렬 스트림: parallel()을 호출하면 내부적으로 fork&join 프레임워크를 이용하여 연사늘 병렬로 실행

### 스트림 만들기

- 컬렉션: 모든 컬렉션의 조상인 Collection에 정의되어 있으므로 stream 메소드를 호출하여 생성
- 배열: Stream의 of 메소드, Arrays의 stream 메소드의 인자로 배열을 전달하여 생성
- 특정 범위의 정수: IntStream, LongStream의 range, rangeClosed 메소드 사용하여 생성
- 난수: Random의 ints, longs, doubles 이용, 각 IntStream, LongStream, DoubleStream의 ints, longs, doubles 이용하여 생성
- 람다식: Stream의 iterate, generate 이용하여 생성
  - iterate는 시드값을 시작으로 계산을 반복하여 무한 스트림을 생성하고 generate는 이전 계산값을 사용하지 않고 계산
- 파일: Files의 list로 특정 디렉토리의 파일 목록 스트림으로 생성, lines는 파일의 각 줄 별로 String 스트림을 생성
- 빈 스트림: Stream.empty() 스트림 연산 수행 결과가 하나도 없을 때 반환
- 두 스트림 연결: Stream.concat(stream1, stream2)

### 스트림의 중간 연산

- 자르기: 앞 skip(), 뒤 limit()
- 거르기: 조건 filter(), 중복 distinct()
- 정렬: sorted() - Comparator 인터페이스의 comparing, thenComparing(추가 조건) 활용
- 변환: map()
- 조회: peek() - forEach와 달리 스트림 요소를 소모하지 않아 여러 번 호출 가능
- 기본형 스트림으로 변환: mapToInt(), mapToLong(), mapToDouble()
  - sum, average, max, min 지원(최종 연산이므로 스트림이 닫힘 -> summaryStatics 사용)
  - 기본형 스트림을 Stream\<T\>로 변환할 때는 mapToObj(), Stream\<Interger\>로 변환할 때는 boxed() 사용
- 배열 스트림을 일반 스트림으로 변환: flatMap()
  - Ex: stringArrayStream.flatMap(Arrays::stream)

### Optional<T>와 OptionalInt

- Optional<T>는 T 타입의 객체를 감싸는 래퍼 클래스
- Optional에 정의된 메소드로 null 처리
- of, ofNullable, empty로 초기화
- get, orElse, orElseGet, orElseThrow로 값 가져옴
- isPresent, ifPresent로 null이 아닌 경우에만 작업 수행 가능
- Stream 클래스의 findAny, findFirst, max, min, reduce 메소드가 Optional 타입을 반환
- 기본형 스트림에서는 Optional도 기본형을 값으로 하는 OptionalInt, OptionalLong, OptionalDouble 반환

### 스트림의 최종 연산

- 반복: forEach()
- 조건 검사: allMatch(), anyMatch(), noneMatch(), findMatch(), findAny()
- 통계: count(), sum(), average(), max(), min()
- 리듀싱: reduce() - 초기값(선택)과 연산으로 스트림 요소를 하나로 줄임

### collect()

- 스트림의 요소를 수집, 컬렉터로 요소 수집 방법 정의
- Collector: 컬렉터 구현에 사용하는 인터페이스
- Collectors: static 메소드로 미리 작성된 컬렉터를 제공하는 클래스
- 스트림을 컬렉션과 배열로 반환 - toList(), toSet(), toMap(), toCollection(), toArray()
  - .collect(Collectors.toList())
  - .collect(Collectors.toCollection(ArrayList::new))
  - .collect(Collectors.toMap(person -> person.getId(), person -> person)
  - .toArray(Students[]::new)
- 통계 - counting(), summingInt(), averagingInt(), maxBy(), minBy()
- 리듀싱 - reducing()
- 문자열 결합 - joining()
- 그룹화와 분할 - groupingBy(), partitioningBy()
  - 그룹화, 분할 결과는 Map에 담겨 반환
  - partitioningBy는 조건에 따라 true, false를 키로 분할됨
  - groupingBy는 람다식의 반환값을 키로 분할됨
  - 중첩 가능

## Collector 구현하기

- Collector 인터페이스 구현 필요
  - supplier(): 작업 결과 저장할 공간 제공
  - accumulator(): 스트림의 요소 수집(collect)할 방법 제공
  - combiner(): 두 저장공간을 합칠 방법 제공(병렬 스트림)
  - finisher(): 결과를 최종적으로 변환할 방법 제공
  - characteristics(): 컬렉터가 수행하는 작업의 속성에 대한 정보 제공
    - CONCURRENT: 병렬로 처리할 수 있는 작업
    - UNORDERED: 스트림의 요소의 순서가 유지될 필요가 없는 작업
    - IDENTITY_FINISH: finisher()가 항등 함수인 작업

## 스트림의 변환

- 스트림 -> 기본형 스트림
  - Stream\<T\> -> IntStream: mapToInt(mapper)
- 기본형 스트림 -> 스트림
  - IntStream -> Stream\<Integer\>: boxed()
  - IntStream -> Stream\<T\>: mapToObj()
- 기본형 스트림 -> 기본형 스트림
  - IntStream -> LongStream: asLongStream()
- 스트림 -> 부분 스트림
  - Stream\<T\> -> Stream\<T\>(IntStream -> IntStream): skip(), limit()
- 두 개의 스트림 -> 스트림
  - Stream\<T\>, Stream\<T\> -> Stream\<T\>: concat()
  - IntStream, IntStream -> IntStream: concat()
- 스트림의 스트림 -> 스트림
  - Stream\<Stream\<T\>\> -> Stream\<T\>: flatMap()
  - Stream\<IntStream\> -> IntStream: flatMapToInt()
- 스트림 -> 병렬 스트림
  - Stream\<T\> -> Stream\<T\>(IntStream -> IntStream): parallel(), 반대: sequential()
- 스트림 -> 컬렉션
  - Stream\<T\> -> Collection\<T\>: collect(Collectors.toCollection())
  - Stream\<T\> -> List\<T\>: collect(Collectors.toList())
  - Stream\<T\> -> Set\<T\>: collect(Collectors.toSet())
- 컬렉션 -> 스트림
  - Collection\<T\>, List\<T\>, Set\<T\> -> Stream\<T\>: stream()
- 스트림 -> Map
  - Stream\<T\> -> Map<K, V>: collect(Collections.toMap())
- 스트림 -> 배열
  - Stream\<T\> -> Object[]: toArray()
  - Stream\<T\> -> T[]: toArray(T::new)
  - IntStream -> int[]: toArray()