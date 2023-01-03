# 지네릭스, 열거형, 애너테이션
## 지네릭스
### 지네릭스란?
- 다양한 타입의 객체를 다루는 메소드나 컬렉션 클래스에 컴파일 시의 타입 체크를 해주는 기능
- 객체의 타입 안정성을 높이고 형변환의 번거로움을 줄임
  - 의도하지 않은 타입의 객체 저장 막고 잘못된 형변환으로 인한 오류 방지
- 지네릭 타입은 클래스와 메소드에 선언할 수 있음

### 지네릭 클래스의 선언
- class 클래스명<타입 변수 목록> 형태로 선언 (Ex: \<T\>, \<E\>, \<K, V\>)
- 타입 변수(각 기호)는 임의의 참조형 타입을 의미, 필요한 곳에 타입 대신 사용하면 됨
- 이전 코드와의 호환을 위해 지네릭 타입 지정 없이도 객체 생성 가능

#### 지네릭스 용어
```java
class Box<T> {}
```
- Box\<T\>: 지네릭 클래스, T Box라고 읽음
- T: 타입 변수, 타입 매개 변수, T는 타입 문자
- Box: 원시 타입
- Box\<String\> b = new Box\<String\>();: 지네릭 타입 호출, String은 대입된 타입(매개변수화된 타입)

#### 지네릭스의 제한
- static 멤버에 타입 변수 사용 불가
  - static 멤버는 대입된 타입과 관계없이 동일해야
- 지네릭 배열 타입의 참조변수 선언은 가능하지만 배열 생성은 불가
  - 컴파일 시점에 타입을 알 수 없으므로 new 연산자 사용 불가
  - Reflection API의 newInstance()로 동적으로 생성하거나 Object 배열을 생성하고 복사하여 형변환
- instanceof 연산자 사용 불가
  - 컴파일 시점에 어떤 타입이 될지 알 수 없기 때문

### 지네릭 클래스 객체 생성과 사용
- 참조 변수와 생성자에 대입된 타입이 일치해야
  - Box\<Apple\> appleBox = new Box\<Apple\>();
  - 상속 관계에 있는 타입이라도 사용 불가 (Box\<Fruit\> box = new Box\<Apple\>() 불가)
- 지네릭 클래스의 타입이 상속 관계에 있고 대입된 타입이 일치하는 경우는 가능(다형성)
  - Box\<Apple\> appleBox = new FruitBox\<Apple\>();
- 추정이 가능한 경우 타입 생략 가능
  - Box\<Apple\> appleBox = new Box\<\>();

### 제한된 지네릭 클래스
- 지네릭 타입에 extends를 사용하여 지정할 수 있는 타입의 종류 제한
- 인터페이스의 경우에도 extends 사용하며 여러 개인 경우 &로 연결
- Ex: class FruitBox<T extends Fruit & Eatable> {}

### 와일드 카드
- 지네릭 클래스를 다른 클래스에서 이용할 떄 특정 타입을 지정해야 하는 문제 발생
  - Ex1: static Juice makeJuice(FruitBox\<Fruit\> box)
  - 위와 같은 경우 FruitBox\<Apple\>은 매개변수가 될 수 없음
  - makeJuice(FruitBox\<Apple\>)을 별도로 정의할 경우 컴파일 에러 발생(지네릭 타입을 제거하기 때문)
  - Ex2: static \<T\> void sort(List\<T\> list, Comparator\<T\> c)
  - 위와 같은 경우 Apple을 정렬하기 위한 Comparator<Apple>과 Orange를 정렬하기 위한 Comparator<Orange>가 별도로 필요
  - Fruit를 정렬할 수 있는 공통 Comparator 사용이 불가능하여 하위 클래스마다 Comparator 정의 필요
- 와일드 카드를 이용하여 상한과 하한 제한 가능
  - \<? extends T\>: 와일드 카드의 상한 제한, T와 그 자손만 가능
  - \<? super T\>: 와일드 카드의 하한 제한, T와 그 조상만 가능
  - \<?\>: 제한 없음, 모든 타입이 가능, <? extends Object>와 동일
  - 와일드 카드를 이용하여 Ex1은 FruitBox\<? extends Fruit\>, Ex2는 Comparator<? super T>로 표현하여 문제 해결

### 지네릭 메소드
- 메소드 선언부에 지네릭 타입이 선언된 메소드
- static 멤버에서 타입 매개변수를 사용할 수 없지만 메소드에 지네릭 타입 선언은 가능
- 같은 타입 문자를 사용할 경우 지역 변수 선언처럼 가려짐
- 메소드 호출시 타입 변수에 타입 대입이 필요하며 추정 가능할 경우 생략 가능
- Ex: static void print(\ArrayList\<? extends Fruit\> list) 
-> static \<T extends Fruit\> void print(ArrayList\<T\> list)

### 지네릭 타입의 형변환
- 지네릭 타입(Box\<T\>)과 원시 타입(Box)간 변환 가능(경고 발생)
- 대입된 타입이 다른 지네릭 타입(Box\<A\>, Box\<B\>)간 변환 불가(Object 타입이라도 불가)
  - Box\<A\> -> Box<?> -> Box\<B\>로 변환은 가능
- 지네릭 타입(Box\<T\>)과 와일드 카드가 사용된 지네릭 타입(Box\<? extends Object\>)간 변환 가능
- 와일드 카드가 사용된 지네릭 타입(Box\<? extends Object\>)간 변환 가능(경고 발생)

### 지네릭 타입의 제거

- 지네릭 도입 이전 코드(1.5 미만)와의 호환성을 위해 원시 타입을 사용한 코드 작성 허용
- 컴파일러는 지네릭 타입으로 소스 파일을 체크하고 형변환을 넣어준 뒤 지네릭 타입을 제거

1. 지네릭 타입의 경계 제거
  - \<T\>이면 T는 Object로, \<T extends Fruit\>라면 T는 Fruit로 치환
  - 클래스 옆의 선언(\<\> 부분) 제거
2. 지네릭 타입 제거 후 타입이 일치하지 않으면 형변환 추가
  - 와일드 카드가 포함된 경우 적절한 타입으로 형변환(\<? extends Fruit\> -> Fruit)

## 열거형

### 열거형이란?

- 서로 관련된 상수를 묶어서 선언
- 타입에 안전한 열거형
- 열거형을 사용하지 않고 상수를 사용하면 상수의 값이 바뀔 경우 참조하는 모든 소스 재컴파일 필요

### 열거형 정의와 사용

- enum 열거형명 { 상수1, 상수2 }
- static 변수를 참조하는 것처럼 열거형명.상수명으로 사용
- ==으로 비교 가능하고 switch문에도 사용 가능

### 열거형의 조상 - java.lang.Enum

- values(): 열거형의 모든 상수를 배열에 담아 반환
- ordinal(): 상수가 정의된 순서를 정수로 반환
- name(): 상수의 이름을 문자열로 반환
- valueOf(name): name과 일치하는 상수 반환

### 열거형에 멤버 추가하기

- 인스턴스 변수와 생성자를 추가하여 값을 저장하도록 구현 가능
- 추상 메소드를 추가하여 각 열거형 상수가 추상 메소드를 구현하도록 설계 가능

### 열거형의 이해

- 열거형 상수 하나하나는 사실 해당 객체
- 각 static 상수 값은 객체의 주소이며 바뀌지 않으므로 ==으로 비교가 가능했던 것
- 추상 메소드를 선언하면 구현해야하는 것도 같은 이유

```java
enum Transportation {
  BUS(100) {
    @Override
    int fare(int distance) {
      return distance * basicFare;
    }
  }, TRAIN(150) {
    @Override
    int fare(int distance) {
      return distance * basicFare;
    }
  };

  abstract int fare(int distance);

  protected final int basicFare;

  Transportation(int basicFare) {
    this.basicFare = basicFare;
  }

  public int getBasicFare() {
    return basicFare;
  }
}
```

```java
abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T> {
  static int id = 0;
  private final int ordinal;
  private String name = "";

  public int ordinal() {
    return ordinal;
  }

  public String name() {
    return name;
  }

  public String toString() {
    return name;
  }

  MyEnum(String name) {
    this.name = name;
    ordinal = id++;
  }

  @Override
  public int compareTo(T o) {
    return ordinal - o.ordinal();
  }
}

abstract class MyTransportaion extends MyEnum {
  static final MyTransportaion BUS = new MyTransportaion("BUS", 100) {
    @Override
    int fare(int distance) {
      return distance * BASIC_FARE;
    }
  };
  static final MyTransportaion TRAIN = new MyTransportaion("TRAIN", 150) {
    @Override
    int fare(int distance) {
      return distance * BASIC_FARE;
    }
  };

  abstract int fare(int distance);

  protected final int BASIC_FARE;

  private MyTransportaion(String name, int basicFare) {
    super(name);
    this.BASIC_FARE = basicFare;
  }
}
```

## 애너테이션

### 애너테이션이란?

- 자바 개발자는 소스코드에 대한 문서를 별도로 만들기보다 하나의 파일로 관리하는 것이 낫다고 생각
  - 소스코드의 주석에 소스코드 정보를 저장하고 HTML 문서를 생성하는 javadoc을 사용
  - 미리 정의된 태그(@태그)로 주석 안에 정보를 저장하고 javadoc이 정보를 읽어 문서를 작성
- 이 기능을 응용하여 소스코드 안에 다른 프로그램을 위한 정보를 약속된 형식으로 포함시킨 것이 애너테이션
- 주석처럼 프로그래밍 언어에 영향 미치지 않으면서 다른 프로그램에 유용한 정보 제공

### 표준 애너테이션

- @Override: 컴파일러에게 오버라이딩 메소드라는 것을 알림
  - 잘못된 메소드명 적는 등 오버라이딩 실수 방지
- @Deprecated: 사용을 권장하지 않는 메소드에 붙임
  - 기능 개선 등으로 더이상 사용되지 않는 필드, 메소드
- @FunctionalInterface: 함수형 인터페이스라는 것 알림
  - 추상 메소드가 하나인 함수형 인터페이스 작성시 실수 방지
- @SuppressWarnings: 컴파일러의 특정 경고 메시지 나타나지 않도록 함
  - 발생한 경고를 표시하지 않도록 하여 다른 경고 쉽게 찾음
  - @SuppressWarnings({"deprecation", "unchecked", "varargs"})
  - 해당 대상에만 애너테이션 붙여서 경고 억제 범위를 최소화하는 것이 좋음
- @SafeVarargs: 지네릭스 타입의 가변인자에 사용
  - 메소드에 선언된 가변인자 타입이 non-reifiable타입(컴파일 후 제거되는 타입)일 경우 unchecked 경고 발생
  - static, final 메소드(오버라이딩 되지 않을 메소드)에만 사용 가능
  - SuppressWarnings("unchecked")를 사용할 경우 메소드 호출되는 부분에도 애너테이션 붙여야 함
  - unchecked 경고는 억제할 수 있지만 varargs 경고(Xlint옵션에서 표시)는 억제할 수 없으므로 SuppressWarnings("varargs")도 함께 사용
- 아래 메타 애너테이션

### 메타 애너테이션

- 애너테이션에 붙이는 애너테이션, 애너테이션의 적용 대상이나 유지 기간 지정 등에 사용
- @Target
  - 애너테이션이 적용 가능한 대상을 지정
- @Retention
  - 애너테이션 유지 기간을 지정
  - SOURCE, CLASS(default), RUNTIME
  - 지역 변수에 붙은 애너테이션은 컴파일러만 인식 가능, RUNTIME인 애너테이션을 지역변수에 붙여도 실행시에 인식되지 않음
- @Documented
  - 애너테이션 정보가 javadoc으로 작성한 문서에 포함
  - 자바 제공 기본 애너테이션 중에서는 Override, SuppressWarning 제외하고 모두 붙어있음
- @Inherited
  - 해당 애너테이션을 붙인 클래스를 상속하면 상속 받은 하위클래스에서도 애너테이션 붙은 것과 같이 인식
- @Repeatable
  - 하나의 대상에 여러 번 같은 애너테이션을 붙일 수 있도록 함
- @Native
  - native 메소드에서 참조되는 상수 필드 앞에 붙임
  - native 메소드는 JVM이 설치된 OS의 메소드를 의미하며 자바에서는 메소드 선언부만 정의하여 일반 메소드처럼 호출

### 애너테이션 타입 정의하기

- @interface 애너테이션명 { 타입 요소명(); }
- 애너테이션의 요소
  - 애너테이션에 선언된 메소드
  - 반환값이 있고 매개변수가 없는 추상 메소드 형태를 가지며 애너테이션 적용시 값 지정이 필요
  - default로 기본값 지정 가능
  - 요소가 하나뿐이고 이름이 value인 경우 애너테이션 적용시 요소 이름 생략하고 값만 적어도 됨
  - 요소 타입이 배열인 경우 {}로 묶어 여러 값 지정 가능
- java.lang.annotation.Annotation
  - 모든 애너테이션의 조상은 Annotation 인터페이스
  - 애너테이션은 상속 허용 X
  - equals, hashCode, toString, annotationType 메소드 호출 가능
  - 클래스 객체는 애너테이션 정보도 가지고 있으며 getAnnotation(애너테이션명.class) 또는 getAnnotations()로 받아올 수 있음
- 마커 애너테이션
  - 요소가 하나도 정의되지 않은 애너테이션
  - Override, Test, Serializable, Cloneable
- 애터네이션 요소의 규칙
  - 요소 타입은 기본형, String, enum, 애너테이션, Class만 허용
  - 매개변수 선언 불가 ()
  - 예외 선언 불가
  - 요소를 타입 매개변수로 정의 불가