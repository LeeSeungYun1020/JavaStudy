# Part1 학습 정리
## class
- 데이터 타입 측면: 새로운 자료형을 만드는(설계하는) 도구 = 모델링 도구
- 객체지향 측면: 객체의 상태 정보와 행위 정보를 추출하여 캡슐화하는 도구
- 클래스를 모델이라고도 함 (역할이 정해지므로)

## model의 종류
- DTO(Data Transfer Object): 데이터 구조, 데이터를 담아 이동하기 위한 역할
  - VO(Value Object): 객체를 담아 하나의 값으로 취급하기 위한 역할
- DAO(Data Access Object): 데이터를 처리하는 역할(비즈니스 로직, 데이터베이스와 CRUD 역할)
- Utility(Helper Object): 도움을 주는 기능을 제공하는 역할(문자열, 날짜, 시간, 통화, 인코딩)

## API
- Java에서 제공해주는 class(String, System, Integer, Map)
  - import 필요, java.lang.*은 기본적으로 import되므로 생략 가능
- 직접 만들어 사용하는 class(DTO, DAO, Utility)
- 다른 사람이 만들어 제공해주는 class(Gson, Jsoup)