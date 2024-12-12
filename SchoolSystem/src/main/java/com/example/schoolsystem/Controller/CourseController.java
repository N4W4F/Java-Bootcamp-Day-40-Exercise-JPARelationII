package com.example.schoolsystem.Controller;

import com.example.schoolsystem.ApiResponse.ApiResponse;
import com.example.schoolsystem.Model.Course;
import com.example.schoolsystem.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourses() {
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    // First flow, create and assign
//    @PostMapping("/add/{teacherId}")
//    public ResponseEntity addCourse(@PathVariable Integer teacherId, @RequestBody @Valid Course course) {
//        courseService.addCourse(teacherId, course);
//        return ResponseEntity.status(200).body(new ApiResponse("Course has been added and assigned to Teacher with ID: " + teacherId + " successfully"));
//    }

    // Second flow, create only
    @PostMapping("/create")
    public ResponseEntity createCourse(@RequestBody @Valid Course course) {
        courseService.createCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course has been added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @RequestBody @Valid Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("Course with ID: " + id + " has been updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course with ID: " + id + " has been deleted successfully"));
    }
}
