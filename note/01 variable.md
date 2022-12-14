# 변수

## 변수
### 변수의 정의
- 하나의 값을 저장하는 메모리 공간

### 변수 선언 초기화
- 변수타입 변수이름 = 값;
- 초기화는 변수 사용 전 처음으로 값 저장하는 것 의미
- 두 변수 값 교환에는 별도 변수를 이용하여 임시 저장 필요

### 변수 명명 규칙
- 대소문자 구분
- 예약어 사용 불가
- 숫자 시작 불가
- 특문은 _와 $만 허용

권장 규칙
- 클래스 첫글자는 대문자
- 여러 단어의 경우 단어 첫글자 대문자
- 상수는 모두 대문자, 여러 단어의 경우 _로 구분
- 용도를 알기 쉽게 의미 있는 이름 사용

## 변수의 타입
### 기본형과 참조형
- 기본형 변수는 실제 값 저장
  - boolean, char, byte, short, int, long, float, double
- 참조형 변수는 주소 값 저장
  - 기본형을 제외한 나머지 타입

### 기본형
- 논리형
  - boolean(1 byte)
- 문자형
  - char(2 byte)
- 정수형
  - byte, short, int(4 byte), long
- 실수형
  - float, double(8 byte)
- 기본형은 객체가 아니므로 null 값을 가질 수 없음 -> wrapper class 이용
- unsigned는 지원하지 않음

### 상수와 리터럴
- 상수: 값을 한 번 저장하면 변경할 수 없는 저장 공간, 타입 앞에 final 키워드 명시
- 리터럴: 그 자체로 값을 의미하는 것 (Ex: 12, 3.14, 'A')
- 상수는 리터럴에 의미 있는 이름을 붙여서 코드 이해와 수정 쉽게 함
- 일반적으로 리터럴의 타입은 변수의 타입과 일치하지만 타입이 달라도 넓은 저장 범위 타입의 변수에 좁은 저장 범위 타입의 값을 저장하는 것은 가능
- 문자열 리터럴은 new를 사용하지 않는 표현도 허용
- 덧셈 연산자는 피연산자 중 한 쪽이 String인 경우 다른 쪽은 String으로 변환한 후 문자열 결합

### 형식화된 출력 printf
- 지시자를 통해 변수의 값을 여러 형식으로 변환하여 출력
- %b(boolean), %d(decimal), %o(octal, 8진), %x(hexa-decimal, 16진), %f(floating point), %e(exponent), %c(character), %s(string)

## 진법
### 진법
- 컴퓨터는 2진법 사용
- 비트, 바이트(8비트), 워드(CPU가 한 번에 처리할 수 있는 데이터 크기)
- 2진수를 알아보기 쉽게 8진수, 16진수로 표기하여 자주 사용
- 음수 표현을 위해 2의 보수 사용

## 기본형
### 논리형 - boolean
- true, false
- 1 bit로 표현 가능하지만 자바의 최소 단위가 바이트이므로 1 byte 사용

### 문자형 - char
- 문자의 유니코드 저장(UTF-16)
- 유니코드 알고 싶을 경우 int로 형변환하여 확인

### 정수형 - byte, short, int, long
- 부호 비트로 1자리 사용하기 때문에 -2^(n-1) ~ 2^(n-1) - 1 표현 가능
- byte, short는 성능보다 저장공간이 중요한 특수한 경우에만 사용
- 타입이 표현할 수 있는 값의 범위를 넘어설 경우 오버플로우 발생

### 실수형 - float, double
- 표현 가능한 소수점 자릿수가 정해져 있음
- 오버플로우 -> 무한대, 언더플로우 -> 0
- IEEE754 - 부호, 지수, 가수 부분으로 나누어 저장
- 부동소수점 연산에는 오차 발생 가능

## 형변환
### 형변환(캐스팅)의 정의
- 변수 또는 상수타입을 다른 타입으로 변환하는 것

### 형변환 방법
- (타입)피연산자
- 피연산자는 형변환 이후에도 변화가 없다.
- 실수형에서 정수형 변환시 반올림이 아닌 버림 처리

### 정수형 형변환
- 큰 타입에서 작은 타입으로 변환할 때 값 손실 발생

### 실수형 형변환
- double에서 float로 형변환시 가수부에서 반올림이 발생
- 최대값보다 큰 값은 무한대, 최소값보다 작은 값은 0으로 저장

### 정수형, 실수형간 형변환
- 정수형 -> 실수형: int -> float 변환시 실수형 정밀도 제한으로 오차 발생 가능
- 실수형 -> 정수형: 실수형의 소수점 이하 값은 버려짐, 실수의 소수점을 버리고 남은 정수가 정수형 저장범위 넘어서면 오버플로우 발생한 결과 획득

### 자동 형변환
- 큰 타입에 작은 타입 대입
- 서로 다른 두 타입의 연산(산술 변환)
- 자동 형변환은 기존 값을 최대한 보존할 수 있는 타입으로 자동 형변환
- 기본형과 참조형은 서로 형변환 불가