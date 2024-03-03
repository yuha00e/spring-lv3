package com.sparta.springlv3.teacher.service;


import com.sparta.springlv3.lecture.entity.Lecture;
import com.sparta.springlv3.lecture.repository.LectureRepository;
import com.sparta.springlv3.teacher.dto.TeacherRequestDto;
import com.sparta.springlv3.teacher.dto.TeacherResponseDto;
import com.sparta.springlv3.teacher.entity.Teacher;
import com.sparta.springlv3.teacher.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final LectureRepository lectureRepository;


    // 강사 등록 기능
    public TeacherResponseDto createTeacher(TeacherRequestDto teacherRequestDto) {

        // RequestDto -> Entity
        Teacher teacher = new Teacher(teacherRequestDto);

        // DB에 저장
        Teacher saveTeacher = teacherRepository.save(teacher);

        // Entity -> ResponseDto
        TeacherResponseDto teacherResponseDto = new TeacherResponseDto(saveTeacher);

        return teacherResponseDto;
    }

    // 선택한 강사 정보 수정
    public TeacherResponseDto infoTeacher(Long teacherId, TeacherRequestDto teacherRequestDto) {

        // 선택한 강사 정보 조회
        Teacher teacher = findTeacher(teacherId);

        // 강사 정보 수정
        teacher.setCareer(teacherRequestDto.getCareer());
        teacher.setCompany(teacherRequestDto.getCompany());
        teacher.setPhone(teacherRequestDto.getPhone());
        teacher.setIntroduction(teacherRequestDto.getIntroduction());

        // 변경된 강사 정보를 DB에 저장
        teacher = teacherRepository.save(teacher);

        return new TeacherResponseDto(teacher);
    }

    // 선택한 강사 조회
    public TeacherResponseDto updateTeacher(Long teacherId) {

        // 선택한 강사가 teacher DB에 존재하는지 확인
        Teacher teacher = findTeacher(teacherId);

        return new TeacherResponseDto(teacher);
    }


    // 선택한 강사가 촬영한 강의 목록 조회
    public List<TeacherResponseDto> findTeacherLecture(Long teacherId) {

//        ------------------- 첫번째 방법 --------------------------------

//        + teacher entity @one to many 메소드 / + DB 연결하기
//        // 강사 조회
//        Teacher teacher = findTeacher(teacherId);
//
//        // 강사의 강의 목록 가져오기
//        List<Lecture> teacherLectures = teacher.getLectures();
//
//        // 강의 목록을 등록일 기준으로 내림차순 정렬
//        Collections.sort(teacherLectures, Comparator.comparing(Lecture::getCreatedAt).reversed());
//
//        // 조회된 강의 목록을 DTO 형식으로 변환하여 반환합니다.
//        return teacherLectures.stream()
//                .map(TeacherResponseDto::new) // 각 요소에 대해 객체 생성하는것. lecture 연결 후 생성자 고쳐보기
//                .collect(Collectors.toList());

//        -------------------------- 두번째 방법 ---------------------------

//          + lecture repository에 쿼리문 넣기
//        @Query("SELECT l FROM Lecture l WHERE l.teacher.id = :teacherId ORDER BY l.createdAt DESC")
//        List<Lecture> findLecturesByTeacherIdOrderByCreatedAtDesc(Long teacherId);

        // Repository에서 JPQL 쿼리를 호출하여 선택한 강사가 촬영한 강의 목록을 조회합니다.
        List<Lecture> teacherLectures = lectureRepository.findLecturesByTeacherIdOrderByRegistrationDateDesc(teacherId);

        // 조회된 강의 목록을 DTO 형식으로 변환하여 반환합니다.
        return teacherLectures.stream()
                .map(TeacherResponseDto::new)
                .collect(Collectors.toList());

    }

    // 강사 조회 메서드
    private Teacher findTeacher(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalArgumentException("해당 강사는 존재하지 않습니다."));
    }

}
