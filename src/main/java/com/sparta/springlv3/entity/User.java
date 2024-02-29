package com.sparta.springlv3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String authority;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING) // eunm의 이름 그대로를 데이터베이스에 저장한다.
    private UserRoleEnum role;

    public User(Long userId, String email, String password, String department, String authority) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.department = department;
        this.authority = authority;
    }
}