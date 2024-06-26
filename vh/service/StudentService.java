package cz.vh.service;

import cz.vh.dto.StudentDto;
import cz.vh.entity.StudentEntity;
import cz.vh.mapper.StudentMapper;
import cz.vh.repositury.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    public List<StudentDto> getStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntities) {
            studentDtos.add((studentMapper.toDto(studentEntity)));
        }
        return studentDtos;
    }

    public StudentDto addStudent(StudentDto studentDto) {
        StudentEntity studentEntity = studentMapper.toEntity(studentDto);
        StudentEntity savedEntity = studentRepository.save(studentEntity);
        return studentMapper.toDto(savedEntity);
    }

    public StudentDto getStudent(Integer id) {
        StudentEntity studentEntity = studentRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return studentMapper.toDto(studentEntity);
    }

    public StudentDto editStudent(Integer id,StudentDto studentDto){
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        StudentEntity studentEntity = studentMapper.toEntity(studentDto);
        studentEntity.setId(id);
        StudentEntity savedStudent = studentRepository.save(studentEntity);
        return  studentMapper.toDto(savedStudent);
    }

    public StudentDto deleteStudent(Integer id){
        StudentEntity studentToDelete = studentRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        StudentDto deletedStudent = studentMapper.toDto(studentToDelete);
        studentRepository.delete(studentToDelete);
        return deletedStudent;
    }
}
