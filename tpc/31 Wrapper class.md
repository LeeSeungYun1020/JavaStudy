# Wrapper 클래스
- 기본 자료형을 객체 자료형으로 사용할 수 있도록 만든 클래스(포장 클래스)
- Integer, Double, Character, Boolean 등
- Ex) 기본 자료형을 Object 배열에 저장
- 박싱: 기본형 -> 래퍼(int -> Integer, Integer i = 1;)
- 언박싱: 래퍼 -> 기본형(Integer -> int, int i = new Integer(10);)
- new Integer() -> Integer.valueOf()(-128~127 캐싱) -> 박싱 이용