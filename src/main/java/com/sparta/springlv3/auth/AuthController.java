package com.sparta.springlv3.auth;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.sparta.springauth.entity.UserRoleEnum;
import org.sparta.springauth.jwt.JwtUtil;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
//@RequiredArgsConstructor // 이거 하거나 아니면 26-30번째 줄에 있는거 하던거 둘중하나
@RequestMapping("/api")
public class AuthController {

    public static final String AUTHORIZATION_HEADER = "Authorization"; // 상수

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil){ // 생성자 주입
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/create-cookie") // 쿠키 만드는 코드
    public String createCookie(HttpServletResponse res) { // respoonse를 받아 오는 것
        addCookie("Robbie Auth", res);

        return "createCookie";
    }

    @GetMapping("/get-cookie") // 쿠키 가져오는 코드
    public String getCookie(@CookieValue(AUTHORIZATION_HEADER) String value) { // Name-Value?
        System.out.println("value = " + value);

        return "getCookie : " + value;
    }

    @GetMapping("/create-session") // 세션 만들기
    public String createSession(HttpServletRequest req) { // request, 요청을 받아 오는 것
        // 세션이 존재할 경우 세션 반환, 없을 경우 새로운 세션을 생성한 후 반환
        HttpSession session = req.getSession(true);

        // 세션에 저장될 정보 Name - Value 를 추가합니다.
        session.setAttribute(AUTHORIZATION_HEADER, "Robbie Auth"); // name - value

        return "createSession";
    }

    @GetMapping("/get-session") // 세션 읽기
    public String getSession(HttpServletRequest req) {
        // 세션이 존재할 경우 세션 반환, 없을 경우 null 반환
        HttpSession session = req.getSession(false); // 가져오는데 생성할 필요는 없으니까

        String value = (String) session.getAttribute(AUTHORIZATION_HEADER); // 가져온 세션에 저장된 Value 를 Name 을 사용하여 가져옵니다.
        System.out.println("value = " + value);

        return "getSession : " + value;
    }

    @GetMapping("/create-jwt") // jwt 생성코드
    public String createJwt(HttpServletResponse res) {
        // Jwt 생성
        String token = jwtUtil.createToken("Robbie", UserRoleEnum.USER);

        // Jwt 쿠키 저장
        jwtUtil.addJwtToCookie(token, res);

        return "createJwt : " + token;
    }

    @GetMapping("/get-jwt") // jwt 가져오는 코드
    public String getJwt(@CookieValue(JwtUtil.AUTHORIZATION_HEADER) String tokenValue) {
        // JWT 토큰 substring
        String token = jwtUtil.substringToken(tokenValue);

        // 토큰 검증
        if(!jwtUtil.validateToken(token)){ // false 일때
            throw new IllegalArgumentException("Token Error");
        }

        // 토큰에서 사용자 정보 가져오기
        Claims info = jwtUtil.getUserInfoFromToken(token);
        // 사용자 username
        String username = info.getSubject();
        System.out.println("username = " + username);
        // 사용자 권한
        String authority = (String) info.get(JwtUtil.AUTHORIZATION_KEY);
        System.out.println("authority = " + authority);

        return "getJwt : " + username + ", " + authority;
    }

    public static void addCookie(String cookieValue, HttpServletResponse res) { // 쿠키가 생성되는 메서드. respoonse를 받아 오는 것
        try {
            cookieValue = URLEncoder.encode(cookieValue, "utf-8").replaceAll("\\+", "%20"); // Cookie Value 에는 공백이 불가능해서 encoding 진행. 공백을 %20으로 바꾸는 표현식

            Cookie cookie = new Cookie(AUTHORIZATION_HEADER, cookieValue); // Name-Value / 위에서 바꾼 쿠키를 넣는다.
            cookie.setPath("/");
            cookie.setMaxAge(30 * 60);

            // Response 객체에 Cookie 추가
            res.addCookie(cookie); // 위에서 만든 쿠키 넣어주기
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
