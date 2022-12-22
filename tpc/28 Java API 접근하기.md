# Java API 접근하기
- 클래스를 묶어 jar 파일로 배포
- java에서 제공해주는 API는 jrt-fs.jar 파일
- lang, util, io, net등으로 구성
- java.lang 패키지는 디폴트 패키지(자동으로 import)

# String 클래스
- 문자열을 저장하는 기본 데이터 타입은 없음
- 여러가지 조작을 할 수 있기 때문에 별도의 클래스(java.lang.String)로 만듬
- 기본 데이터 타입이 아니므로 객체로 취급
- new로 생성 가능(heap area)하며 문자열 상수를 이용(literal pool)하는 방법도 있음
- 문자열 상수를 이용하는 경우 == 연산자로 비교 가능하나 new로 생성한 경우 equals를 사용해야