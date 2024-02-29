package com.sparta.springlv3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "class")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String lecture_name;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String introduction;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Timestamp registrationDate; // 타입 임시 지정

    @Column(nullable = false, unique = true)
    private String teacher;

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