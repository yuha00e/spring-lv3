package com.sparta.springlv3.user.dto;

import lombok.Getter;
import org.apache.catalina.User;

@Getter
public class UserResponseDto {
    private String email; //이메일
    private String password; //비밀번호
    private String department; //부서
    private String auth;  //권한

    public UserResponseDto(User user) {
        this.email = getEmail();
        this.password = getPassword();
        this.department = getDepartment();
        this.auth = getAuth();
    }
}
