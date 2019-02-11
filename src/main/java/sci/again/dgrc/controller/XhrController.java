package sci.again.dgrc.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sci.again.dgrc.domain.Disease;
import sci.again.dgrc.domain.Drug;
import sci.again.dgrc.repositories.CrossTableRepository;
import sci.again.dgrc.repositories.ResearchRepository;
import sci.again.dgrc.services.DiseaseService;
import sci.again.dgrc.services.DrugService;

/**
 * @author Mark Angrish
 */
@RestController
@RequestMapping("/main")
public class XhrController {

	private final DiseaseService diseaseService;

    private CrossTableRepository crossTableRepository;

    private ResearchRepository researchRepository;

    private DrugService drugService;

    @Autowired
	public XhrController(DiseaseService diseaseService,CrossTableRepository crossTableRepository,
                         ResearchRepository researchRepository,DrugService drugService) {
		this.diseaseService = diseaseService;
		this.crossTableRepository=crossTableRepository;
		this.researchRepository=researchRepository;
		this.drugService=drugService;
	}

    @GetMapping("/disease")
    public Collection<Disease> findByTitleLike(@RequestParam String title) {
//        return diseaseService.findByID(diseaseService.findIDbyNameLike(title));
        return null;
    }

    @GetMapping("/drug")
    public Collection<Drug> findByNameLike(@RequestParam String title){
//        return drugService.findByID(drugService.findIDbyNameLike(title));
        return null;
    }


}
