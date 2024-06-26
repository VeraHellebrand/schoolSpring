package cz.vh.service;

import cz.vh.dto.SubjectDto;

import cz.vh.entity.SubjectEntity;
import cz.vh.mapper.SubjectMapper;
import cz.vh.repositury.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectMapper subjectMapper;

    public List<SubjectDto> getSubjects() {
        List<SubjectEntity> subjectEntities = subjectRepository.findAll();
        List<SubjectDto> subjectDtos = new ArrayList<>();
        for (SubjectEntity subjectEntity : subjectEntities) {
            subjectDtos.add((subjectMapper.toDto(subjectEntity)));
        }
        return subjectDtos;
    }

    public SubjectDto addSubject(SubjectDto subjectDto) {
        SubjectEntity subjectEntity = subjectMapper.toEntity(subjectDto);
        SubjectEntity savedEntity = subjectRepository.save(subjectEntity);
        return subjectMapper.toDto(savedEntity);
    }

    public SubjectDto getSubject(Integer id) {
        SubjectEntity subjectEntity = subjectRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return subjectMapper.toDto(subjectEntity);
    }

    public SubjectDto editSubject(Integer id,SubjectDto subjectDto){
        if (!subjectRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        SubjectEntity subjectEntity = subjectMapper.toEntity(subjectDto);
        subjectEntity.setId(id);
        SubjectEntity savedSubject = subjectRepository.save(subjectEntity);
        return  subjectMapper.toDto(savedSubject);
    }

    public SubjectDto deleteSubject(Integer id){
        SubjectEntity subjectToDelete = subjectRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        SubjectDto deletedSubject = subjectMapper.toDto(subjectToDelete);
        subjectRepository.delete(subjectToDelete);
        return deletedSubject;
    }
}
