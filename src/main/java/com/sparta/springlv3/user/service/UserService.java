package com.sparta.springlv3.user.service;


import com.sparta.springlv3.user.dto.SignupRequestDto;
import com.sparta.springlv3.user.dto.SignupResponseDto;
import com.sparta.springlv3.user.entity.DepartmentEnum;
import com.sparta.springlv3.user.entity.UserRoleEnum;
import com.sparta.springlv3.user.entity.User;
import com.sparta.springlv3.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // ADMIN_TOKEN
    private final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";

    // 회원 가입
    public SignupResponseDto signup(SignupRequestDto requestDto) {
        String email = requestDto.getEmail();  // requestDto 에서 getUsername 가져와 변수 username 에 담음.
        String password = passwordEncoder.encode(requestDto.getPassword());  // 평문을 암호화 해서 password 에 담음.

        // 회원 중복 확인
//        Optional<User> checkUsername = userRepository.findByEmail(email);  // Optional 타입으로 받음. null 체크하기 위해 만들어진 타입(값이 없으면 NULL, 있다면 값을 넣어줌) // userRepository 에 findByUsername 쿼리 메서드 작성해보자.
//        if (checkUsername.isPresent()) {   // isPresent : 현재 Optional 에 넣어준 값이 존재하는 지 확인 메서드
//            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
//        }

        // email 중복확인
//        String email = requestDto.getEmail();
        Optional<User> checkEmail = userRepository.findByEmail(email);
        if (checkEmail.isPresent()) {
            throw new IllegalArgumentException("중복된 Email 입니다.");
        }




        // 사용자 ROLE 확인 (권한확인)
        UserRoleEnum role = UserRoleEnum.STAFF;  // 일반 사용자 권한을 넣어놓은다.
        // 사용자 department 확인
        DepartmentEnum department = DepartmentEnum.valueOf(requestDto.getDepartment());
        if (department != DepartmentEnum.MARKETING) {   // boolean type 은 is 로 시작함(규칙), isAdmin // (true)면 관리자 권한으로 회원가입
            if (!ADMIN_TOKEN.equals(requestDto.getAdminToken())) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRoleEnum.MANAGER;  // 위에서 USER -> ADMIN 권한으로 덮어짐.
        }

        // 사용자 등록
        User user = new User(email,password, department ,role);  // 등록하려면 user entity 클래스 객체를 만듦 : JPA 에서 Entity class 객체 하나가 DB의 한 열과 같다. (안의 내용은 생성자) 생성자를 통해서 만듦. 빨간 밑줄 뜨면 Create Constructor ^^
        userRepository.save(user);
        return new SignupResponseDto(user);
    }

//    // 회원가입
//    public String signup(SignupRequestDto requestDto) {
//        String email = requestDto.getEmail();
//        String password = passwordEncoder.encode(requestDto.getPassword());
//        String auth = requestDto.getAuth(); // 사용자 아이디 생성
//        String department = requestDto.getDepartment(); // 부서 코드 가져오기
//
//        // 이메일 형식 검증을 위한 정규 표현식
//        final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
//        // 이메일 유효성 검사
//        if (!email.matches(EMAIL_PATTERN)) {
//            throw new IllegalArgumentException("올바른 이메일 형식이 아닙니다.");
//        }
//
//        // 비밀번호 형식 검증을 위한 정규 표현식
//        final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$";
//        // 비밀번호 유효성 검사
//        if (!password.matches(PASSWORD_PATTERN)) {
//            throw new IllegalArgumentException("비밀번호는 최소 8자 이상, 15자 이하이며 알파벳 대소문자, 숫자, 특수문자로 구성되어야 합니다.");
//        }
//
//        // 부서 선택 확인
//        DepartmentEnum selectedDepartment = null;
//        for (DepartmentEnum departmentEnum : DepartmentEnum.values()) { // 부서의 모든 값을 가져온다
//            if (departmentEnum.getDepartment().equals(department)) {
//                selectedDepartment = departmentEnum;
//                break;
//            }
//        }
//        if (selectedDepartment == null) {
//            throw new IllegalArgumentException("유효하지 않은 부서입니다.");
//        }
//        // selectedDepartment 값을 String으로 변환
//        String selectedDepartmentString = selectedDepartment.getDepartment();
//
//        // 사용자 ROLE 확인 / 권한 확인
//        // Staff -> Manager로 권한 변경
//        UserRoleEnum authority = UserRoleEnum.STAFF;
//        if (requestDto.isAdmin()) {
//            if (!ADMIN_TOKEN.equals(requestDto.getAdminToken())) {
//                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
//            }
//            authority = UserRoleEnum.MANAGER;
//        }
//
//        // 사용자 등록
//        User user = new User(email, password, DepartmentEnum.valueOf(selectedDepartmentString), auth);
//        userRepository.save(user);
//
////        throw new IllegalArgumentException("관리자 가입이 성공적으로 완료되었습니다.");
//
//        return userResponseDto(user);
//
////         email 중복확인
////        Optional<User> checkEmail = userRepository.findByEmail(email);
////        if (checkEmail.isPresent()) {
////            throw new IllegalArgumentException("중복된 Email 입니다.");
////        }
//    }

}
