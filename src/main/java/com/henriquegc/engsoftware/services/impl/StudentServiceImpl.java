package com.henriquegc.engsoftware.services.impl;

import com.henriquegc.engsoftware.dtos.student.CreateStudentDTO;
import com.henriquegc.engsoftware.models.Student;
import com.henriquegc.engsoftware.repositories.StudentRepository;
import com.henriquegc.engsoftware.services.IStudentService;

import static com.henriquegc.engsoftware.mappers.StudentMapper.mapToStudent;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(CreateStudentDTO student) {
        this.studentRepository.save(mapToStudent(student));
    }

    @Override
    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }
    
}
