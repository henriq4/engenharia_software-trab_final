package com.henriquegc.engsoftware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henriquegc.engsoftware.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
