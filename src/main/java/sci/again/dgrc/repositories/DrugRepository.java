package sci.again.dgrc.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import sci.again.dgrc.domain.Drug;

import java.util.Collection;

/**
 * @author pdtyreus
 * @author Mark Angrish
 */
public interface DrugRepository extends Neo4jRepository<Drug, Long> {

    Drug findByDrugbankId(@Param("drugbankId") String drugbankId);

    Collection<Drug> findByAcademicNameLike(@Param("academicName") String academic_name);

}