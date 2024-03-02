package com.sparta.springlv3.lecture.repository;

import com.sparta.springlv3.lecture.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
