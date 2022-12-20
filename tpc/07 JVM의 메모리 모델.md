# JVM의 메모리 모델
- JVM이 사용하는 메모리 영역으로 4부분이 있음
- method area, stack area, heap area, literal area
- method area: 메소드의 바이트 코드가 저장되는 영역, static zone, non-static zone으로 나누어짐
- stack area: 메소드가 호출되면 메소드의 호출 정보가 저장되는 영역
- heap area: 객체가 생성되는 영역
- literal pool: 문자열(객체) 상수가 저장되는 영역


## Ex1
```java
public class TPC08 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int v = add(a, b);
        System.out.println(v);
    }
    
    public static int add(int a, int b) {
        int sum = a + b;
        return sum;
    }
}
```
1. 현재 디렉토리에서 해당 클래스 찾음
2. static 메소드를 메모리로 로딩(매소드 영역의 static zone)
    - main, add 메소드 로딩됨
3. static zone에서 main() 메소드를 실행
    - main method의 호출 정보가 stack area에 들어감(push)
    - PC의 위치가 현재 동작되고 있는 메소드
    - 다른 메소드가 실행되면 stack area에 push되고 PC가 해당 부분을 가리키며 제어권이 해당 메소드에 넘어감
4. stack area가 비어 있으면 프로그램이 종료된 것

## Ex2
```java
public class TPC09 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        TPC09 tpc = new TPC09();
        int v = tpc.add(a, b);
        System.out.println(v);
    }
    
    public int add(int a, int b) {
        int sum = a + b;
        return sum;
    }
}
```
1. 해당 클래스를 현재 디렉토리에서 찾는다.
2. 클래스 내부의 static 메소드를 메모리로 로딩한다.
   - method area의 static zone에 main()이 로딩
3. static zone에서 main 메소드를 실행
   - main 메소드가 호출되면 main 메소드의 호출 정보가 stack area에 들어감(push)
   - PC의 위치가 현재 동작되고 있는 메소드
4. new 연산자를 통해 TPC08 인스턴스가 heap area에 생성
   - 인스턴스 메소드 add()가 method area의 non-static zone에 로딩
   - heap area에는 add 함수의 포인터가 위치
5. stack area가 비어있다면 프로그램이 종료된 것