package sci.again.dgrc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sci.again.dgrc.entity.DiseaseName;

/**
 * @author tianyi
 * @date 2018-08-02 07:13
 */
public interface DiseaseNameRepository extends JpaRepository<DiseaseName,Integer> {
    public DiseaseName findDiseaseNameByAcadamicNameLike(String name);
}
