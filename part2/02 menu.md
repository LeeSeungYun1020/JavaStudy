# 안드로이드의 메뉴

## 권한

- 개인 정보, 네트워크, 센서, 카메라, 저장소 등 관련 기능 사용을 위해 권한 등록 필요
- 권한 관련 내용은 어플리케이션 정보에서 확인 가능
- 사용자에게 어떤 기능을 사용하는지 알려주는 목적
- 권한을 등록하지 않고 기능을 사용하려하면 오류 발생
- 권한 사용에 사용자에게 고지하고 이를 승인 받는 작업 필요
- 사용 허가가 필요 없는 권한은 권한 선언 후 그냥 사용 가능
- requestPermissions()로 권한 요청
- onRequestPermissionsResult()로 권한 확인 후 처리
- 요청 확인이 끝난 후 특정 권한만 처리하도록 할 때
  - ActivityResultCallback\<Map\<String, Boolean\>\>을 구현하여 동작할 콜백 처리
  - ActivityResultLauncher<String[]> 타입의 권한 확인 창을 띄우는 요소 선언
  - ActivityResultContracts.RequestMultiplePermissions 타입의 권한 확인 용도로 지정하기 위한 객체를 생성
  - registerForActivityResult로 RequestMultiplePermissions와 callback 전달하여 런처 생성
  - 런처의 launch 메소드 호출하여 특정 권한만 확인하도록 구현

## Option Menu

- 액티비티당 하나씩 가질 수 있는 메뉴(화면의 메인 메뉴 용도)
- onCreateOptionsMenu
  - 액티비티 생성시 자동 호출되어 메뉴 생성
  - MenuInflater로 xml 파일 inflate하거나 코드 상으로 menu에 add하여 추가
  - true 반환시 메뉴 생성
- onOptionsItemSelected
  - 사용자가 메뉴 선택시 자동으로 호출되는 메소드

## Context Menu

- 화면에 배치된 뷰에 설정할 수 있는 메뉴
- 뷰를 길게 누르면 설정된 메뉴가 표시
- registerForContext
  - context menu 등록하는 메소드(onCreateContextMenu 메소드 호출되도록 함)
  - 매개변수로 넣어준 view 객체에 메뉴가 설정됨
- onCreatContextMenu
  - view를 길게 누르면 호출되는 메소드, 메뉴 구성
  - view의 id별로 구분하여 메뉴 생성 필요
  - 여러 항목이 있는 뷰(리스트뷰, 리사이클러뷰)의 경우 ContextMenuInfo를 통해 위치 파악
- onContextItemSelected
  - 컨텍스트 메뉴 선택시 호출되는 메소드
  - 어떤 뷰에서 파생된 컨텍스트 메뉴인지 확인 불가하므로 각각의 메뉴 id를 중복 없이 등록해야
  - 여러 항목이 있는 뷰인 경우, MenuItem에서 MenuInfo 얻어와 누른 위치 파악 가능
- 여러 항목이 있는 뷰의 경우 상황별 작업 모드를 사용하는 것을 고려
  - ActionMode.Callback 인터페이스 구현
  - longClickListener 등에서 startActionMode 호출
  - ListView, GridView에서는 choiceMode를 MULTIPLE_MODAL로 변경하고 MultiChoiceModeListener 장착

## Popup Menu

- 개발자가 원하는 곳에 띄울 수 있는 메뉴
- PopupMenu
  - 객체 생성 - context와 팝업 띄울 뷰 전달
  - MenuItemClickListener 부착해서 클릭 이벤트 처리
  - show()로 표시
- getMenu: 메뉴를 관리하는 객체 반환 -> MenuInflater 또는 코드로 메뉴 구성
- OnMenuItemClickListener: 메뉴 항목을 눌렀을 경우 반응하는 리스너
