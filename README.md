Spring Lv.3 "스파르타 백오피스(Admin) 서버 만들기"
-----

🐥필수 구현 기능
-----

- [ ]  관리자 가입 기능
    - `이메일`, `비밀번호`, `부서`, `권한`을 저장할 수 있습니다.
        - 커리큘럼, 마케팅, 개발 `부서`가 있습니다.
        - MANAGER, STAFF `권한`이 있습니다.
            - 커리큘럼, 개발 `부서`만 MANAGER 권한을 부여 받을 수 있습니다.
        - `이메일`은  `올바른 이메일 형식`을 지켜야 합니다.
        - `비밀번호`는  `최소 8자 이상, 15자 이하이며 알파벳 대소문자(a~z, A~Z), 숫자(0~9), 특수문자`로 구성되어야 합니다.
    - 관리자가입 성공을 확인할 수 있는 값을 반환합니다.
        - ex) HTTP Status Code, Error Message …
        
- [ ]  로그인 기능
    - 관리자는 `이메일`, `비밀번호`를 입력하여 서버에 로그인을 요청할 수 있습니다.
    - 로그인 성공 시, `회원의 정보`와 `JWT`를 활용하여 토큰을 발급하고,
    발급한 토큰을 Header에 추가한 후 로그인 성공을 확인할 수 있는 값과 함께 반환합니다.
        - ex) HTTP Status Code, Error Message …
- [ ]  강사 등록 기능
    - `이름`, `경력(년차)`, `회사`, `전화번호`, `소개`를 저장할 수 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - 관리자만 강사 등록이 가능합니다.
    - 등록된 강사의 정보를 반환 받아 확인할 수 있습니다.
- [ ]  선택한 강사 정보 수정 기능
    - 선택한 강사의 `경력`, `회사`, `전화번호`, `소개`를 수정할 수 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - MANAGER  권한을 가진 관리자만 강사 정보 수정이 가능합니다.
    - 수정된 강사의 정보를 반환 받아 확인할 수 있습니다.
- [ ]  강의 등록 기능
    - `강의명`, `가격`, `소개`, `카테고리`, `강사`, `등록일`을 저장할 수 있습니다.
        - Spring, React, Node `카테고리`가 있습니다.
        - 강사 한 명이 여러 개의 강의를 촬영할 수도 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - 관리자만 강의 등록이 가능합니다.
    - 등록된 강의의 정보를 반환 받아 확인할 수 있습니다.
- [ ]  선택한 강의 정보 수정 기능
    - 선택한 강의의 `강의명`, `가격`, `소개`, `카테고리`를 수정할 수 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - MANAGER  권한을 가진 관리자만 강의 정보 수정이 가능합니다.
    - 수정된 강의의 정보를 반환 받아 확인할 수 있습니다.
- [ ]  선택한 강사 조회 기능
    - 선택한 강사의 정보를 조회할 수 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - 관리자만 강사 조회가 가능합니다.
- [ ]  선택한 강의 조회 기능
    - 선택한 강의의 정보를 조회할 수 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - 관리자만 강의 조회가 가능합니다.
- [ ]  선택한 강사가 촬영한 강의 목록 조회 기능
    - 선택한 강사가 촬영한 강의를 조회할 수 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - 관리자만 강의 조회가 가능합니다.
    - 조회된 강의 목록은 `등록일` 기준 내림차순으로 정렬 되어있습니다.
- [ ]  카테고리별 강의 목록 조회 기능
    - 선택한 카테고리에 포함된 강의를 조회할 수 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - 관리자만 강의 조회가 가능합니다.
    - 조회된 강의 목록은 `등록일` 기준 내림차순으로 정렬 되어있습니다.
- [ ]  공통 기능
    - 로그인 요청의 비밀번호 불일치 등 API 요청의 예외가 발생하는 모든 경우에 대해서 실패(예외상황)에 대해 판단할 수 있는 Status Code, Error 메시지등의 정보를 반환합니다.
     
 🐥추가 구현 기능
-----
- [ ]  선택한 강의 삭제 기능
    - 선택한 강의를 삭제할 수 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - MANAGER  권한을 가진 관리자만 강의 삭제가 가능합니다.
- [ ]  선택한 강사 삭제 기능
    - 선택한 강사를 삭제할 수 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - MANAGER  권한을 가진 관리자만 강사 삭제가 가능합니다.
- [ ]  Spring Security를 적용하여 인증/인가를 구현합니다.
    - Security의 Secured 기능을 사용하여 권한별로 API를 제어할 수 있습니다.
- [ ]  swagger를 구글링해 보고 프로젝트에 적용해 보세요!
    - swagger란? Open Api Specification(OAS)를 위한 프레임워크 입니다.
        - API들이 가지고 있는 스펙(spec)을 명세, 관리할 수 있으며 백엔드와 프론트엔드가 협업할 때 사용할 수 있습니다!
     
          
 Commit Convention
 -----
 
 ![스크린샷 2024-03-01 오후 3 20 00](https://github.com/yuha00e/spring-lv3/assets/157681548/1fecc129-c6c1-4611-8630-6443d1ff7caa)
 
 etc : 그 외 메모사항이 있는 경우

 그라운드 룰
 -----

✅ 오전 10시에 매일 게더에서 프로젝트를 시작한다.

✅ 서로 예쁜말을 사용하고 배려하며 소통한다.

✅ 개인적인 일정이 있을 때 팀원들과 무조건 공유한다.

✅ 게더에서 많이, 그리고 자주 소통한다.

 
 UCD
 -----

![제목 없는 다이어그램-페이지-2](https://github.com/yuha00e/spring-lv3/assets/157681548/1a40c37c-d09a-4d16-91b1-e07550041783)

 
 API 명세서
 -----

| **기능** | **Method** | **URL** | **Request** | **Response** |
| --- | --- | --- | --- | --- |
| 관리자 가입 | POST | /api/user | {"email": email, "password":password, "department":department, "authority":authority } |  |
| 로그인 | GET | /api/user | {"email":email, "password": password} |  |
| 강사 등록 | POST | /api/teacher | {"teacher_name":teacher_name, "career":career, "company":company, "phone":phone, "introduction": introduction } | {"teacher_name":teacher_name, "career":career, "company":company, "phone":phone, "introduction": introduction } |
| 선택한 강사 정보 수정 | PUT | /api/teacherinfo/{teacherId} | {"career":career, "company":company, "phone":phone, "introduction": introduction } | {"career":career, "company":company, "phone":phone, "introduction": introduction } |
| 강의 등록 | POST | /api/lecture | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category, "teacher":teacher, "registrationDate":registrationDate} | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category, "teacher":teacher, "registrationDate":registrationDate} |
| 선택한 강의 정보 수정 | PUT | /api/lectureinfo/{lectureId} | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category} | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category} |
| 선택한 강사 조회 | GET | /api/teacher/{teacherId} |  | {"teacher_name":teacher_name, "career":career, "company":company, "phone":phone, "introduction": introduction } |
| 선택한 강의 조회 | GET | /api/lecture/{ lectureId} |  | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category, "teacher":teacher, "registrationDate":registrationDate} |
| 선택한 강사가 촬영한 강의 목록 조회 | GET | /api/lecture/{teacherId}/{ lectureId} |  | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category, "teacher":teacher, "registrationDate":registrationDate} |
| 카테고리별 강의 목록 조회 | GET | /api/lecture/{category} |  | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category, "teacher":teacher, "registrationDate":registrationDate} |


ERD
-----

<img width="704" alt="스크린샷 2024-02-29 오후 6 36 01" src="https://github.com/yuha00e/spring-lv3/assets/157681548/00c3feea-7326-4aad-8cb5-1079ab66976a">
