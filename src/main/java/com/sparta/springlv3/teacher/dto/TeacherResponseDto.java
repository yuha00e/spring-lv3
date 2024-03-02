package com.sparta.springlv3.teacher.dto;

import com.sparta.springlv3.teacher.entity.Teacher;
import lombok.Getter;

@Getter
public class TeacherResponseDto {
    private String teacher_name; //강사이름
    private int career; //경력
    private String company; //회사
    private String phone; //전화번호
    private String introduction; //소개

    public TeacherResponseDto(Teacher teacher) {
        this.teacher_name = teacher.getTeacher_name();
        this.career = teacher.getCareer();
        this.company = teacher.getCompany();
        this.phone = teacher.getPhone();
        this.introduction = teacher.getIntroduction();
    }
}
