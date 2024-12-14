package com.henriquegc.engsoftware.dtos.student;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateStudentDTO {
    private String name;
    private String ra;
}
