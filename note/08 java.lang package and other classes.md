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

## 유용한 클래스
### java.util.Objects 클래스
- Object 클래스의 보조 클래스, 객체 비교와 null 체크에 유용
- isNull(), nonNull(): null 체크
- requireNonNull(): null인 경우 NullPointerException 발생, 다음 인자로 에러 메시지 전달 가능
- compare(): 같으면 0, 크면 양수, 작으면 음수 반환
- equals(): null 검사 불필요 ((a == b) || (a != null && a.equals(b)))
- deepEquals(): 객체를 재귀적으로 비교 -> 다차원 배열 비교 가능
- toString(): 내부적으로 null 검사, default 값 지정 가능
- hashCode(): null 검사 후 Object 클래스의 hashCode 호출, null인 경우 0 반환
- hash(): hashCode 함수를 오버라이딩할 때, 매개변수 타입이 가변인자인 이 함수 이용하면 편리

### java.util.Random 클래스
- 난수를 얻을 때 사용하는 클래스
- Math.random()은 내부적으로 Random 클래스의 인스턴스를 생성해 사용
- 시드 값을 지정 가능, 시드는 기본적으로 현재시간(System.currentTimeMillis())로 초기화
- nextInt() bound 지정 가능

### 정규식(java.util.regex 패키지)
- 텍스트 데이터 중 원하는 조건(패턴)과 일치하는 문자열 찾기 위해 사용
#### 정규식 정의 및 비교
- 정규식을 매개변수로 Pattern 클래스의 static 메소드인 Pattern compile(String regex)을 호출하여 Pattern 인스턴스를 얻는다.
  - Pattern p = Pattern.compile("c[a-z]*");
- 정규식으로 비교할 대상을 매개변수로 Pattern 클래스의 Matcher matcher(CharSequence input)를 호출해서 Matcher 인스턴스를 얻는다.
  - Matcher m = p.matcher(data[i]);
- Matcher 인스턴스에 boolean matches()를 호출해서 정규식에 부합하는지 확인한다.
  - if(m.matches())
#### 정규식 그룹화
- 괄호로 묶어 그룹화
- group(int i)를 통해 나누어 얻을 수 있음
- Matcher 인스턴스의 find로 패턴과 일치하는 부분 있는지 확인 가능
- Ex: 전화번호 (0\\d{1,2})-(\\d{3,4})-(\\d{4})
#### 문자열 치환
- Matcher 인스턴스(m)의 appendReplacement(StringBuffer sb, String replacement) 이용
  - source의 시작부터 찾은 위치까지의 내용에 변경해서 저장
- m.find는 앞서 발견된 위치의 끝에서부터 다시 검색 시작
- m.appendTail으로 남은 부분 버퍼에 덧붙임
```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Useful7 {
    public static void main(String[] args) {
        String source = "A broken hand works, but not a broken heart.";
        String pattern = "broken";
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);
        System.out.println("Source: " + source);

        while (m.find()) {
            System.out.println("매칭: " + m.start() + "~" + m.end());
            m.appendReplacement(sb, "drunken");
        }
        m.appendTail(sb);
        System.out.println("result: " + sb.toString());
    }
}
```

### java.util.Scanner 클래스
- 화면, 파일, 문자열과 같은 입력소스에서 문자 데이터 읽을 때 도움을 주는 클래스
- 정규식 표현을 이용한 라인단위 검색 지원
- 구분자 단위 입력 가능(구분자도 정규식 지원)
  - new Scanner(line).useDelimiter(",")

### java.util.StringTokenizer 클래스
- 문자열을 구분자를 기준으로 토큰이라는 여러 개의 문자열로 자를 때 사용하는 클래스
- 여러 구분자 허용, 구분자로는 하나의 문자만 허용(구분자가 두 문자 이상이면 Scanner, String의 split 이용 필요)
  - "+-*/"면 +, -, *, / 모두 구분자
- split 메소드와 달리 빈 문자열은 토큰으로 인식하지 않음

### java.math.BigInteger 클래스
- long보다 더 큰 정수형 값 다루는 클래스
- 값을 int 배열로 저장하며 String처럼 불변 (+-2 ^ Integer.MAX_VALUE 까지 표현 가능)
- 초기화시 정수형 리터럴로는 표현 가능한 값에 한게가 있으므로 문자열로 표현하는 것이 일반적
- toByteArray로 바이트 배열로 변환 가능하며, intValue, intValueExact(ArithmeticException 발생) 지원
- 산술 연산, 비트 연산 메소드 정의

### java.math.BigDecimal 클래스
- double보다 더 정밀한 실수형 값 다루는 클래스
- 실수형의 오차는 10진 실수를 2진 실수로 바꿔 저장하기 때문인데 오차가 없는 2진 정수로 변환하여 다룸
- 정수(unscaled value, BigInteger), 지수(scale), 정밀도(precision) 저장
- 초기화시 실수형 리터럴로는 표현 가능한 값에 한계가 있으므로 문자열로 표현하는 것이 일반적
  - double 타입 사용시 오차 발생 가능(Ex: 0.1)
- toPlainString으로 지수 형태 아닌 숫자로만 표현 가능, intValue, intValueExact(ArithmeticException 발생) 지원
- 산술 연산 지원 - 연산 결과의 정수, 지수, 정밀도가 달라짐
- divide는 나눗셈 결과 반올림 방법(roundingMode)과 몇 번째 자리(scale)에서 반올림할 것인지 지정 가능
  - 열거형 RoundMode에서 CEILING, FLOOR, UP, DOWN, HALF_UP, HALF_EVEN, HALF_DOWN, UNNECESSARY 제공
  - 1.0/3.0 같이 결과가 무한소수일 경우 반올림 모드 미지정시 ArithmeticException 발생
- setScale로 지수값 변경 가능(scale 값 줄일 때에는 반올림 모드 지정 필요)