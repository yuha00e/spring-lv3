package com.sparta.springlv3.service;


import com.sparta.springlv3.dto.TeacherRequestDto;
import com.sparta.springlv3.dto.TeacherResponseDto;
import com.sparta.springlv3.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;


    // 강사 등록 기능
    public TeacherResponseDto createTeacher(TeacherRequestDto teacherRequestDto) {
        return null;
    }

    //    강사 등록 기능
//    - `이름`, `경력(년차)`, `회사`, `전화번호`, `소개`를 저장할 수 있습니다.
//            - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
//            - 관리자만 강사 등록이 가능합니다.
//            - 등록된 강사의 정보를 반환 받아 확인할 수 있습니다.

    // 선택한 강사 정보 수정
    public TeacherResponseDto infoTeacher(TeacherRequestDto teacherRequestDto) {
        return null;
    }

    //        선택한 강사 정보 수정 기능
//    - 선택한 강사의 `경력`, `회사`, `전화번호`, `소개`를 수정할 수 있습니다.
//            - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
//            - MANAGER  권한을 가진 관리자만 강사 정보 수정이 가능합니다.
//            - 수정된 강사의 정보를 반환 받아 확인할 수 있습니다.

    // 선택한 강사 조회
    public TeacherResponseDto updateTeacher(Long teacherId) {
        return null;
    }

    //    선택한 강사 조회 기능
//    - 선택한 강사의 정보를 조회할 수 있습니다.
//            - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
//            - 관리자만 강사 조회가 가능합니다.
//

    // 선택한 강사가 촬영한 강의 목록 조회
    public TeacherResponseDto findTeacher(Long teacherId, Long lectureId) {
        return null;
    }

    //           선택한 강사가 촬영한 강의 목록 조회 기능
//    - 선택한 강사가 촬영한 강의를 조회할 수 있습니다.
//        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
//            - 관리자만 강의 조회가 가능합니다.
//            - 조회된 강의 목록은 `등록일` 기준 내림차순으로 정렬 되어있습니다.

}
