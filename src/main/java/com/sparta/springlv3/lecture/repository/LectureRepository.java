package com.sparta.springlv3.lecture.repository;

import com.sparta.springlv3.lecture.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

    @Query("SELECT l FROM Lecture l WHERE l.teacher.id = :teacherId ORDER BY l.createdAt DESC")
    List<Lecture> findLecturesByTeacherIdOrderByCreatedAtDesc(Long teacherId);


}
