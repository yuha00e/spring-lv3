package com.sparta.springlv3.lecture.entity;

import com.sparta.springlv3.teacher.entity.Teacher;
import com.sparta.springlv3.user.entity.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Lecture")
public class Lecture extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String lecture_name;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String introduction;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Timestamp registrationDate; // 타입 임시 지정

    // Teacher와의 다대일 관계 설정
    @ManyToOne
    @JoinColumn(name = "teacher_id") // Teacher 엔티티 클래스의 id 필드와 매핑
    private Teacher teacher;

    public Lecture(Long id, String lecture_name, Long price, String introduction, String category, Timestamp registrationDate) {
        this.id = id;
        this.lecture_name = lecture_name;
        this.price = price;
        this.introduction = introduction;
        this.category = category;
        this.registrationDate = registrationDate;
        this.teacher = teacher;
    }


}
