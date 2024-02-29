package com.sparta.springlv3.repository;

import com.sparta.springlv3.entity.Class;
import com.sparta.springlv3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class, Long> {
}