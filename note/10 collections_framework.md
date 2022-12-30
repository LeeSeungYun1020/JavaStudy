# 컬렉션 프레임워크
- 데이터 그룹을 저장하는 클래스를 위해 표준화한 설계(구조)
- 컬렉션 = 다수의 데이터, 프레임워크 = 표준화된 프로그래밍 방식
- 인터페이스를 이용한 객체지향적 설계로 표준화, 재사용성 높은 코드 작성 가능

## 컬렉션 프레임워크의 핵심 인터페이스
- List, Set, Map
- List와 Set의 공통 부분은 Collection 인터페이스에 정의, Map은 형태가 달라 불포함
- List: 순서가 있는 데이터 집합, 데이터 중복 허용
- Set: 순서 유지하지 않는 데이터 집합, 데이터 중복 허용 X
- Map: 키와 값의 쌍으로 이루어진 데이터 집합, 순서 유지 X, 키 중복 허용 X, 값 중복 허용

### Collection 인터페이스
- List와 Set의 조상
- 데이터 읽기, 추가, 삭제 등 메소드 제공
- add, addAll, clear, contains, containsAll, isEmpty, iterator, remove, removeAll, retainAll, size, toArray
- boolean return하여 성공 여부 반환

### List 인터페이스
- 중복 허용하면서 순서가 있는 컬렉션 구현에 사용
- ArrayList, LinkedList, Vector(>Stack)
- add, addAll, get, indexOf, listIterator, remove, set, sort, subList

### Set 인터페이스
- 중복 허용하지 않고 순서가 없는 컬렉션 구현에 사용
- HashSet, SortedSet(>TreeSet)

### Map 인터페이스
- 키와 값을 하나의 쌍으로 묶어서 저장하는 컬렉션 구현에 사용
- Hashtable, HashMap(>LinkedHashMap), SortedMap(>TreeMap)
- clear, containsKey, containsValue, entrySet, get, isEmpty, keySet, put, putAll, remove, size, values
- 내부 인터페이스인 Map.Entry 인터페이스가 있으며 Map 인터페이스 구현하는 클래스는 Map.Entry 인터페이스도 구현해야

## ArrayList
- Vector 클래스를 개선한 순서가 유지되고 중복을 허용하는 컬렉션
- 내부적으로 배열을 이용하며 공간이 가득찰 경우 큰 새로운 배열 생성해 복사 후 저장 -> 여유있게 충분한 용량의 인스턴스 생성 필요
- 배열의 처음이나 중간에 객체를 추가/삭제하는 경우 객체를 한 칸씩 앞/뒤로 복사하는 작업이 필요하므로 작업 시간 오래 걸림
- 데이터 읽기 및 마지막에 추가/삭제가 빠름

## LinkedList
- 불연속적으로 존재하는 데이터를 서로 연결한 형태의 컬렉션
- 배열의 크기 변경과 메모리 낭비, 중간에 데이터 추가/삭제가 오래 걸리는 단점 극복
- 데이터 읽기(접근)은 데이터를 따라가야하므로 배열보다 느림
- 양방향(이전, 다음) 접근이 가능한 이중 연결 리스트로 구현
- Queue, Deque 인터페이스 구현 -> offer, peek, poll, remove 등 사용 가능

## Stack, Queue
- 스택
  - 마지막에 들어간 것이 가장 먼저 나옴(Last In First Out)
  - 배열로 구현 적합
  - Stack 클래스 제공
  - 수식 계산, 괄호 검사, undo/redo, 브라우저의 뒤로/앞으로
- 큐
  - 처음에 들어간 것이 가장 먼저 나옴(First In First Out)
  - 연결 리스트로 구현 적합
  - Queue는 인터페이스, 구현한 클래스(LinkedList) 사용
  - 최근 문서, 인쇄 대기 목록, 버퍼


- 우선순위 큐
  - 저장 순서와 관계 없이 우선순위 높은 항목 먼저 나옴
  - 힙으로 구현 적합
  - PriorityQueue 클래스
- 덱
  - 양쪽 끝에 추가/삭제가 가능(double-ended queue)
  - Deque 인터페이스, 구현한 클래스(ArrayDeque, LinkedList) 사용

## 이터레이터
- Enumeration
  - Iterator 이전에 사용하던 클래스
  - hasMoreElements, nextElement 메소드
- Iterator
  - 컬렉션에 저장된 각 요소에 접근
  - hasNext, next, remove 메소드
  - Map의 경우 Iterator it = map.entrySet().iterator()로 생성
- ListIterator
  - 양방향 조회가 가능한 이터레이터
  - List 인터페이스를 구현한 경우만 사용 가능
  - remove는 next로 읽어온 객체를 삭제(이터레이터는 커서 기준으로 동작한다는 사실 기억)
  - cursor는 읽어 올 요소의 위치를 저장, lastRet는 마지막으로 읽어 온 요소의 위치 저장
  - add시 cursor 값이 하나 증가(가리키는 위치를 그대로하기 위해)하며 lastRet도 -1로 초기화
  - remove시 cursor 값 하나 감소하며 lastRet -1로 초기화

## Arrays
- copyOf, copyOfRange: 배열 전체(copyOf) 또는 일부(copyOfRange) 복사
- fill, setAll: 배열 각 요소를 모두 특정 값(fill) 또는 식 결과(setAll)로 채움
- sort, binarySearch: 정렬과 이진 탐색(이미 정렬된 상태에서 시행, 같은 값의 요소가 여러개인 경우 어떤 값 나올지 알기 어려움)
- equals(다차원 deepEquals)(배열 비교), toString(다차원 deepToString)(베열 출력)
- asList: 배열을 리스트로 변환, 리스트 크기 변경 불가(변경 원할 경우 ArrayList 생성자로 전달)
- parallel~: 빠른 결과 얻기 위해 여러 스레드가 작업 나누어 처리하도록 함
- spliterator: 여러 스레드가 처리할 수 있도록 하나의 작업을 여러 작업으로 나누는 Spliterator 반환
- stream: 컬렉션을 스트림으로 변환

## Comparator와 Comparable
- Comparable: 해당 클래스 객체의 기본 정렬 기준을 구현할 때 사용, compareTo(object) 구현
- Comparator: 기본 정렬 기준 외에 다른 기준으로 정렬하고자할 때 사용 compare(object, object) 구현

## HashSet
- 해싱을 통해 구현된 중복을 허용하지 않고 순서가 없는 컬렉션
- 저장 순서를 유지하려면 LinkedHashSet 사용
- add시 중복 확인을 위해 equals와 hashCode 사용

### hashCode 조건
- 동일 객체에 여러번 hashCode 호출해도 같은 int 값 반환
- equals가 true인 경우 hashCode도 일치해야
- equals가 false인 경우 가능한한 hashCode 달라야(해싱 사용 컬렉션 성능 향상)

## TreeSet
- 이진 검색 트리 형태로 데이터를 저장하는 컬렉션, 레드-블랙 트리로 구현
- 이진 검색 트리는 부모 노드의 왼쪽에는 작은 값을 오른쪽에는 큰 값을 저장
- 중복 데이터 저장을 허용하지 않고 정렬된 위치에 저장해 정렬, 검색, 범위 검색에 높은 성능, 추가/제거시 시간 소요
- Comparable을 구현한 클래스를 저장하거나 Comparator를 제공해서 비교 방법 알려줘야
- headSet으로 기준값보다 작은 값을, tailSet으로 기준값보다 크거나 같은 값을 얻을 수 있음

## HashMap
- 해싱을 사용하여 키와 값을 묶어 하나의 데이터(entry)로 저장
- 키는 유일해야 하며 하나의 키에 값을 여러번 put하면 덮어쓰기 됨
- entrySet(), keySet(), values() 이용하여 키와 값 읽을 수도 있음
- 데이터와 값 모두 Object이므로 HashMap의 값으로 HashMap 저장 가능

### 해싱과 해시함수
- 해싱: 해시함수를 이용하여 데이터를 해시 테이블에 저장하고 검색하는 기법
- 해시함수: 임의의 길이를 갖는 데이터를 고정된 길이의 데이터로 매핑하는 함수
- 키를 해시함수에 넣어 저장할 위치를 결정하고 해당 위치의 연결 리스트에 저장
- 연결 리스트는 검색에 불리한 자료구조이므로 해시함수가 최대한 다른 값을 반환해야 유리

## TreeMap
- 이진 검색 트리 형태로 키-값 쌍 데이터를 저장하는 컬렉션
- 범위검색, 정렬이 필요한 경우에 사용(검색은 HashMap이 대부분 더 빠름)

## Properties
- HashTable을 상속 받아 String 키-값 쌍 데이터를 저장하도록 구현한 컬렉션
- 어플리케이션 환경설정 관련 속성 저장에 사용, 파일에서 데이터 읽고 쓰는 기능 제공
- getProperty, setProperty로 저장/조회
- list로 출력, load로 입력, store로 저장 
- 이터레이터가 아닌 Enumeration 사용

## Collections
- 배열에서 Arrays가 배열 관련 메소드를 제공한 것처럼 컬렉션 관련 메소드를 제공
- fill, copy, sort, binarySearch 같이 Arrays에서 제공하는 기능
- 컬렉션은 동기화를 자체적으로 처리하지 않음, 동기화 필요시 syncronizedCollection() 사용
- 변경불가능한 컬렉션은 unmodifiedCollection() 사용
- 하나의 객체만 저장하는 싱글톤 컬렉션은 singleton() 사용

## 컬렉션 클래스 정리
- ArrayList: 배열 기반, 임의 요소 접근과 마지막 추가/삭제에 유리, 중간 추가/삭제에 불리
- LinkedList: 연결 기반, 중간 추가/삭제에 유리, 임의 요소 접근 불리
- HashMap: 배열과 연결 결합, 추가, 삭제, 검색, 접근성 모두 유리
- TreeMap: 연결 기반, 정렬과 범위 검색에 유리
- Stack: 배열 기반, 나중에 들어온 데이터가 먼저 나감
- Queue: 연결 기반, 먼저 들어온 데이터가 먼저 나감
- Properties: 배열과 연결 결합, Hashtable 상속받아 string 키-쌍 데이터 저장
- HashSet: HashMap 이용하여 구현(value로 빈 object 저장)
- TreeSet: TreeMap 이용하여 구현
- LinkedHashMap/LinkedHashSet: HashMap과 HashSet에 저장 순서 유지 기능 추가