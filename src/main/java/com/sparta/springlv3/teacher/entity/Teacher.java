package com.sparta.springlv3.teacher.entity;

import com.sparta.springlv3.teacher.dto.TeacherRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(nullable = false)
    private int career;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private String introduction;

//    @OneToMany(mappedBy = "teacher")
//    private List<Lecture> lectures = new ArrayList<>();

    public Teacher(TeacherRequestDto teacherRequestDto) {
        this.teacher_name = teacherRequestDto.getTeacher_name();
        this.career = teacherRequestDto.getCareer();
        this.company = teacherRequestDto.getCompany();
        this.phone = teacherRequestDto.getPhone();
        this.introduction = teacherRequestDto.getIntroduction();
    }
}
