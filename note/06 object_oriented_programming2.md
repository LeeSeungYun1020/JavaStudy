# 객체지향 프로그래밍2
## 상속
### 상속의 정의와 장점
- 상속: 기존 클래스 재사용하여 새로운 클래스 작성하는 것
- 코드 재사용성 높이고 중복 제거 -> 프로그램 생산성, 유지보수성 향상
- class Child extends Parent{ }와 같이 구현
- 상위(부모, 기반) 클래스와 하위(자식, 파생) 클래스
- 상속계층도(class hierarchy): 클래스 간의 상속 관계를 그림으로 표현
- 하위 클래스는 상위 클래스의 모든 멤버 상속받음
- 생성자와 초기화 블록은 상속되지 않음
- 클래스 간의 상속 관계를 통해 공통부는 상위 클래스에서 관리하고 특정부만 하위 클래스에서 관리

### 클래스간의 관계 - 포함관계
- 한 클래스의 멤버 변수로 다른 클래스 타입의 참조 변수를 선언
- 단위 클래스로 나누어 작성하여 재사용, 간결하고 손쉽게 작성
```java
class Point{
    int x, y;
}

class Circle{
    Point center;
    int radius;
}
```

### 클래스간의 관계 결정
- is a와 has a를 대입
- is a인 경우 상속관계, has a인 경우 포함 관계 선택
- 오버라이딩: 상위 클래스에 정의된 메소드와 같은 메소드를 하위 클래스에 정의
- toString은 모든 클래스의 조상인 Object 클래스에 정의 -> 오버라이딩하여 출력, 문자열 결합시 사용되도록 할 수 있음

### 단일 상속
- 자바에서는 다중 상속 허용 X
- 다중 상속
  - 장: 복합적인 기능의 클래스 쉽게 작성
  - 단: 클래스간의 관계가 매우 복잡해짐, 상속받은 멤버간 이름 중복 문제

### Object 클래스
- 모든 클래스의 조상
- 다른 클래스에서 상속받지 않아도 자동적으로 Object 클래스로부터 상속
- toString(), equals(obj)등 11개의 메소드 정의

## 오버라이딩
### 오버라이딩의 정의
- 상위 클래스에서 상속 받은 메소드 내용 변경

### 오버라이딩의 조건
- 메소드 선언부는 상위 클래스와 동일
- 접근 제어자는 좁은 범위로 변경 가능
- 상위 클래스의 메소드보다 많은 수의 예외 선언 불가

### 오버로딩과 오버라이딩
- 오버로딩: 같은 이름의 메소드 여러 개 정의(새로 만듬)
- 오버라이딩: 상속받은 메소드의 내용 변경

### super
- 하위 클래스에서 상위 클래스로부터 상속받은 멤버 참조할 때 사용되는 참조 변수
- 상속받은 멤버와 자신의 멤버의 이름이 같을 경우 super로 구분
- this와 마찬가지로 static 메소드에서는 사용 불가

### super()
- 상위 클래스의 생성자 호출에 사용
- 하위 클래스에서 상위 클래스 멤버 사용을 위해 상위 클래스 초기화가 필요한 것
- 클래스 생성자는 첫 줄에 자신의 다른 생성자 또는 상위 생성자 호출 필요 -> 없다면 컴파일러가 자동으로 super() 추가
- 상위 클래스의 멤버 변수는 상위 클래스의 생성자를 통해 초기화 되도록 해야

## package와 import
### 패키지
- 클래스, 인터페이스의 묶음
- 하나의 소스파일에는 한 번의 패키지 선언만을 허용
- 모든 클래스는 반드시 하나의 패키지에 속해야
- 점을 구분자로 계층 구조 구성
- 패키지는 물리적으로 클래스 파일을 포함하는 하나의 디렉토리

### 패키지 선언
- package 패키지명;으로 선언
- 패키지 선언문은 주석 및 공백을 제외하고 최상단에 위치
- 패키지명은 대소문자 모두 허용하나 일반적으로 소문자 사용
- 패키지를 선언하지 않을 경우 기본적으로 제공하는 이름없는 패캐지에 속하게 됨

### import문
- 다른 패키지의 클래스 사용 위해 패키지명이 포함된 클래스 이름 사용해야
- import문을 이용하여 클래스의 패키지를 미리 명시해주면 패키지명 생략 가능
- 컴파일러는 import문을 이용하여 클래스의 패키지 파악하여 클래스 이름 앞에 패키지명 추가

### import문 선언
- 패키지문과 클래스 선언 사이에 선언
- import 패키지명.클래스명으로 선언
- 같은 패키지에서 여러 개의 클래스가 사용될 경우 import 패키지명.*
- 같은 패키지 내의 클래스는 import문 지정 불필요
- 묵시적으로 import java.lang.*이 선언되어 있어 System, String 같은 클래스 바로 사용 가능했던 것

### static import문
- static 멤버 호출할 때, 클래스 이름 생략 가능
```java
import static java.lang.Math.random;

class Test{
  public static void main(String[] args) {
    System.out.println(random());
  }
}
```

## 제어자
### 제어자의 정의
- 클래스, 변수, 메소드의 선언부에 사용되어 부가적인 의미를 부여하는 것
- 접근 제어자로 public, protected, default, private
- 그 외에 static, final, abstract, native, transient, synchronized, volatile, strictfp

### static
- 클래스의, 공통적인
- 멤버 변수, 메소드, 초기화 블록에 사용
- 인스턴스 생성 없이 클래스 단위 사용

### final
- 마지막의, 변경될 수 없는
- 클래스, 메소드, 멤버 변수 및 지역 변수에 사용
- 변수 -> 상수, 메소드 -> 오버라이딩 금지, 클래스 -> 상속 금지
- final 멤버 인스턴스 변수의 경우 생성자에서 초기화 가능

### abstract
- 추상의, 미완성의
- 클래스, 메소드에 사용
- 클래스 -> 추상 클래스(추상 메소드를 포함하는 클래스), 메소드 -> 추상 메소드(선언부만 있는 메소드)

### 접근 제어자
- 클래스, 멤버 변수, 메소드, 생성자에 사용
- 해당 멤버 또는 클래스를 외부에서 접근할 수 없도록 제한
- private: 같은 클래스 내
- default: 같은 패키지 내
- protected: 같은 패키지, 다른 패키지의 하위 클래스
- public: 전체
- 캡슐화 - 데이터 보호, 내부 로직 감추기

#### 생성자의 접근 제어자
- 생성자에 접근 제어자 사용하여 인스턴스 생성 제한 가능
- 싱글톤 패턴 구현시, 별도의 public 메소드를 통해 인스턴스에 접근 가능하게 구현
- 생성자가 private인 경우 다른 클래스의 조상이 될 수 없으므로 final을 추가하여 상속할 수 없도록 하는 것이 바람직

### 제어자의 조합
- 메소드에 static과 abstract를 함께 사용 불가
- 클래스에 abstract와 final 동시 사용 불가
- abstract 메소드의 접근 제어자가 private 불가
- 메소드에 private, final 같이 사용할 필요 없음

## 다형성
### 다형성의 정의
- 여러 형태를 가질 수 있는 능력
- 자바에서는 한 타입의 참조 변수로 여러 타입의 객체를 참조할 수 있도록 함
  - 상위 클래스 타입의 참조 변수로 하위 클래스의 인스턴스 참조 가능
  - 참조 변수의 타입에 따라 실제 인스턴스에서 참조할 수 있는 멤버 제한

### 참조 변수의 형변환
- 업캐스팅: 하위 타입 -> 상위 타입, 형변환 생략 가능
- 다운캐스팅: 상위 타입 -> 하위 타입, 형변환 생략 불가
- 형변환은 참조변수의 타입을 변환하는 것으로 인스턴스에 아무런 영향 X
- 참조변수의 형변환은 참조하고 있는 인스턴스에서 사용할 수 있는 멤버 범위를 조절
- 다운캐스팅시에는 인스턴스 타입 확인 필요

### instanceof 연산자
- 참조변수가 검사한 타입으로 형변환 가능한지 확인

### 참조변수와 인스턴스의 연결
- 참조 타입과 관계없이 실제 인스턴스 메소드 호출
- 멤버 변수의 경우 참조 타입에 따라 달라짐 -> 인스턴스 변수에 직접 접근하지 않도록 최소화 필요

### 매개변수의 다형성
- 메소드의 매개변수에도 다형성을 이용 가능
- 일례로 PrintStream 클래스의 print(obj)는 하나의 메소드로 모든 타입의 인스턴스 처리 가능

### 여러 종류의 객체를 배열로 다루기
- 공통의 조상을 가진 서로 다른 종류의 객체를 묶어서 다룰 수 있음
- Vector를 이용하여 동적 배열 관리 가능

## 추상클래스
### 추상클래스의 정의
- 미완성 클래스, 추상 메소드를 포함할 수 있음
- 인스턴스 생성 불가

### 추상메소드
- 선언부만 작성한 메소드
- 메소드의 내용이 상속 받는 클래스마다 다르므로 하위 클래스에서 적절히 구현하도록 함
- abstract 리턴타입 메소드명();으로 선언
- 추상클래스 상속시 추상메소드를 모두 구현 or 하위 클래스도 추상클래스로 선언해야

### 추상클래스 작성
- 추상화: 클래스간 공통점을 찾아 공통의 조상을 만드는 작업
- 구체화: 상속을 통해 클래스를 구현, 확장하는 작업
- 추상 클래스를 통해 추상 메소드를 반드시 구현하도록 강제하는 효과
- 추상 클래스도 참조 타입으로 사용 가능

## 인터페이스
### 인터페이스의 정의
- 추상 메소드와 상수만을 멤버로 가지는 일종의 추상 클래스, 기본 설계도
- 다른 클래스 작성 돕는 목적

### 인터페이스 작성
- 클래스 작성과 유사하며 키워드로 interface 사용
- 접근제어자 public, default 사용 가능
- 모든 멤버 변수는 public static final이며 생략 가능
- static 메소드와 default 메소드 제외(1.8부터)한 메소드는 public abstract이며 생략 가능

### 인터페이스 상속
- 인터페이스는 인터페이스로부터만 상속 가능
- 다중 상속 가능

### 인터페이스 구현
- 인터페이스로 인스턴스 생성 불가
- 다른 class에서 implements 키워드로 구현 가능
- 인터페이스의 일부만 구현할 경우 추상 클래스로 선언해야

### 인터페이스를 이용한 다중상속
- 멤버 변수: static 상수만 정의 가능하므로 이름을 붙여 구분 가능
- 메소드와 선언부가 일치하는 경우 상위 클래스의 메소드 상속
- 두 클래스에서 상속받아야하는 경우
  - 한쪽을 클래스 내부에 포함시킴
  - 한쪽의 필요한 부분만 뽑아내 인터페이스로 만든 다음 구현

### 인터페이스를 이용한 다형성
- 인터페이스 타입의 참조 변수로 구현한 클래스의 인스턴스 참조 가능
- 인터페이스 타입으로 형변환 가능
- 반환 타입이 인터페이스라는 것은 메소드가 해당 인터페이스를 구현한 클래스의 인스턴스 반환한다는 것을 의미

### 인터페이스의 장점
- 개발시간 단축
  -  인터페이스를 통해 양쪽에서 동시 개발 가능
- 표준화 가능
  - 기본 틀을 먼저 작성, 일관되고 정형화된 프로그램 개발 가능
- 클래스간 관계 형성 가능
  - 상속 관계가 아닌 클래스에 관계 맺어 줄 수 있음
- 독립적인 프로그래밍 가능
  - 클래스 선언과 구현 분리하여 특정 클래스의 변경이 다른 클래스에 영향을 미치지 않도록 구현 가능

### 인터페이스의 이해
- 클래스를 사용하는 측(User)과 제공하는 측(Provider)이 있음
- 메소드를 사용하는 쪽에서는 사용하려는 메소드의 선언부만 알아도 된다.
- 클래스 A가 클래스 B의 인스턴스를 생성하고 메소드를 호출하면 A-B는 직접적인 관계에 있다.
- 클래스 A가 클래스 B를 직접 호출하지 않고 인터페이스를 매개체로 접근하도록 하면(A-I-B)
클래스 B에 변경 사항이 생기거나 다른 클래스로 대체되어도 클래스 A는 영향을 받지 않음
  - 매개변수를 통해 동적으로 인스턴스 제공 (Ex: Thread(Runnable target))
  - 제3의 클래스(InstanceManager) 통해 인스턴스 제공 (Ex: JDBC DriverManger class)

### 디폴트 메소드와 static 메소드
- 디폴트 메소드: 추상 메소드의 기본적인 구현을 제공하는 메소드
  - 인터페이스에 메소드를 추가할 경우 인터페이스를 구현한 모든 클래스에 새로 추가된 메소드 구현 필요한 문제점
  - 접근제어자는 public이며 구현부가 필요
  - 이름이 충돌할 경우
    - 여러 인터페이스의 디폴트 메소드간의 충돌 -> 오버라이딩 필요
    - 디폴트 메소드와 상위 클래스 메소드간의 충돌 -> 상위 클래스의 메소드가 상속

## 내부 클래스
### 내부 클래스의 정의
- 클래스 내에 선언된 클래스
- 내부 클래스에서 외부 클래스 멤버에 쉽게 접근
- 불필요한 클래스를 감추어 코드의 복잡성 줄임(캡슐화)

### 내부 클래스의 종류와 특징
- 인스턴스 클래스: 외부 클래스의 인스턴스 멤버처럼 다루어짐, 외부 클래스 인스턴스 멤버와 관련된 작업에 사용
- 스태틱 클래스: 외부 클래스 스태틱 멤버처럼 다루어짐, 외부 클래스 스태틱 멤버(특히 스태틱 메소드)와 관련된 작업에 사용
- 지역 클래스: 외부 클래스 메소드나 초기화 블록에 선언하여 해당 영역 내부에서만 사용
- 익명 클래스: 클래스 선언과 객체 생성을 동시에 하는 이름 없는 클래스

### 내부 클래스의 제어자와 접근성
- 인스턴스 클래스와 스태틱 클래스는 멤버와 같이 간주
- 클래스이므로 abstract, final 사용 가능하며 멤버이므로 접근제어자도 사용 가능
- 인스턴스 멤버와 스태틱 멤버에 적용되는 규칙이 그대로 적용됨
- 지역 클래스는 지역변수 접근 가능하나 상수(final) 지역변수만 접근 가능
- 외부 클래스 아닌 다른 클래스에서 내부 클래스 생성 가능하나 권장되지 않음
- 컴파일시 외부클래스명$내부클래스명.class 형식, 같은 이름의 내부 클래스는 외부클래스명$숫자내부클래스명.class
- 외부 클래스명.this로 변수 서로 구별 가능

### 익명 클래스
- 클래스 선언과 객체 생성을 동시에 하여 한번만 사용되는 일회용 클래스
- 컴파일시 외부클래스명$숫자.class 파일 생성

```java
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Test {
  public static void main(String[] args) {
    Button b = new Button("Start");
    b.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Action event");
      }
    });
  }
}
```