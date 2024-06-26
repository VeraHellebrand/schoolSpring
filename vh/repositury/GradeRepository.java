package cz.vh.repositury;

import cz.vh.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<GradeEntity,Integer> {
}
