package com.henriquegc.engsoftware.services;

import java.util.List;

import com.henriquegc.engsoftware.dtos.student.CreateStudentDTO;
import com.henriquegc.engsoftware.models.Student;

public interface IStudentService {
    List<Student> getStudents();
    void createStudent(CreateStudentDTO student);
}
