package com.sparta.springlv3.lecture.dto;

import com.sparta.springlv3.lecture.entity.CategoryEnum;
import com.sparta.springlv3.lecture.entity.Lecture;
import com.sparta.springlv3.teacher.entity.Teacher;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LectureResponseDto {
    private String lectureName; //강의명
    private Long price; //가격
    private String introL; //소개
    private CategoryEnum category; // 카테고리
    private LocalDate registrationDate;
    private Teacher teacher; //강사이름

    public LectureResponseDto(Lecture lecture) {
        this.lectureName = lecture.getLectureName();
        this.price = lecture.getPrice();
        this.introL = lecture.getIntroL();
        this.category = lecture.getCategory();
        this.registrationDate = lecture.getRegistrationDate();
        this.teacher = lecture.getTeacher();
    }
}
