# Activity

## Activity

### 안드로이드 4대 구성요소

- 안드로이드 어플리케이션은 독립적인 다양한 실행 단위를 하나로 묶어 관리하는 개념 사용
- Activity: 화면 관리, UI
- Service: 백그라운드 작업, UI 없음
- Broadcast Receiver: 특정 시스템 이벤트 수신
- Content Provider: 다른 앱과 데이터 공유

### Activity

- 사용자에 보이는 화면을 관리하는 실행 단위
- 어플리케이션 실행시 일반적으로는 액티비티가 실행되고 액티비티가 관리하는 화면이 표시됨

### Activity 생명주기

- onCreate - 생성됨
    - 전체 수명 주기 동안 한 번만 발생해야 하는 기본 어플리케이션 시작 로직 실행
    - instance state 복구
- onStart - 시작됨
    - 액티비티가 사용자에 표시, 포그라운드에서 사용자와 상호작용 준비
    - 앱이 UI 관리하는 코드 초기화
- onResume - 재개됨
    - 사용자와 상호작용
    - 포그라운드에서 실행할 모든 기능 활성화 가능
    - 방해 이벤트(전화, 다른 액티비티로 이동, 화면 꺼짐) 발생시 일시중지됨 상태로 변환
- (running)
- onPause - 일시중지됨
    - 액티비티가 포그라운드에 있지 않게 됨(멀티 윈도우 모드에서는 표시될 수 있음)
    - 액티비티가 포커스를 잃음(방해 이벤트, 반투명 활동(대화상자)이 열림, 멀티 윈도우 모드에서 다른 앱이 포커스 가짐)
    - 배터리 수명에 영향을 미치는 시스템 리소스, 센서 핸들 등 해제
    - UI 관련 리소스 및 작업 해제 및 조정은 onStop에서 처리해야(멀티 윈도우 모드 대응)
    - 아주 잠깐 실행되므로 사용자 데이터 저장, 네트워크 호출, 데이터베이스 트랜잭션 실행해서는 안 됨
- onStop - 중단됨
    - 액티비티가 사용자에게 더 이상 표시되지 않음(새로 시작된 액티비티가 화면 전체를 차지)
    - 화면에 보이지 않을 때 실행할 필요가 없는 기능 모두 정지(리소스 해제 및 조정)
    - CPU를 비교적 많이 소모하는 종료 작업 실행(데이터베이스 저장)
    - 액티비티 객체는 메모리에 머무르게 되며 View 객체의 현재 상태 기록
    - 다시 시작될 경우 onRestart 호출
- onDestroy - 소멸됨
    - 활동이 종료(닫거나 finish 호출)되거나 구성 변경(기기 회전, 멀티 윈도우 모드)으로 인해 일시적으로 소멸시키는 경우
    - 뷰모델 객체를 사용하여 액티비티 관련 뷰 데이터를 포함하여 구성 변경시 추가 작업 제거
    - 아직 해제되지 않은 모든 리소스 해제

### Logcat으로 로그 출력

- d: debug 디버그
- e: error 오류
- i: info 정보
- v: verbose 상세
- w: warning 경고

## Activity 실행

### Intent

- 안드로이드 구성요소 실행을 위해 Intent가 필요
- Intent는 실행하려는 구성요소와 관련된 정보 포함
- OS에 intent 전달하여 해당 구성요소 실행
- 생성된 구성요소에 intent 전달되어 데이터 전달 가능

### 실행과 종료

- startActivity: 인텐트 정보를 토대로 액티비티 실행
- finish: 현재 실행되어 있는 액티비티 종료

### Back Stack

- 다른 액티비티 실행시 이전 액티비티는 백 스택에 담겨 정지 상태가 되고 새로 생성된 액티비티가 활동
- 새로 실행된 액티비티가 종료되면 백 스택에 있던 액티비티가 다시 활동

## onResultActivity

### startActivityForResult와 onActivityResult

- 액티비티에서 다른 액티비티 실행 후 돌아왔을 때, 처리가 필요한 경우 사용
- startActivityForResult로 액티비티 실행 후 돌아오면 onActivityResult 호출
- 실행된 액티비티는 requestCode로 구분
- 결과는 setResult로 지정, resultCode로 구분

### registerForActivityResult

- startActivityForResult, onActivityResult 대신 사용이 권장
- contracts와 callback 정의하여 registerForActivityResult 호출하여 ActivityResultLauncher를 얻어 launch()
- 다수의 액티비티 실행을 분리해 관리할 수 있음

## 데이터 전달

### 인텐트에 데이터 저장

- 액티비티 실행 전 인텐트 객체에 데이터 저장 가능
- putExtra 메소드 이용, 실행되는 액티비티로 전달
- 액티비티 종료 시에도 인텐트 전달 가능

### 인텐트에서 데이터 가져오기

- 새로 실행된 액티비티에서 인텐트에 저장된 데이터 추출
- get-Extra 메소드 이용(자료형별 메소드 사용)

## 객체 전달

### Parcelable

- 인텐트를 통해 객체 전달할 때 직렬화가 필요 -> Parcelable 인터페이스 사용
- 객체를 추출하여 Parcel에 담아 전달되고 객체를 복원
- writeToParcel: Parcel 객체에 기본 타입 저장, 이 Parcel 객체가 intent에 담겨 다른 액티비티로 전달
- describeContents: 파일 descriptor 표현 여부 전달
- CREATOR
    - createFromParcel: Parcel 객체를 인자로 받는 생성자 호출, getParcelableExtra 메소드 사용시 내부적으로 호출
    - newArray: 객체의 새로운 배열 반환
- Parcel 객체를 인자로 받는 생성자: Parcel 객체에서 값 복원하여 초기화

## 타 어플리케이션의 액티비티 실행

### Intent Filter

- 안드로이드의 구성요소는 모두 AndroidManifest.xml에 등록
- Intent filter로 이름을 설정하여 다른 어플리케이션이 실행 가능하도록 할 수 있음
- OS는 지정된 intent filter의 이름을 확인하여 정리하고 실행 요청을 받으면 실행
- 같은 이름의 액티비티가 여러개 있는 경우 선택기가 표시됨

## Activity Action

- 안드로이드에서 기본적으로 제공되는 어플리케이션 중 다른 어플리케이션이 사용할 수 있도록 액티비티를 제공하는 경우가 있음
- 해당 액티비티는 공개된 이름이 제공되며 이름을 통해 실행 가능
- 다이얼, 전화 걸기, 브라우저, 지도 등의 작업 가능