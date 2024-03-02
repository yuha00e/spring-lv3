package com.sparta.springlv3.teacher.repository;

import com.sparta.springlv3.teacher.entity.Teacher; // 병합하고자 하는 Teacher 클래스의 패키지로 수정해주세요
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

//    @Query("SELECT l FROM Lecture l WHERE l.teacher.id = :teacherId ORDER BY l.createdAt DESC")
//    List<Lecture> findByTeacherIdOrderByCreatedAtDesc(@Param("teacherId") Long teacherId);

}
