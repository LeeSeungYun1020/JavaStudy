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
