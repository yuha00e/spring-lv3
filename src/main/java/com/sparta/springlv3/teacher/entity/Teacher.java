package com.sparta.springlv3.teacher.entity;

import com.sparta.springlv3.lecture.entity.Lecture;
import com.sparta.springlv3.teacher.dto.TeacherRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String teacher_name;

//   생성자 추가
//    public Teacher(String teacherName) {
//        this.teacherName = teacherName;
//    }

    @Column(nullable = false)
    private int career;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private String introduction;

    // Lecture와의 일대다 관계 설정
//    @OneToMany(mappedBy = "teacher") // mappedBy 속성은 Lecture 엔티티 클래스에 있는 teacher 필드를 지정
//    private List<Lecture> lectures = new ArrayList<>();

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Lecture> lectures = new ArrayList<>();

    public Teacher(TeacherRequestDto teacherRequestDto) {
        this.teacher_name = teacherRequestDto.getTeacher_name();
        this.career = teacherRequestDto.getCareer();
        this.company = teacherRequestDto.getCompany();
        this.phone = teacherRequestDto.getPhone();
        this.introduction = teacherRequestDto.getIntroduction();
    }

    public Teacher(String teacherName) {
        this.teacher_name = teacherName;
    }

}
