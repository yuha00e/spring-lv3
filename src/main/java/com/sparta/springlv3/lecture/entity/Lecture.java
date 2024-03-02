package com.sparta.springlv3.lecture.entity;

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
@Table(name = "lecture")
public class Lecture extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String lectureName;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String introduction;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryEnum category;

    @Column(nullable = false)
    private Timestamp registrationDate; // 타입 임시 지정

    @Column(nullable = false)
    private String teacher;

    public Lecture(String lectureName, Long price, String introduction, CategoryEnum category, Timestamp registrationDate, String teacher) {
        this.lectureName = lectureName;
        this.price = price;
        this.introduction = introduction;
        this.category = category;
        this.registrationDate = registrationDate;
        this.teacher = teacher;
    }

}
