package com.sparta.springlv3.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {
    private String email; //이메일
    private String password; //비밀번호
    private String department; //부서
    private String authority;  //권한
}
