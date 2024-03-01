package com.sparta.springlv3.repository;

import com.sparta.springlv3.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
