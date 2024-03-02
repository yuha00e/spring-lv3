package com.sparta.springlv3.user.controller;

import com.sparta.springlv3.user.dto.SignupRequestDto;
import com.sparta.springlv3.user.dto.UserInfoDto;
import com.sparta.springlv3.user.security.UserDetailsImpl;
import com.sparta.springlv3.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    // 로그인 페이지 반환
    @GetMapping("/user/login-page")
    public String loginPage() {
        return "login";
    }

    // 회원가입 페이지 반환
    @GetMapping("/user/signup")
    public String signupPage() {
        return "signup";
    }

    //회원가입처리
    @PostMapping("/user/signup")
    public String signup(@Valid SignupRequestDto requestDto, BindingResult bindingResult) {
        // Validation 예외처리
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if(fieldErrors.size() > 0) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                log.error(fieldError.getField() + " 필드 : " + fieldError.getDefaultMessage());
            }
            return "redirect:/api/user/signup";
        }

        userService.signup(requestDto);

        return "redirect:/api/user/login-page";
    }

    // 회원 관련 정보 받기
    @GetMapping("/user-info") // 사용자 정보 조회
    @ResponseBody
    public UserInfoDto getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        String userEmail = userDetails.getUser().getEmail();
        String password = userDetails.getUser().getPassword();
//        UserRoleEnum role = userDetails.getUser().getRole();
//        boolean isAdmin = (role == UserRoleEnum.MANAGER);

        return new UserInfoDto(userEmail,password);
//        return new UserInfoDto(userEmail, isAdmin);
    }
}


