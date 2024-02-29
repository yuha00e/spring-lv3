 UCD

![제목 없는 다이어그램-페이지-2](https://github.com/yuha00e/spring-lv3/assets/157681548/1a40c37c-d09a-4d16-91b1-e07550041783)

 API 명세서

| **기능** | **Method** | **URL** | **Request** | **Response** |
| --- | --- | --- | --- | --- |
| 관리자 가입 | POST | /api/user | {"email": email, "password":password, "department":department, "authority":authority } |  |
| 로그인 | GET | /api/user | {"email":email, "password": password} |  |
| 강사 등록 | POST | /api/teacher | {"name":name, "career":career, "company":company, "phone":phone, "introduction": introduction } | {"name":name, "career":career, "company":company, "phone":phone, "introduction": introduction } |
| 선택한 강사 정보 수정 | PUT | /api/teacherinfo/{teacherId} | {"career":career, "company":company, "phone":phone, "introduction": introduction } | {"career":career, "company":company, "phone":phone, "introduction": introduction } |
| 강의 등록 | POST | /api/class | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category, "teacher":teacher, "registrationDate":registrationDate} | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category, "teacher":teacher, "registrationDate":registrationDate} |
| 선택한 강의 정보 수정 | PUT | /api/classinfo/{classId} | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category} | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category} |
| 선택한 강사 조회 | GET | /api/teacher/{teacherId} |  | {"name":name, "career":career, "company":company, "phone":phone, "introduction": introduction } |
| 선택한 강의 조회 | GET | /api/class/{classId} |  | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category, "teacher":teacher, "registrationDate":registrationDate} |
| 선택한 강사가 촬영한 강의 목록 조회 | GET | /api/class/{teacherId}/{classId} |  | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category, "teacher":teacher, "registrationDate":registrationDate} |
| 카테고리별 강의 목록 조회 | GET | /api/class/{category} |  | {"lecture_name":lecture_name, "price":price, "introduction":introduction, "category":category, "teacher":teacher, "registrationDate":registrationDate} |

ERD

