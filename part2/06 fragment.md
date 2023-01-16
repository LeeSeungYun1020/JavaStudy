# Fragment

## 프래그먼트

- 프래그먼트는 액티비티내의 작은 화면 단위, 화면을 여러 영역으로 나누어 관리하는 목적으로 사용
- 액티비티는 독립적인 실행 단위로 메모리를 많이 소모, 화면만 필요한 경우 프래그먼트 활용이 효율적
- 생성자로 객체 생성보다 newInstance를 이용하는 것이 권장됨
- FragmentManager의 FragmentTransaction 이용
  - beginTransaction으로 생성, commit으로 반영
  - add는 프래그먼트를 지정 레이아웃에 추가하고 replace는 지정 레이아웃에 설정된 프래그먼트 제거하고 새 프래그먼트 추가
  - AddToBackStack 메소드로 프래그먼트를 백스택에 포함시켜 백 버튼으로 제거(이전 화면이 보임 또는 뒤로 가기)와 비슷한 효과
  - popBackStack 메소드로 백스택에서 프래그먼트를 꺼내 이전으로 돌아가는 효과
  - getBackStackEntryCount로 현재 백스택에 있는 프래그먼트 수를 알 수 있음

## 프래그먼트의 생명주기

CREATED

- onCreate(): 프래그먼트가 생성될 때
  - FragmentManager에 추가되고 onAttach 메소드 호출 이후
  - 저장된 상태 복구
- onCreateView(): 표시될 뷰 생성
  - 메소드가 반환하는 뷰를 프래그먼트로 보여줌
- onViewCreated(): 뷰 생성 이후, 뷰의 초기 상태 설정
  - 라이브 데이터 연결
  - 리사이클러뷰, 뷰페이저 어댑터 부착
- onViewStateRestored(): 뷰와 관련된 추가 상태 복구

STARTED

- onStart(): 프래그먼트가 실행
  - 수명 주기 인식 구성요소 연결

RESUMED

- onResume(): 프래그먼트가 보이는 중, Animator, Transition 효과 끝나면 사용자와 상호작용 가능

STARTED

- onPause(): 사용자가 프래그먼트를 떠나려고 하고 여전히 보이는 중(사라질 때)

CREATED

- onStop(): 프래그먼트가 더이상 보이지 않음(정지됨)
- onSaveInstanceState(): 인스턴스 상태 저장(화면 회전시 복원에 필요한 데이터 저장)
  - 화면 회전시 onPause - onStop - onSaveInstanceState - onCreate...onResume
- onDestroyView(): 모든 애니메이션과 전환이 완료되고 프래그먼트의 뷰가 창에서 분리됨
  - 프래그먼트 뷰에 대한 레퍼렌스를 해제하여 가비지 컬렉션될 수 있도록 해야 함

DESTROYED

- onDestroy(): 프래그먼트가 제거되거나 프래그먼트 매니저가 파괴됨

## 프래그먼트에서 뷰 제어

- 뷰바인딩 사용 가능
  - onCreateView에서 전달받은 inflater로 뷰바인딩 inflate
- 액티비티에서 초기 데이터 전달받을 때는 번들 객체 이용이 추천됨
- getActivity로 activity 가져와 처리 가능

## 액티비티의 역할

- 각 프래그먼트를 교체, 관리
- 프래그먼트가 사용할 데이터를 관리

## 리스트 프래그먼트

- 프래그먼트에 리스트뷰 표시할 경우 편리하게 구성할 수 있는 프래그먼트
- ListFragment 상속 필요 -> setListAdapter, onListItemClick 메소드 사용
- 리스트뷰의 id가 @android:id/list로 설정되어 있을 경우 자동으로 관리

## 다이얼로그 프래그먼트

- AlertDialog를 프래그먼트로 만들어 사용할 수 있도록 제공되는 프래그먼트
- DialogFragment 상속 필요
  - onCreateDialog에서 AlertDialog 생성하여 반환
- 프래그먼트의 생명 주기와 기능을 그대로 활용 가능

## 프래그먼트 애니메이션

- 프래그먼트 전환될 때 애니메이션 설정 가능
- 프래그먼트 교체 전 애니메이션 설정 필요
- FragmentTransaction의 setTransition 메소드로 애니메이션 설정
  - FADE, OPEN, CLOSE를 기본 제공
- xml 파일로 커스텀 가능
  - xml 파일은 set 내부에 objectAnimator 넣어 정의
  - setCustomAnimations 메소드 이용
- 들어올 때(enter)와 나갈 때(exit), 백 스택에서 나와서 들어올 때(popEnter)와 나갈 때(popExit) 애니메이션 정의

## 액티비티 애니메이션

- 액티비티도 프래그먼트처럼 애니메이션 정의 가능(기본적으로 애니메이션 적용되어 있음)
- overridePendingTransition 메소드 이용
- 나타날 때(인텐트로 startActivity)와 사라질 때(onBackPressed 또는 finish) 애니메이션 정의
- xml 파일로 커스텀 가능
  - 프래그먼트와 달리 alpha, rotate, scale, translate 사용

