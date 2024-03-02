package com.sparta.springlv3.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String department;

    @NotBlank
    private String auth;

    @NotBlank
    private String createUserId;

    private boolean admin = false;
    private String adminToken = "";
}

