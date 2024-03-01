package com.sparta.springlv3.service;


import com.sparta.springlv3.dto.SignupRequestDto;
import com.sparta.springlv3.entity.DepartmentEnum;
import com.sparta.springlv3.entity.UserRoleEnum;
import com.sparta.springlv3.entity.User;
import com.sparta.springlv3.repository.UserRepository;
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

    // 회원가입
    public void signup(SignupRequestDto requestDto) {
        String email = requestDto.getEmail();
        String password = passwordEncoder.encode(requestDto.getPassword());
        String auth = requestDto.getAuth(); // 사용자 아이디 생성
        String department = requestDto.getDepartment(); // 부서 코드 가져오기

//        // email 중복확인
//        Optional<User> checkEmail = userRepository.findByEmail(email);
//        if (checkEmail.isPresent()) {
//            throw new IllegalArgumentException("중복된 Email 입니다.");
//        }

        // 이메일 형식 검증을 위한 정규 표현식
        final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        // 이메일 유효성 검사
        if (!email.matches(EMAIL_PATTERN)) {
            throw new IllegalArgumentException("올바른 이메일 형식이 아닙니다.");
        }

        // 비밀번호 형식 검증을 위한 정규 표현식
        final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$";
        // 비밀번호 유효성 검사
        if (!password.matches(PASSWORD_PATTERN)) {
            throw new IllegalArgumentException("비밀번호는 최소 8자 이상, 15자 이하이며 알파벳 대소문자, 숫자, 특수문자로 구성되어야 합니다.");
        }

        // 부서 선택 확인
        DepartmentEnum selectedDepartment = null;
        for (DepartmentEnum departmentEnum : DepartmentEnum.values()) { // 부서의 모든 값을 가져온다
            if (departmentEnum.getDepartment().equals(department)) {
                selectedDepartment = departmentEnum;
                break;
            }
        }
        if (selectedDepartment == null) {
            throw new IllegalArgumentException("유효하지 않은 부서입니다.");
        }
        // selectedDepartment 값을 String으로 변환
        String selectedDepartmentString = selectedDepartment.getDepartment();

        // 사용자 ROLE 확인 / 권한 확인
        // Staff -> Manager로 권한 변경
        UserRoleEnum authority = UserRoleEnum.STAFF;
        if (requestDto.isAdmin()) {
            if (!ADMIN_TOKEN.equals(requestDto.getAdminToken())) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            authority = UserRoleEnum.MANAGER;
        }

        // 사용자 등록
        User user = new User(email, password, selectedDepartmentString, auth);
        userRepository.save(user);

        throw new IllegalArgumentException("관리자 가입이 성공적으로 완료되었습니다.");

    }

}

