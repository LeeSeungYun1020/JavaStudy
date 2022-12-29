# 날짜와 시간
## Calendar와 Date
### Calendar
- Calendar는 추상 클래스, 구현한 클래스로 GregorianCalendar, BuddhistCalendar 존재
- Calendar.getInstance()로 인스턴스 획득 -> 다른 종류의 인스턴스 필요한 경우에 유연하게 대응
- 현재 시스템의 날짜와 시간으로 초기화
- month는 0부터 시작

### Date-Calendar간 변환
- Date의 대부분의 메소드는 deprecated
- Date date = new Date(calendar.getTimeInMillis());
- calendar.setTime(date);

### 시간 계산
- getTimeInMillis() 이용, 밀리초 단위 계산
- get, set 메소드에 필드값(Calendar에 정의된 static 상수) 전달
- after, before 메소드로 시간상 전후 파악
- add, roll 메소드로 필드값 증감, roll은 다른 필드에 영향 X, 일 필드가 말일(30, 31)일 경우 월 필드 변경시 변경될 수 있음

## 형식화 클래스
- 숫자, 날짜, 텍스트 데이터를 일정한 형식에 맞게 표현할 수 있는 클래스
- 데이터를 형식화하여 출력(format)하고 형식화된 데이터에서 데이터를 추출(parse)할 수 있음
- DecimalFormat: 숫자 형식화
- SimpleDateFormat: 날짜 형식화 (Calendar 클래스 사용시 Date로 변환 필요)
- ChoiceFormat: 특정 범위에 속하는 값을 문자열로 변환
- MessageFormat: 정해진 양식에 맞게 출력(추출)

## java.time 패키지
- 기존 Calendar 클래스는 변경 가능하므로 쓰레드에 안전하지 않음 -> 날짜, 시간 변경 메소드가 새로운 객체 반환하도록 변경
### java.time 패키지의 클래스
- LocalDate(날짜), LocalTime(시간), LocalDateTime(날짜, 시간), ZonedDateTime(날짜, 시간, 시간대), Instant(나노초)
- Period(날짜간 차이), Duration(시간간 차이)
- Temporal, TemporalAccessor, TemporalAdjuster 구현한 클래스: LocalDate, LocalTime, LocalDateTime, ZonedDateTime, Instant
- TemporalAmount 구현한 클래스: Period, Duration
- TemporalUnit(날짜와 시간 단위 정의, ChronoUnit), TemporalField(날짜와 시간의 필드 정의, ChronoField)

### LocalDate와 LocalTime
- 객체 생성은 now(), of(), parse() 이용
- getXXX()로 필드값 가져올 수 있으며 Calendar와 달리 월 범위가 1~12, 월요일이 1로 시작(Calendar는 월 범위가 0~11, 일요일이 1로 시작)
- get(), getLong() 함수 인자로 ChronoField에 정의된 상수 전달하여 이용 가능
- 필드값 변경은 with(), plus(), minus()로 가능, LocalTime의 truncatedTo()로 지정 단위보다 작은 단위 필드 0으로 변경 가능
- 날짜, 시간 비교는 isAfter(), isBefore(), isEqual() (compareTo는 같은 타입일 때만 비교 권장 Ex: LocalDate와 JapaneseDate 비교시 이상 동작)

### Instant
- EPOCH TIME부터 경과된 시간 나노초 단위로 표현, UTC(+00:00) 기준
- 기존의 java.util.Date 대체, date.toInstant()와 Date.from(instant)로 변환
- 시간을 초 단위와 나노초 단위로 나누어 저장
- 객체 생성은 now(), ofEpochSecond() 이용
- getEpochSecond(), getNano()로 필드값 접근, toEpochMilli() 정의

### LocalDateTime과 ZonedDateTime
- LocalDateTime: LocalDate + LocalTime
  - 객체 생성은 now(), of()로 가능하며 LocalDate와 LocalTime의 at 메소드도 사용 가능
- ZonedDateTime: LocalDateTime + 시간대
  - LocalDateTime에 atZone()으로 시간대 정보 추가하여 얻을 수 있음
  - 시간대는 ZoneId 클래스를 사용, 일광 절약시간을 자동적으로 처리
  - UTC로 부터 얼마나 떨어져 있는지는 ZoneOffset으로 표현
  - OffsetDateTime은 ZoneId가 아닌 ZoneOffset을 사용(일광 절약시간 같은 시간대 관련 규칙 고려 X)
  - GregorianCalendar.from(zonedDateTime), gregorianCalendar.toZonedDateTime()로 GregorianCalendar간 변환 가능

### TemporalAdjusters
- 자주 사용하는 날짜 계산들을 대신 해주는 메소드를 정의해놓은 클래스
- LocalTime, LocalDateTime, Instant 등에서 with() 메소드로 호출 가능
- TemporalAdjuster 인터페이스를 구현하여 커스텀 메소드 생성 가능
```java
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TimeEx4 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.with(new DayAfterTomorrow()));
        System.out.println(today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)));
    }
}

class DayAfterTomorrow implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        return temporal.plus(2, ChronoUnit.DAYS);
    }
}
```

### Period와 Duration
- Period: 날짜의 차이, (years, months, days)
- Duration: 시간의 차이 (seconds, nanos -> hours, minutes는 LocalTime으로 변환 후 get)
- between(), until(), of()로 객체 생성 가능
  - between() Ex: Period.between(date1, date2) //= date2 - date1
  - until() Ex: date1.until(date2), 시간은 Duration 반환 X
  - of() Ex: Period.of(year, month, day)
- with()로 특정 필드 값 변경 가능
- plus, minus, multipliedBy, dividedBy(Duration만)로 사칙연산
- isNegative, isZero로 비교연산 / abs(Duration만), negate로 부호 변경
- normalized로 월단위 조정(일 단위로 조정되지 않음)
- toXXX()로 다른 단위(TotalMonths, Days, Hours, ...)로 변환 가능, 지정 단위 이하는 버려짐


### 파싱과 포맷
- 포맷
  - 형식화 관련 클래스는 java.time.format 패키지에 정의
  - DateTimeFormatter 클래스와 format 메소드 사용
  - ofLocalizedDate(), ofLocalizedTime(), ofLocalizedDateTime()으로 로케일에 종속적인 포맷터 생성 가능
  - ofPattern()으로 원하는 출력 형식 지정한 포맷터 생성 가능
- 파싱
  - parse() 이용 - Ex: LocalDate.parse("2016-03-02", DateTimeFormatter.ISO_LOCAL_DATE)
  - ofPattern() 이용 - Ex: DateTimeFormatter.ofPattern("yyyy-MM-dd")를 parse 메소드 인자로 전달