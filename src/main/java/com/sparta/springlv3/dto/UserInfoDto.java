package com.sparta.springlv3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoDto {
    private String email;

    private String password;

    private String department;

    private String authority;

    boolean isAdmin;
}