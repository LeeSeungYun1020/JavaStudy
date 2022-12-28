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
