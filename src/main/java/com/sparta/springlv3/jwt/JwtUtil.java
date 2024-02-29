//package com.sparta.springlv3.jwt;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.security.Keys;
//import jakarta.annotation.PostConstruct;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.sparta.springauth.entity.UserRoleEnum;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.security.Key;
//import java.util.Base64;
//import java.util.Date;
//
//@Component
//public class JwtUtil {
//    // Header KEY 값 -> 쿠키의 name값 (쿠키 만들때 한 코드 참고)
//    public static final String AUTHORIZATION_HEADER = "Authorization";
//    // 사용자 권한 값의 KEY
//    public static final String AUTHORIZATION_KEY = "auth";
//    // Token 식별자
//    public static final String BEARER_PREFIX = "Bearer "; // Bearer 토큰 앞에 붙일 용어
//    // 토큰 만료시간
//    private final long TOKEN_TIME = 60 * 60 * 1000L; // 60분
//
//    @Value("${jwt.secret.key}") // Base64 Encode 한 SecretKey
//    private String secretKey; // application propertice에 있는 값 가져오는 방법 -> value 에노테이션 사용하는 것 (import도 확인)
//    private Key key; // secreatkey 담는다
//    private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; //알고리즘 설정하는거. 원하는걸로 정해서 쓰면 됨
//
//    // 로그 설정
//    public static final Logger logger = LoggerFactory.getLogger("JWT 관련 로그"); // 시간순으로 기록해줌
//
//    @PostConstruct // 한번만 받아오면 되는 값을 사용할때 마다 요청을 새로호출하는 실수를 방지하기 위해서
//    public void init() {
//        byte[] bytes = Base64.getDecoder().decode(secretKey); // base 64로 디코딩 하는 코드
//        key = Keys.hmacShaKeyFor(bytes);
//    }
//
//    // 토큰 생성
//    public String createToken(String username, UserRoleEnum role) {
//        Date date = new Date();
//
//        return BEARER_PREFIX + // 값을 추가로 붙여주는 코드?
//                Jwts.builder() // 내용 넣고 compact 하면 jwt 생성됨
//                        .setSubject(username) // 사용자 식별자값(ID)
//                        .claim(AUTHORIZATION_KEY, role) // 사용자 권한 key - value
//                        .setExpiration(new Date(date.getTime() + TOKEN_TIME)) // 만료 시간
//                        .setIssuedAt(date) // 발급일
//                        .signWith(key, signatureAlgorithm) // 암호화 알고리즘
//                        .compact();
//    }
//
//    // JWT Cookie 에 저장
//    public void addJwtToCookie(String token, HttpServletResponse res) {
//        try { // 쿠키는 공백이 불가능하다
//            token = URLEncoder.encode(token, "utf-8").replaceAll("\\+", "%20"); // Cookie Value 에는 공백이 불가능해서 encoding 진행
//
//            Cookie cookie = new Cookie(AUTHORIZATION_HEADER, token); // Name-Value
//            cookie.setPath("/");
//
//            // Response 객체에 Cookie 추가
//            res.addCookie(cookie);
//        } catch (UnsupportedEncodingException e) {
//            logger.error(e.getMessage());
//        }
//    }
//
//
//    // 앞에 썼다 "barer "의 공백을 없애기 위해서
//    // JWT 토큰 substring
//    public String substringToken(String tokenValue) {
//        if (StringUtils.hasText(tokenValue) && tokenValue.startsWith(BEARER_PREFIX)) { // 공백인지 null인지 확인 && 토큰이 BEARER_PREFIX로 시작 되는지 (토큰은 BEARER_PREFIX로 시작되니까 (위에 참고))
//            return tokenValue.substring(7); // BEARER_ 여기까지 잘라줌
//        }
//        logger.error("Not Found Token"); // 토큰이 없을때
//        throw new NullPointerException("Not Found Token");
//    }
//
//    // 잘라진 토큰 검사
//    // 토큰 검증
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token); // 토큰을 검증할 수 있다.
//            return true;
//        } catch (SecurityException | MalformedJwtException | SignatureException e) { // 어떤 오류가 발생했는지 세세하게 나눠놓음
//            logger.error("Invalid JWT signature, 유효하지 않는 JWT 서명 입니다.");
//        } catch (ExpiredJwtException e) {
//            logger.error("Expired JWT token, 만료된 JWT token 입니다.");
//        } catch (UnsupportedJwtException e) {
//            logger.error("Unsupported JWT token, 지원되지 않는 JWT 토큰 입니다.");
//        } catch (IllegalArgumentException e) {
//            logger.error("JWT claims is empty, 잘못된 JWT 토큰 입니다.");
//        }
//        return false;
//    }
//
//    // 토큰에서 사용자 정보 가져오기
//    public Claims getUserInfoFromToken(String token) { // Claims 데이터가 들어있는 집합을 반환한다
//        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody(); // body 부분에서 Claims를 가져올수있다.
//    }
//}