package com.sparta.springlv3.dto;

import com.sparta.springlv3.entity.Lecture;
import lombok.Getter;

import java.security.Timestamp;

@Getter
public class LectureResponseDto {
    private String lecture_name; //강의명
    private Long price; //가격
    private String introduction; //소개
    private String category; //카테고리
    private Timestamp registrationDate; // 타입 임시 지정 //등록일
    private String teacher; //강사이름

    public LectureResponseDto(Lecture lecture) {
        this.lecture_name = lecture.getLecture_name();
        this.price = lecture.getPrice();
        this.introduction = lecture.getIntroduction();
        this.category = lecture.getCategory();
        this.registrationDate = lecture.getRegistrationDate();
        this.teacher = lecture.getTeacher();
    }
}
