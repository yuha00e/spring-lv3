package com.sparta.springlv3.teacher.entity;

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

    public Teacher(String teacher_name, int career, String company, String phone, String introduction) {
        this.teacher_name = teacher_name;
        this.career = career;
        this.company = company;
        this.phone = phone;
        this.introduction = introduction;
    }
}
