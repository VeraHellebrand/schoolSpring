package cz.vh.repositury;

import cz.vh.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SubjectRepository extends JpaRepository<SubjectEntity, Integer>{
}
