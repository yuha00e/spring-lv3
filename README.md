 UCD

![제목 없는 다이어그램-페이지-2](https://github.com/yuha00e/spring-lv3/assets/157681548/1a40c37c-d09a-4d16-91b1-e07550041783)

 API 명세서

| **기능** | **Method** | **URL** | **Request** | **Response** |
| --- | --- | --- | --- | --- |
| 관리자 가입 | POST | /api/user | {"email": email, "password":password, "department":department, "authority":authority } |  |
| 로그인 | GET | /api/user | {"email":email, "password": password} |  |
| 강사 등록 | POST | /api/teacher | {"teacher_name":teacher_name, "career":career, "company":company, "phone":phone, "introduction": introduction } | {"teacher_name":teacher_name, "career":career, "company":company, "phone":phone, "introduction": introduction } |
| 선택한 강사 정보 수정 | PUT | /api/teacherinfo/{teacherId} | {"career":career, "company":company, "phone":phone, "introduction": introduction } | {"career":career, "company":company, "phone":phone, "introduction": introduction } |
| 강의 등록 | POST | /api/ lecture | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category, "teacher":teacher, "registrationDate":registrationDate} | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category, "teacher":teacher, "registrationDate":registrationDate} |
| 선택한 강의 정보 수정 | PUT | /api/ lectureinfo/{ lectureId} | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category} | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category} |
| 선택한 강사 조회 | GET | /api/teacher/{teacherId} |  | {"teacher_name":teacher_name, "career":career, "company":company, "phone":phone, "introduction": introduction } |
| 선택한 강의 조회 | GET | /api/ lecture/{ lectureId} |  | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category, "teacher":teacher, "registrationDate":registrationDate} |
| 선택한 강사가 촬영한 강의 목록 조회 | GET | /api/ lecture/{teacherId}/{ lectureId} |  | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category, "teacher":teacher, "registrationDate":registrationDate} |
| 카테고리별 강의 목록 조회 | GET | /api/ lecture/{category} |  | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category, "teacher":teacher, "registrationDate":registrationDate} |


ERD

<img width="704" alt="스크린샷 2024-02-29 오후 6 36 01" src="https://github.com/yuha00e/spring-lv3/assets/157681548/00c3feea-7326-4aad-8cb5-1079ab66976a">
