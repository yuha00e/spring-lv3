package com.sparta.springlv3.lecture.entity;

import com.sparta.springlv3.lecture.dto.LectureRequestDto;
import com.sparta.springlv3.teacher.entity.Teacher;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String lectureName;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String introL;

//    @Column(nullable = false)
//    private String introduction;

    @Column(nullable = false)
    private LocalDate registrationDate; // 타입 임시 지정

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // Enum 값과 매핑
    private CategoryEnum category;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    // Teacher와의 다대일 관계 설정
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "teacher_id") // Teacher 엔티티 클래스의 id 필드와 매핑
//    private Teacher teacher;
//
//    @Column(nullable = false)
//    private String teacher_name; // Teacher 엔티티의 teacher_name과 매핑

//    ------ 블로그
//    @ManyToOne (cascade = CascadeType.ALL)
//    @JoinColumn(name = "teacher_id")
//    private Teacher teacher;
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }


    public Lecture(LectureRequestDto lectureRequestDto) {
        this.lectureName = lectureRequestDto.getLectureName();
        this.price = lectureRequestDto.getPrice();
        this.introL = lectureRequestDto.getIntroL();
//        this.introduction = lectureRequestDto.getIntroductionL();
        this.category = CategoryEnum.valueOf(lectureRequestDto.getCategory());
        this.registrationDate = LocalDate.now();

        this.teacher = lectureRequestDto.getTeacher();
//        this.teacher_name = teacher.getTeacher_name(); // teacher_name 매핑

    }


    //    public Lecture(Long id, String lectureName, Long price, String introductionL, CategoryEnum category, LocalDate registrationDate, Teacher teacher) {
//        this.id = id;
//        this.lectureName = lectureName;
//        this.price = price;
//        this.introductionL = introductionL;
//        this.category = category;
//        this.registrationDate = registrationDate;
//        this.teacher = teacher;
//    }

}
