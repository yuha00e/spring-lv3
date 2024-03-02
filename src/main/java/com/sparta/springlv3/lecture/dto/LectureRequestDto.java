package com.sparta.springlv3.lecture.dto;

import com.sparta.springlv3.teacher.entity.Teacher;
import lombok.Getter;

import java.security.Timestamp;

@Getter
public class LectureRequestDto {
    private String lectureName; //강의명
    private Long price; //가격
    private String introduction; //소개
    private String category; //카테고리
    private Timestamp registrationDate; // 타입 임시 지정 //등록일
    private Teacher teacher; //강사이름


}
