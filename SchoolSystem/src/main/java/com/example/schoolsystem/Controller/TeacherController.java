package com.example.schoolsystem.Controller;

import com.example.schoolsystem.ApiResponse.ApiResponse;
import com.example.schoolsystem.Model.Teacher;
import com.example.schoolsystem.Repository.TeacherRepository;
import com.example.schoolsystem.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherRepository teacherRepository;

    @GetMapping("/get")
    public ResponseEntity getAllTeachers() {
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher has been added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher with ID: " + id + " has been updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher with ID: " + id + " has been deleted successfyll"));
    }

    @GetMapping("/get/details/{id}")
    public ResponseEntity getTeacherDetails(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(id));
    }

    @PutMapping("/assign/{teacherId}/{courseId}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer teacherId, @PathVariable Integer courseId) {
        teacherService.assignTeacherToCourse(teacherId, courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher with ID: " + teacherId +
                " has been assigned to course with ID: " + courseId + " successfully"));
    }
}
