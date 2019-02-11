package sci.again.dgrc.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sci.again.dgrc.domain.Drug;
import sci.again.dgrc.domain.Relevant;
import sci.again.dgrc.repositories.DrugRepository;

import java.util.*;

/**
 * @author tianyi
 * @date 2018-08-02 08:32
 */
@Slf4j
@Service
public class DrugService {

//    @Autowired
//    private DrugNameRepository drugNameRepository;

    @Autowired
    private DrugRepository drugRepository;


    @Transactional(readOnly = true)
    public Collection<Drug> findByTitleLike(String title) {
        Collection<Drug> drugs = drugRepository.findByAcademicNameLike(title);
        Iterator<Drug> result = drugs.iterator();
        while (result.hasNext()) {
            Drug drug = result.next();
            for (Relevant relevant : drug.getRelevants()) {
                relevant.getDisease().dropRelevant();
            }
        }
        return drugs;
    }

    @Transactional(readOnly = true)
    public Collection<Drug> findByID(String id) {
        List<Drug> result = new ArrayList<>();
        result.add(drugRepository.findByDrugbankId(id));
        return result;
    }

//    public String findIDbyNameLike(String name){
//        return drugNameRepository.findIdByAcadamicNameLike(name).iterator().next();
//    }

}
