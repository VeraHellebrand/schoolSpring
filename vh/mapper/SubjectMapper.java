package cz.vh.mapper;

import cz.vh.dto.SubjectDto;
import cz.vh.entity.SubjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface SubjectMapper {
    SubjectEntity toEntity(SubjectDto subjectDto);
    SubjectDto toDto(SubjectEntity subjectEntity);
}
