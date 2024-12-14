package com.henriquegc.engsoftware.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquegc.engsoftware.dtos.student.CreateStudentDTO;
import com.henriquegc.engsoftware.models.Student;
import com.henriquegc.engsoftware.services.IStudentService;

@RestController()
@RequestMapping("/students")
public class StudentController {
    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    @PostMapping
    public void createStudent(@RequestBody CreateStudentDTO student) {
        this.studentService.createStudent(student);
    }

}
