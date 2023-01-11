# 메시징

- 토스트: 일정 시간 동안 표시되는 메시지
- 다이얼로그: 액티비티 위에 나타나는 메시지
- 알림: 알림 창에 표시되는 메시지

## 토스트

- 간단한 메시지 표시
- 화면과 관련 없이 운영체제에 메시지 출력을 요청하면 나타나는 메시지
- 모든 구성요소가 요청 가능하며 요청한 순서대로 메시지가 노출됨

### 주요 메소드

- makeText: 토스트 메시지 객체 생성 (모양, 글자 크기, 색상 등은 기본 설정 사용)
- setGravity: 표시될 위치 설정
- setView: 메시지에서 보여줄 뷰 설정(커스텀 가능)
- setDuration: 메시지가 표시될 시간 설정

### Callback

- API 30(Android 11)부터 토스트에 콜백 설정 가능(@RequireApi(30) 어노테이션 사용 및 분기 필요)
- onToastHidden, onToastShown

## 스낵바

- 액티비티 위에 표시되며 하단에 나타나는 메시지
- 토스트와 달리 상호작용 가능한 버튼 추가 가능

### 주요 메소드

- SnackBar.make 메소드로 SnackBar 생성, show로 표시
- setTextColor, setBackgroundTint, setAnimationMode, setAction

### Callback

- BaseTransientBottomBar.BaseCallback\<Snackbar\> 상속 받아 구현
- onShown, onDismissed

### 커스터마이징

- 새로운 뷰를 설정하는 별도 메소드 없음
- 레이아웃(SnackbarLayout)을 추출하여 뷰를 추가 가능
- 원래 있는 텍스트뷰는 안보이게 설정(layout.findViewById(com.google.material.R.id.snackbar_text))

## 다이얼로그

- 사용자에게 메시지 전달 및 입력 용도
- 주변 뷰(기존 화면) 사용 불가

### 일반 다이얼로그

- 아이콘, 제목, 메시지, 3개의 버튼(Positive, Neutral, Negative) 제공

### 커스텀 다이얼로그

- 다이얼로그에 뷰를 설정하여 새롭게 구성 가능
- builder에서 setView로 지정 가능

### 선택 다이얼로그

- DatePicker: 날짜 선택 다이얼로그, onDateSetListener로 날짜 선택 처리
- TimePicker: 시간 선택 다이얼로그, onTimeSetListener로 시간 선택 처리

### 리스트 다이얼로그

- 리스트뷰를 다이얼로그에 표시
- builder에서 setItems로 배열 전달해 표시
- DialogInterface의 OnClickListener의 onClick 메소드에서 선택한 항목의 인덱스 알 수 있음
- 커스텀 리스트 다이얼로그의 경우 SimpleAdapter 생성하여 builder의 setAdapter로 설정

### 단일 선택 다이얼로그

- 라디오 버튼 형태로 제공
- builder의 setSingleChoiceItems로 배열, 기본값, 리스너 전달해 생성
- AlertDialog에서 ListView 추출하여 getCheckedItemPosition 메소드로 선택한 항목 파악
- 라디오 버튼 선택시에는 setSingleChoiceItem으로 설정된 리스너가, 확인 버튼을 선택시에는 setButton으로 설정된 리스너가 동작

### 다중 선택 다이얼로그

- 체크 박스 형태로 제공
- builder의 setMultiChoiceItems로 배열, 선택 상태, 리스너 전달해 생성
- AlertDialog에서 ListView 추출하여 getCheckedItemPositions 메소드로 변경된 항목 파악
  -> 선택 여부 직접 확인 필요
- 체크 박스 선택시 처리에서는 리스너로 OnMultiChoiceClickListener가 별도 존재

## 알림(Notification)

- 어플리케이션과 별도 관리되는 메시지
- 운영체제에 요청하면 알림창 영역에 알림 메시지 표시
- 화면이 없는 실행 단위에서 메시지를 표시
- 사용자가 메시지 확인하여 제거하기 전까지 유지됨
- 메시지를 통해 지정 액티비티 실행 등 어플리케이션과 상호작용 유도 가능

### 알림 채널

- API 26(Android 8)부터 지원
- 알림 메시지를 채널 단위 그룹으로 묶어 관리
- 사용자는 채널 별로 메시지 활성화 여부 설정 가능
- 내부적으로 채널을 관리할 이름(id)과 실제 사용자에게 표시될 이름을 별도 관리
- id를 이용하여 채널이 있는지 확인(getNotificationChannel)하고 없다면 새로 생성(createNotificationChannel)
- notificationBuilder 이용하여 제목, 내용, 아이콘 설정
- manager.notify에서 알림 id를 구분하여 전달 -> 알림 id별로 하나의 알림만 표시(이전 알림이 갱신됨)

### Pending Intent

- 알림을 통해 어플리케이션의 액티비티를 실행할 수 있게 함
- 실행되는 액티비티로 데이터 전달 가능
- PendingIntent.getActivity로 객체 생성(context, requestCode, intent, flag 전달)
- flag는 IMMUTABLE과 MUTABLE 반드시 명시해야

### Action

- 알림에 버튼 배치하여 특정 동작 실행
- 하나의 메시지에서 여러 액티비티 중 선택적으로 실행 가능
- Action.Builder를 통해 action 생성하여 알림 빌더에 액션 추가(addAction)
- 실행시 알림 없애려면 실행한 액티비티에서 manager.cancel(id)로 제거

### 스타일

- Big Picture Style
- Big Text Style
- InBox Style
- 각 스타일 객체 생성할 때 알림 빌더를 전달
- 스타일 객체로 생성한 내용은 알림을 확장했을 때 나타남

### 메시지 알림

- MessagingStyle
- API 28(Android 9)부터 지원
- 여러 사람 간의 메시지 표시하는 용도로 사용
- 알림 빌더의 setStyle로 지정