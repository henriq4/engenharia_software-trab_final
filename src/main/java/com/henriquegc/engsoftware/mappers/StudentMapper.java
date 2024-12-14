package com.henriquegc.engsoftware.mappers;

import com.henriquegc.engsoftware.dtos.student.CreateStudentDTO;
import com.henriquegc.engsoftware.models.Student;

public class StudentMapper {
    public static Student mapToStudent(CreateStudentDTO student) {
        return Student.builder()
            .name(student.getName())
            .ra(student.getRa())
            .build();
    }
}