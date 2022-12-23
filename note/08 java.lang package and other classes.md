# java.lang 패키지와 유용한 클래스
## java.lang 패키지
### Object class
- 모든 클래스의 최고 조상
- clone, equals, finalize, getClass, hashCode, toString, notify, notifyAll, wait 메소드로 구성
- equals(Object obj)
  - 객체의 참조변수 비교하여 boolean return
  - 오버라이딩하여 객체에 저장된 내용을 비교하도록 구현 가능
- hashCode()
  - 해싱 기법에 사용되는 해시 함수 구현한 것
  - equals 메소드를 값을 기준으로 비교하도록 구현했다면 hashCode도 같은 값을 가지도록 구현해야 함
  - System.identityHashCode(Object x)는 객체의 주소값으로 해시코드 생성 -> 서로 다른 객체 구분 가능
- toString()
  - 인스턴스 정보를 문자열로 제공
  - 기본값은 클래스명@16진수 해시코드
- clone()
  - 복제하여 새로운 인스턴스 생성
  - Cloneable 인터페이스 구현 및 접근제어자 public으로 변경 필요
  - 값만 복사 -> 참조타입의 인스턴스 변수, 배열은 같은 값 가리킴
- 공변 반환타입
  - 오버라이드할 때 조상 메소드의 반환타입을 자손 클래스 타입으로 변경 허용
  - Ex: clone 메소드 오버라이드시 Object가 아닌 해당 타입으로 반환 -> 불필요한 형변환 제거
- 얕은 복사와 깊은 복사
  - 얕은 복사: 값만 복사하여 참조하고 있는 객체까지 복제하지 않음, 원본 및 복사본의 변경이 서로에게 영향
  - 깊은 복사: 참조하고 있는 객체까지 복제, 원본 및 복사본의 변경이 서로에게 영향 X
- getClass()
  - 클래스의 Class 객체 반환
  - Class 객체는 클래스 정보를 담고 있으며 클래스 파일이 클래스 로더에 의해 메모리에 올라갈 때 자동생성
  - 클래스 로더는 실행 시에 필요한 클래스를 동적으로 메모리에 로드하는 역할
    - 기존 생성된 클래스 객체가 메모리에 존재하는지 확인하여 참조를 반환
    - 메모리에 없다면 클래스 패스(path)를 따라 클래스 파일 찾아 Class 객체로 변환
    - 클래스가 없다면 ClassNotFoundException 발생
- Class 객체를 얻는 방법
  - 생성된 객체에서 - new Card().getClass()
  - 클래스 리터럴에서 - Card.class
  - 클래스 이름으로 - Class.forName("Card")
  - Class 객체를 통해 객체를 생성하고 메소드 호출 가능

### String class
- 변경 불가능한 클래스
  - 내부적으로 문자 배열 사용
  - 연산자 +로 결합하는 경우 매번 새로운 문자열 생성 -> 결합횟수 줄이거나 StringBuffer 이용
- 문자열 비교 
  - 문자열 리터럴을 이용한 경우 == 으로 비교 가능
  - new로 생성한 경우 equals로 비교해야
- 빈 문자열
  - 자바에서는 길이가 0인 배열이 가능하며 ""은 char[0]인 배열 저장
- replace, replaceAll, replaceFirst
  - replace와 replaceAll은 일치하는 문자열 모두 변경
  - replaceAll, replaceFirst는 정규식 가능
- join과 StringJoiner
  - String.join(delimiter, elements)
  - new StringJoiner(delimiter, prefix, suffix) 후 add(element)
- 문자 인코딩 변환
  - 서로 다른 문자 인코딩 사용하는 컴퓨터간 데이터 전송 위해 문자 인코딩 필요
  - new String("문자".getBytes("UTF-8"), "UTF-8");
- 기본값 <-> String 변환
  - valueOf 이용 - String.valueOf(i), Integer.valueOf(s)(래퍼클래스 반환), Integer.parseInt(s)(기본형 반환)
- substring
  - substring(start, end)에서 end는 불포함

### StringBuffer class, StringBuilder class
- StringBuffer
  - 버퍼를 이용하여 문자열 변경이 가능한 class
  - 버퍼의 기본 크기는 16이며 문자열을 지정할 경우 문자열 길이 + 16의 버퍼를 가짐
  - append, delete, insert, replace, reverse는 자신의 인스턴스를 반환하므로 연속 호출이 가능
  - equals 메소드를 오버라이드하지 않으므로 string으로 변환 후 equals로 비교해야
- StringBuilder
  - 멀티스레드에 안전하지 않은 StringBuffer 클래스

### Math class
- 상수: E, PI
- 올림, 버림, 반올림: ceil, floor, round
  - 첫째 자리에서 계산되므로 곱하기 10^n으로 자릿수 조정 필요
- 오버플로우시 예외를 발생시키는 메소드: ~Exact
  - addExact, ..., incrementExact, negateExact, toIntExact
- 삼각함수, 지수, 로그
  - cos, sin, tan, atan, atan2, sqrt, pow, toRadians, toDegrees, log10
  - 삼각함수 매개변수 단위는 라디안
- StrictMath
  - Math 클래스는 성능을 위해 OS의 메소드를 이용하여 계산
  - 성능상 이점을 포기하고 어떤 OS도 같은 결과를 얻도록 함

### 래퍼 클래스
- 성능을 위해 8개의 기본형은 객체로 다루지 않음
- 기본형 변수가 객체로 다뤄질 필요가 있는 경우 사용됨
- equals, compareTo를 통한 비교
- Number class
  - Byte, Short, Integer, Long, Float, Double, BigInteger, BigDecimal
  - 객체가 가지고 있는 값을 숫자와 관련된 기본형으로 변환하는 메소드 정의
- 오토박싱과 언박싱
  - 오토박싱: 기본형 값 -> 래퍼 클래스 객체
  - 언박싱: 래퍼 클래스 객체 -> 기본형 값