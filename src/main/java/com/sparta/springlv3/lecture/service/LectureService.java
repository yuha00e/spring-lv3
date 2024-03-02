package com.sparta.springlv3.lecture.service;


import com.sparta.springlv3.lecture.dto.LectureRequestDto;
import com.sparta.springlv3.lecture.dto.LectureResponseDto;
import com.sparta.springlv3.lecture.entity.CategoryEnum;
import com.sparta.springlv3.lecture.entity.Lecture;
import com.sparta.springlv3.lecture.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    // 강의 등록 기능

    public LectureResponseDto createLecture(LectureRequestDto lectureRequestDto) {
        // RequestDto -> Entity
        Lecture lecture = new Lecture(lectureRequestDto);

        // DB에 저장
        Lecture saveLecture = lectureRepository.save(lecture);

        // Entity -> ResponseDto
        LectureResponseDto lectureResponseDto = new LectureResponseDto(saveLecture);

        return lectureResponseDto;
    }


    // 선택한 강의 정보 수정
    public LectureResponseDto infoLecture(Long lectureId, LectureRequestDto lectureRequestDto) {

        // 선택한 강의 정보 조회
        Lecture lecture = findLecture(lectureId);

        // 강의 정보 수정
        lecture.setLectureName(lectureRequestDto.getLectureName());
        lecture.setPrice(lectureRequestDto.getPrice());
        lecture.setIntroduction(lectureRequestDto.getIntroduction());
        lecture.setCategory(CategoryEnum.valueOf(lectureRequestDto.getCategory())); // 카테고리 수정
        lecture.setRegistrationDate(lectureRequestDto.getRegistrationDate()); // 등록일 수정
        lecture.setTeacher(lectureRequestDto.getTeacher()); // 강사 수정

        // 변경된 강의 정보 DB에 저장
        lecture = lectureRepository.save(lecture);

        return new LectureResponseDto(lecture);
    }


    // 강의 조회 메서드
    private Lecture findLecture(Long lectureId) {
        return lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("해당 강의는 존재하지 않습니다."));
    }


    // 선택한 강의 조회
    public LectureResponseDto updateLecture(Long lectureId) {

        // 선택 강의가 lecture DB에 존재하는지 확인
        Lecture lecture = findLecture(lectureId);

        return new LectureResponseDto(lecture);
    }


    // 카테고리별 강의 목록 조회 기능
    public List<LectureResponseDto> findLecturesByCategory(CategoryEnum category) {
        List<Lecture> lectures = lectureRepository.findByCategory(category);
        List<LectureResponseDto> lectureResponseDtos = new ArrayList<>();
        for (Lecture lecture : lectures) {
            lectureResponseDtos.add(new LectureResponseDto(lecture));
        }
        return lectureResponseDtos;
    }

}

