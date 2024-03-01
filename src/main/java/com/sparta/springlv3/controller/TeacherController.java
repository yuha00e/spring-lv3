package com.sparta.springlv3.controller;

import com.sparta.springlv3.dto.TeacherRequestDto;
import com.sparta.springlv3.dto.TeacherResponseDto;
import com.sparta.springlv3.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TeacherController {

    private final TeacherService teacherService;

    // 강사 등록
    @PostMapping("/teacher")
    public TeacherResponseDto createTeacher(@RequestBody TeacherRequestDto teacherRequestDto) {
        return teacherService.createTeacher(teacherRequestDto);
    }

    // 선택한 강사 정보 수정
    @PutMapping("/teacherInfo/{teacherId}")
    public TeacherResponseDto infoTeacher (@PathVariable Long teacherId, @RequestBody TeacherRequestDto teacherRequestDto) {
        return teacherService.infoTeacher(teacherRequestDto);
    }

    // 선택한 강사 조회
    @GetMapping ("/teacher/{teacherId}")
    public TeacherResponseDto updateTeacher(@PathVariable Long teacherId) {
        return teacherService.updateTeacher(teacherId);
    }

    // 선택한 강사가 촬영한 강의 목록 조회
    @GetMapping("/lecture/{teacherId}/{lectureId}")
    public TeacherResponseDto findTeacher(@PathVariable Long teacherId, @PathVariable Long lectureId) {
        return teacherService.findTeacher(teacherId, lectureId);
    }
}
