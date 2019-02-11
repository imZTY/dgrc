package sci.again.dgrc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sci.again.dgrc.entity.DrugName;

import java.util.Collection;
import java.util.List;

/**
 * @author tianyi
 * @date 2018-08-02 07:12
 */
public interface DrugNameRepository extends JpaRepository<DrugName,Integer> {
    @Query("select dn.drugbankId from DrugName dn where dn.acadamicName like CONCAT('%',?1,'%')")
    public Collection<String> findIdsByAcadamicNameLike(String name);

    public List<DrugName> findByAcadamicNameLike(String acadamicname);
}
