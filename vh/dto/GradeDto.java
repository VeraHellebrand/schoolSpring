package cz.vh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeDto {
    Integer id;
    StudentDto student;
    SubjectDto subject;
    Integer studentId;
    Integer subjectId;
    String topic;
    int mark;
}
