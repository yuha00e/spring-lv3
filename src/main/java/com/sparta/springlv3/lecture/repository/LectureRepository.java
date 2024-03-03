package com.sparta.springlv3.lecture.repository;

import com.sparta.springlv3.lecture.entity.CategoryEnum;
import com.sparta.springlv3.lecture.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

    // teacher에서 사용중.
    // Lecture에서 강사와 일치하는 정보들을 내림차순으로 정렬하는 쿼리문
    @Query("SELECT l FROM Lecture l WHERE l.teacher.id = :teacherId ORDER BY l.registrationDate DESC")
    List<Lecture> findLecturesByTeacherIdOrderByRegistrationDateDesc(Long teacherId);

    List<Lecture> findByCategory(CategoryEnum category);


}
