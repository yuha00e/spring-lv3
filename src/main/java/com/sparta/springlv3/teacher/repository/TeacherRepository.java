package com.sparta.springlv3.teacher.repository;

import com.sparta.springlv3.teacher.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findById(Long id);

//    @Query("SELECT l FROM Lecture l WHERE l.teacher.id = :teacherId ORDER BY l.createdAt DESC")
//    List<Lecture> findByTeacherIdOrderByCreatedAtDesc(@Param("teacherId") Long teacherId);

}
