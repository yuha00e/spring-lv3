package com.sparta.springlv3.service;

import com.sparta.springlv3.repository.LectureRepository;
import com.sparta.springlv3.repository.TeacherRepository;
import com.sparta.springlv3.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {

    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;
    private final TeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, LectureRepository lectureRepository, TeacherRepository teacherRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.lectureRepository = lectureRepository;
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ADMIN_TOKEN
    private final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";


}
