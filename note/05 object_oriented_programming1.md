# 객체지향 프로그래밍
## 객체지향언어
### 객체지향언어의 역사와 정의
- 실제 세계를 가상 세계(컴퓨터)로 옮기고자 함
- 절차지향언어 중심에서 객체지향언어로
- 속성과 기능을 변수와 함수로 정의

#### 주요 특징
- 높은 코드 재사용성
- 코드 관리 용이성
- 신뢰성 높은 프로그래밍 가능

## 클래스와 객체
### 클래스와 객체의 정의와 용도
- 클래스 정의: 객체를 정의한 것
- 클래스 용도: 객체 생성에 사용
- 객체 정의: 실제로 존재하는 것, 사물 또는 개념
- 객체 용도: 기능과 속성에 따라 다름
- 유형 객체: 사물 - 책상, 의자, 자동차
- 무형 객체: 개념(논리) - 수식, 에러

### 객체와 인스턴스
- 인스턴스화: 클래스 -> 객체
- 인스턴스: 클래스로부터 만들어진 객체

### 객체의 구성요소
- 객체는 속성과 기능으로 구성
- 속성과 기능을 객체의 멤버라고 함
- 속성 = 멤버 변수, 특성, 필드, 상태
- 기능 = 메소드, 함수, 행위

### 인스턴스의 생성과 사용
- 클래스명 변수명 = new 클래스명()
- 인스턴스는 참조 변수를 통해서 다룰 수 있으며 참조 변수의 타입은 인스턴스의 타입과 일치해야 함
- 인스턴스의 속성은 서로 다른 값을 유지할 수 있음

### 객체 배열
- 선언시 각 요소는 null로 자동 초기화
- 객체를 각각 생성하여 객체 배열의 각 요소에 저장해야(참조하도록 해야)

### 클래스의 다른 정의
- 클래스: 데이터와 함수의 결합
  - 데이터 저장 형태의 발전: 변수 -> 배열 -> 구조체 -> 클래스
  - 변수와 함수를 한 클래스에 정의, 함께 다룸
  - String 클래스는 문자열과 문자열을 다루는데 필요한 함수를 함께 묶어 제공
- 클래스: 사용자 정의 타입
  - 기본형 외에 프로그래머가 관련된 변수 묶어 하나의 타입으로 새로 추가

## 변수와 메소드
### 선언 위치에 따른 변수 종류
- 선언 위치에 따라 클래스 변수, 인스턴스 변수, 지역 변수로 나뉨
- 클래스 변수: 멤버 변수 중 static
  - 모든 인스턴스가 공통적인 값 유지
  - 인스턴스 생성 없이 클래스명.클래스변수로 바로 사용
- 인스턴스 변수: 멤버 변수 중 non-static
  - 클래스 영역에 선언
  - 인스턴스는 독립적인 값을 유지
- 지역 변수: 멤버 변수 제외한 변수(클래스 영역이 아닌 메소드, 생성자, 초기화 블록 내부 등에서 선언)
  - 메소드 및 해당 블록 내에서만 사용 가능

### 메소드
- 특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것
- 블랙 박스: 입력과 출력만 알면 되고 내부적인 과정을 알 필요는 없다

#### 메소드를 사용하는 이유
- 높은 재사용성
- 중복 코드 제거
- 프로그램 구조화

### 메소드 선언과 구현
- 메소드는 크게 선언부와 구현부로 나뉨
- 선언부
  - 반환 타입, 메소드명, 매개변수 선언
  - 변경시 호출하는 코드를 모두 변경해야 하므로 향후 변경되지 않도록 신중하게 작성 필요
  - 반환 타입이 없는 경우 void 사용
- 구현부
  - 메소드 호출시 수행할 문장
  - return문을 통해 값 반환, 반환 타입과 일치하거나 자동 형변환이 가능한 것을 반환해야

### 메소드 호출
- 메소드 정의만 하고 호출하지 않으면 아무 일도 일어나지 않음
- 메소드 호출시 괄호 안에 지정해준 값을 인자라 함
- 인자는 메소드가 호출되면서 매개변수에 대입 -> 개수와 순서 일치해야 하고 타입은 일치하거나 자동 형변환이 가능해야
- 메소드의 결과는 사용하지 않아도 무관
- 같은 클래스내 메소드끼리는 참조 변수 없이 호출 가능
- static 메소드는 인스턴스 메소드 호출 불가

### return문
- 모든 메소드에는 하나 이상의 return문 필요
- 반환값이 없는 경우(void) 생략 가능
- 매개변수 유효성 검사를 통해 값을 보정하거나 즉시 반환하는 것이 필요

### JVM의 메모리 구조
- JVM은 시스템에서 프로그램 실행을 위한 메모리 할당받고 용도에 따라 여러 영역으로 나누어 관리
- 메소드 영역
  - 사용되는 클래스의 클래스 파일을 분석하여 클래스에 대한 정보 저장, 클래스 변수 생성
- 힙
  - 인스턴스가 생성되는 공간, 인스턴스 변수 생성
- 호출 스택
  - 메소드 작업에 필요한 메모리 공간 제공
  - 메소드 호출시 메모리가 할당되며 매개변수, 지역변수, 연산 중간 결과 저장, 메소드 작업 끝나면 반환

### 기본형 매개변수와 참조형 매개변수
- 메소드 호출시 값을 매개변수에 복사해서 넘김
- 기본형 매개변수는 단순히 저장된 값만 얻음(읽기만 가능)
- 참조형 매개변수는 값이 저장된 곳의 주소를 앎(읽기/쓰기 모두 가능)

### 참조형 반환타입
- 반환하는 값의 타입이 참조형 -> 메소드가 객체의 주소를 반환

### 재귀호출
- 메소드 내에서 메소드 자신을 다시 호출
- 조건문을 통해 종료 조건 기술 필요 -> StackOverflowError 발생 방지
- 반복문으로 대치 가능, 반복문보다 재귀호출 수행 시간이 오래 걸림
- 재귀호출로 간결한, 단순한 구조로 작성 가능한 경우가 있으며 재귀호출 비용보다 간결함이 주는 이득이 큰 경우 재귀 호출 사용 권장

### 클래스 메소드와 인스턴스 메소드
- 인스턴스 메소드는 인스턴스 변수와 관련된 작업 수행(메소드 수행에 인스턴스 변수가 필요한 메소드)
- 클래스 메소드는 인스턴스와 관계 없는(인스턴스 변수 및 매소드를 사용하지 않는) 메소드

- 클래스 설계시, 멤버 변수 중 모든 인스턴스에 공통으로 사용하는 것에 static 붙임
- 클래스 변수는 인스턴스 생성 없이 사용
- 클래스 메소드는 인스턴스 변수, 메소드 사용 불가
- 메소드에서 인스턴스 변수를 사용하지 않는다면 static 붙이는 것을 고려

### 클래스 멤버와 인스턴스 멤버 간의 참조와 호출
- 같은 클래스 멤버 간에는 서로 참조 및 호출이 가능
- 클래스 멤버는 인스턴스 멤버를 참조, 호출 불가
- 인스턴스 멤버가 존재하는 시점에 클래스 멤버는 항상 존재하지만 클래스 멤버가 존재하는 시점에 인스턴스 멤버가 존재하는지 보장 불가하기 때문

## 오버로딩
### 오버로딩의 정의와 조건
- 메소드 오버로딩: 하나의 클래스 내에 같은 이름의 메소드 여러 개 정의
- 메소드 이름은 같고 매개변수 개수 및 타입은 달라야 함
- 반환 타입은 오버로딩 구현과 무관

### 오버로딩의 장점
- 같은 기능을 하는 메소드를 하나의 이름으로 묶을 수 있음
- 메소드 이름을 절약

### 가변인자와 오버로딩
- 가변인자: 매개변수 개수를 동적으로 지정
  - 타입... 변수명 형식으로 선언
  - 가변인자를 매개변수 중 가장 마지막에 선언해야
  - 인자의 개수는 가변적이며 아예 없거나 배열도 가능
  - 내부적으로 배열 이용

## 생성자
### 생성자의 정의
- 인스턴스 생성시 호출되는 인스턴스 초기화 메소드
- 생성자 이름은 클래스 이름과 같아야 하며, 반환 값이 없음
- 생성자도 오버로딩 가능
- 연산자 new가 인스턴스를 생성, 생성자가 인스턴스를 생성하는 것은 아님

### 기본 생성자
- 클래스에 생성자를 정의하지 않은 경우 컴파일러가 기본 제공
- 다른 생성자를 정의한 경우 컴파일러가 기본 생성자를 추가하지 않음

### 매개변수가 있는 생성자
- 매개변수를 이용하여 인스턴스 초기화 작업에 이용 가능

### 생성자에서 다른 생성자 호출
- 생성자 이름으로 클래스명() 대신 this()를 사용
- 반드시 첫 줄에서만 다른 생성자 호출 가능
- this는 참조 변수로 인스턴스 자신을 가리킴
- 매개변수 이름이 인스턴스 변수와 같은 경우 this를 통해 구분

### 생성자를 이용한 인스턴스 복사
- 해당 클래스의 참조 변수를 매개 변수로 선언하여 생성자 구현
- 모든 인스턴스 변수가 같은 값 가지도록 구현

## 변수의 초기화
### 변수의 초기화
- 변수 선언 이후 처음으로 값을 저장하는 것
- 멤버 변수는 자료형에 맞는 기본값으로 초기화가 이루어짐
- 지역변수는 사용하기 전 반드시 초기화 필요
- 멤버 변수의 초기화 방법에는 명시적 초기화, 생성자, 초기화 블록이 있음

### 명시적 초기화
- 변수 선언과 동시에 초기화

### 초기화 블록
- 변수의 복잡한 초기화에 사용
- 클래스 초기화 블록과 인스턴스 초기화 블록 두 종류로 구성
- 클래스 초기화 블록은 static { 수행 문장; }, 인스턴스 초기화 블록은 { 수행 문장; }
- 생성자보다 초기화 블록이 먼저 수행
- 인스턴스 초기화 블록에 모든 생성자에서 공통으로 수행되는 코드를 넣어 중복 제거 가능

### 멤버 변수의 초기화 시기와 순서
- 클래스 변수는 클래스가 처음 로드될 때 딱 한번 초기화
- 인스턴스 변수는 인스턴스 생성될 때마다 각 인스턴스 별로 초기화
- 클래스 변수 초기화 순서: 기본값 -> 명시적 초기화 -> 클래스 초기화 블록
- 인스턴스 변수 초기화 순서: 기본값 -> 명시적 초기화 -> 인스턴스 초기화 블록 -> 생성

- 단 this()로 다른 생성자를 호출할 경우 해당 구문 수행 뒤 인스턴스 초기화 블록으로 이동
```java
class Product {
  static int count = 0;
  int serialNo;
  String name;

  {
    // 인스턴스 초기화 블록
    ++count;
    serialNo = count;
  }

  Product() { // count는 인스턴스 초기화 블록 실행 이전 값이 사용된다.
    this("product" + count); // 하나 작은 값이 사용되는 문제 발생
  }

  Product(String name) {
    this.name = name;
  }
}
```