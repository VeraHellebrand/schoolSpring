package cz.vh.service;

import cz.vh.dto.GradeDto;
import cz.vh.entity.GradeEntity;
import cz.vh.mapper.GradeMapper;
import cz.vh.repositury.GradeRepository;
import cz.vh.repositury.StudentRepository;
import cz.vh.repositury.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    GradeMapper gradeMapper;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SubjectRepository subjectRepository;

    public GradeDto addGrade(GradeDto gradeDto){
        GradeEntity gradeToAdd = gradeMapper.toEntity(gradeDto);
        gradeToAdd.setStudent(studentRepository.getReferenceById(gradeDto.getStudentId()));
        gradeToAdd.setSubject(subjectRepository.getReferenceById(gradeDto.getSubjectId()));

        return gradeMapper.toDto(gradeRepository.save(gradeToAdd));
    }

    public List<GradeDto> getAllGrades(){
        List<GradeDto> allGrades = new ArrayList<>();
        for (GradeEntity gradeEntity : gradeRepository.findAll()) {
            allGrades.add(gradeMapper.toDto(gradeEntity));
        }

        return allGrades;
    }

    public GradeDto getGradeById(int gradeId){
        return gradeMapper.toDto(gradeRepository.getReferenceById(gradeId));
    }

    public GradeDto editGrade(int gradeId, GradeDto gradeDto ){
        gradeDto.setId(gradeId);
        GradeEntity gradeEntity = gradeRepository.getReferenceById(gradeId);
        gradeMapper.updateEntity(gradeDto, gradeEntity);
        gradeEntity.setSubject(subjectRepository.getReferenceById(gradeDto.getSubjectId()));
        gradeEntity.setStudent(studentRepository.getReferenceById(gradeDto.getStudentId()));

        return gradeMapper.toDto(gradeRepository.save(gradeEntity));
    }

    public GradeDto deleteGrade(int gradeId){
        GradeEntity gradeEntity = gradeRepository.getReferenceById(gradeId);
        GradeDto deletedGrade = gradeMapper.toDto(gradeEntity);
        gradeRepository.delete(gradeEntity);

        return deletedGrade;
    }

}





















