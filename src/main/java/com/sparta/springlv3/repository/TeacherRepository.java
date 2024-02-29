package com.sparta.springlv3.repository;

import com.sparta.springlv3.entity.Teacher;
import com.sparta.springlv3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}