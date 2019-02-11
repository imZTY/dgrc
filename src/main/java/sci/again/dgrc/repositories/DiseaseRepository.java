package sci.again.dgrc.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import sci.again.dgrc.domain.Disease;

import java.util.Collection;

/**
 * @author Michael Hunger
 * @author Mark Angrish
 */
public interface DiseaseRepository extends Neo4jRepository<Disease, Long> {

	Disease findByDiseaseId(@Param("diseaseId") String diseaseId);

	Disease findByAcademicName(@Param("academicName") String academic_name);

	Collection<Disease> findByAcademicNameLike(@Param("academicName") String academic_name);

    @Query("MATCH (m:Disease)<-[r:RELEVANT]-(a:Drug) RETURN m,r,a LIMIT {limit}")
	Collection<Disease> graph(@Param("limit") int limit);
}