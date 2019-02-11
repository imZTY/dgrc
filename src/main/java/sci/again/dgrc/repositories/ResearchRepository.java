package sci.again.dgrc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sci.again.dgrc.entity.Research;

/**
 * @author tianyi
 * @date 2018-08-02 07:14
 */
public interface ResearchRepository extends JpaRepository<Research,Integer> {
}
