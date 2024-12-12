package com.example.schoolsystem.Service;

import com.example.schoolsystem.ApiResponse.ApiException;
import com.example.schoolsystem.Model.Course;
import com.example.schoolsystem.Model.Teacher;
import com.example.schoolsystem.Repository.CourseRepository;
import com.example.schoolsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // First flow, which is when we add a course, it will be assigned to the provided teacher.
//    public void addCourse(Integer teacherId, Course course) {
//        Teacher teacher = teacherRepository.findTeacherById(teacherId);
//        if (teacher == null)
//            throw new ApiException("Teacher with ID: " + teacherId + " was not found");
//
//        teacher.getCourses().add(course);
//        teacherRepository.save(teacher);
//
//        course.setTeacher(teacher);
//        courseRepository.save(course);
//    }

    // Second flow which I like more, where we can add course with null teacher, then we can assign a teacher to this course.
    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course) {
        Course oldCourse = courseRepository.findCourseById(id);
        if (oldCourse == null)
            throw new ApiException("Course with ID: " + id + " was not found");

        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if (course == null)
            throw new ApiException("Course with ID: " + id + " was not found");

        courseRepository.delete(course);
    }
}
