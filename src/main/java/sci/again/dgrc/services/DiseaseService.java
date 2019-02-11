package sci.again.dgrc.services;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sci.again.dgrc.domain.Disease;
import sci.again.dgrc.domain.Relevant;
import sci.again.dgrc.repositories.DiseaseRepository;

@Service
public class DiseaseService {

    private final static Logger LOG = LoggerFactory.getLogger(DiseaseService.class);

	private final DiseaseRepository diseaseRepository;
	public DiseaseService(DiseaseRepository diseaseRepository) {
		this.diseaseRepository = diseaseRepository;
	}

//	@Autowired
//	private DiseaseNameRepository diseaseNameRepository;

	private Map<String, Object> toD3Format(Collection<Disease> diseases) {
		List<Map<String, Object>> nodes = new ArrayList<>();
		List<Map<String, Object>> rels = new ArrayList<>();
		int i = 0;
		Iterator<Disease> result = diseases.iterator();
		while (result.hasNext()) {
			Disease disease = result.next();
			nodes.add(map("title", disease.getAcademicName(), "label", "disease"));
			int target = i;
			i++;
			for (Relevant relevant : disease.getRelevants()) {
				Map<String, Object> actor = map("title", relevant.getDrug().getAcademicName(), "label", "actor");
				int source = nodes.indexOf(actor);
				if (source == -1) {
					nodes.add(actor);
					source = i++;
				}
				rels.add(map("source", source, "target", target));
			}
		}
		return map("nodes", nodes, "links", rels);
	}

	private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		result.put(key1, value1);
		result.put(key2, value2);
		return result;
	}

    @Transactional(readOnly = true)
    public Disease findByTitle(String title) {
        Disease result = diseaseRepository.findByAcademicName(title);
        return result;
    }

	@Transactional(readOnly = true)
	public Collection<Disease> findByID(String id) {
		List<Disease> result = new ArrayList<>();
		result.add(diseaseRepository.findByDiseaseId(id));
		return result;
	}

    @Transactional(readOnly = true)
    public Collection<Disease> findByTitleLike(String title) {
		Collection<Disease> diseases = diseaseRepository.findByAcademicNameLike(title);
		Iterator<Disease> result = diseases.iterator();
		while (result.hasNext()) {
			Disease disease = result.next();
			for (Relevant relevant : disease.getRelevants()) {
				relevant.getDrug().dropRelevant();
			}
		}
		return diseases;
    }

	@Transactional(readOnly = true)
	public Map<String, Object>  graph(int limit) {
		Collection<Disease> result = diseaseRepository.graph(limit);
		return toD3Format(result);
	}

//	public String findIDbyNameLike(String name){
//		return diseaseNameRepository.findDiseaseNameByAcadamicNameLike(name).getDiseasekId();
//	}
}
