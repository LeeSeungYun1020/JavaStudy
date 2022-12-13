# 배열
## 배열
### 배열의 정의
- 같은 타입의 여러 변수 하나의 묶음으로 다루는 것
- 각 저장공간은 연속적으로 배치

### 배열 생성과 선언
- 타입[] 변수명, 타입 변수명[]으로 선언 가능
- 배열 생성은 연산자 new와 함께 타입과 길이 지정
- 타입[] 변수명 = new 타입[길이]

### 배열 길이와 인덱스
- 요소: 생성된 배열의 각 저장공간
- 인덱스: 배열의 요소마다 붙여진 일련번호, 0부터 시작
- 각 요소는 배열명[인덱스]로 접근 가능
- 인덱스 범위를 벗어나게 접근하는 경우 ArrayIndexOutOfBoundsException 발생
- 배열의 길이는 0일 수도 있다! (Ex: int[] arr = new int[0])
- 배열의 길이는 변경할 수 없다. 따라서 배열명.length는 상수이다.

### 배열의 초기화
- 자동적으로 타입의 기본값으로 초기화
- 생성과 동시에 명시적으로 초기화하려면 int[] arr = new int[]{ 10, 11, 10 } (new int[]는 생략 가능)
- 배열 모든 요소 출력시 Arrays.toString 유용

### 배열의 복사
- 배열의 크기를 늘리려면 더 큰 크기의 새로운 배열 생성 후 복사 필요
- 반복문을 이용하거나 System.arraycopy(src, srcPos, dest, destPos, length) 이용 가능

```java
import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int[] bigArr = new int[5];
        System.out.println(Arrays.toString(bigArr));
        System.arraycopy(arr, 0, bigArr, 2, 3);
        System.out.println(Arrays.toString(bigArr));
    }
}
```

## String 배열
### String 변수 선언 및 생성
- String[] arr = new String[3];
- 참조형 변수의 기본값은 null이므로 각 요소 값은 null로 변경

### String 배열 초기화
- String[] name = new String[]{"kim", "lee", "park"} (new String은 생략 가능)
- 원래는 클래스이므로 new String("kim")과 같이 객체를 생성해야 함

### char 배열과 String 클래스
- String 클래스는 char 배열에 기능(메소드)를 추가한 것
- charAt: 특정 인덱스의 문자 가져옴
- length: 배열 길이
- substring: 문자열의 일부 뽑아냄, 마지막 위치는 포함하지 않음
- equals: 문자열 내용이 같은지 비교, 대소문자 구분하지 않으려면 equalsIgnoreCase 사용
- toCharArray: char 배열로 변환, char 배열은 String 생성자에 넣어서 변환 가능

### 커맨드 라인을 통한 입력
- 프로그램 실행시 커맨드 라인에서 매개변수 전달 가능
- main 메소드의 String[] 매개변수로 전달되며 매개변수가 없는 경우 크기가 0인 배열이 전달

## 다차원 배열
### 2차원 배열 선언과 인덱스
- 타입[][] 변수명 또는 타입[] 변수명[] 또는 타입 변수명[][]
- Ex: int[][] score = new int[3][4];
- 배열명[행 인덱스][열 인덱스]로 접근

### 2차원 배열 초기화
- int[][] arr = new int[][] { {1, 2, 3}, {4, 5, 6} } (new int[][]는 생략 가능)
- length는 일차원 배열의 개수 반환

### 가변 배열
- 다차원 배열 생성시 마지막 차수의 길이를 다르게 생성