# 예외 처리
## 예외 처리
### 프로그램 오류
- 컴파일 에러: 컴파일시에 발생하는 에러
- 런타임 에러: 실행시에 발생하는 에러
- 로지컬 에러: 실행은 되지만 의도와 다르게 동작하는 에러

- 에러(error): 복구할 수 없는 심각한 오류
- 예외(exception): 프로그램 코드에 의해 수습될 수 있는 다소 미약한 오류

### 예외 클래스의 계층구조
```text
Object --- Throwable -┬- Exception -┬- RuntimeException       -┬- ArithmeticException
                      │             ├- IOException             ├- ClassCastException
                      │             └- ClassNotFoundException  └- NullPointerException
                      └- Error
```
- Exception: 외적 요인(사용자 실수 등)에 의한 예외
- RuntimeException: 프로그래머 실수에 의한 예외

### 예외처리 - try-catch문
- 예외처리: 프로그램 실행시 발생할 수 있는 예외에 대비한 코드 작성하는 것
- 프로그램의 비정상 종료를 막고 정상적인 실행 상태 유지하도록 함
- try {} catch (Exception1 e) {} catch (Exception2 e) {} ... 형태
- 발생 예외의 종류와 일치하는 하나의 catch 블록만 수행되며 일치하는 catch 블록이 없으면 처리 X

### try-catch문의 흐름
- try내에서 예외가 발생한 경우
  - 일치하는 catch 블록 확인 -> catch 블록 수행 후 try-catch문 탈출
  - 일치하는 catch 블록 없음 -> 예외가 처리되지 않음
- try내에서 에외 발생 X
  - try 수행 후 try-catch문 탈출
- try 블록에서 예외 발생하면 이후 문장은 수행되지 않음

### 예외 발생과 catch 블록
- catch 블록의 괄호 내에 처리하고자 하는 예외 타입의 참조 변수를 선언
- 예외 발생시 해당 클래스의 인스턴스가 생성됨
- catch 블록을 차례로 내려가면서 instanceof 연산자로 검사하여 해당되는 최상위 블록 하나만 수행
- 모든 예외는 Exception class의 하위 클래스로 Exception 타입의 참조 변수 사용하면 모든 예외 처리 가능
- printStackTrace(): 에외 발생시 호출 스택에 있었던 메소드의 정보와 예외 메시지를 화면에 출력
- getMessage(): 발생한 예외 클래스의 인스턴스에 저장된 메시지를 얻을 수 있음
- 멀티 캐치 블록: catch(ExceptionA | ExceptionB e) {}와 같이 catch 블록을 합칠 수 있음
  - 상속 관계에 있는 예외 클래스를 합칠 경우 컴파일 에러 발생

### 예외 발생시키기
- 키워드 throw를 통해 고의로 예외 발생시킬 수 있음
- throw new Exception("에러 메시지");
- Exception 클래스는 checked 예외로 예외처리가 강제됨
- RuntimeException 클래스는 unchecked 예외로 예외처리 강제 X

