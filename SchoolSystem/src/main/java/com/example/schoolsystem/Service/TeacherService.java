package com.example.schoolsystem.Service;

import com.example.schoolsystem.ApiResponse.ApiException;
import com.example.schoolsystem.Model.Address;
import com.example.schoolsystem.Model.Course;
import com.example.schoolsystem.Model.Teacher;
import com.example.schoolsystem.Repository.AddressRepository;
import com.example.schoolsystem.Repository.CourseRepository;
import com.example.schoolsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;
    private final CourseRepository courseRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher) {
        Teacher oldTeacher = teacherRepository.findTeacherById(id);
        if (oldTeacher == null)
            throw new ApiException("Teacher with ID: " + id + " was not found");

        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null)
            throw new ApiException("Teacher with ID: " + id + " was not found");

        Address address = addressRepository.findAddressById(id);

        teacher.setAddress(null);
        teacherRepository.save(teacher);
        addressRepository.delete(address);
        teacherRepository.delete(teacher);
    }

    public Teacher getTeacherDetails(Integer id) {
        return teacherRepository.findTeacherById(id);
    }

    public void assignTeacherToCourse(Integer teacherId, Integer courseId) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if (teacher == null)
            throw new ApiException("Teacher with ID: " + teacherId + " was not found");

        Course course = courseRepository.findCourseById(courseId);
        if (course == null)
            throw new ApiException("Course with ID: " + courseId + " was not found");

        teacher.getCourses().add(course);
        teacherRepository.save(teacher);

        course.setTeacher(teacher);
        courseRepository.save(course);
    }
}
