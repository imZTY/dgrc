package sci.again.dgrc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sci.again.dgrc.repositories.DrugNameRepository;
import sci.again.dgrc.services.DiseaseService;
import sci.again.dgrc.services.DrugService;

import java.util.Collection;

/**
 * @author tianyi
 * @date 2018-07-19 19:48
 */
@Controller
public class JumpController {

    private DrugService drugService;

    private DrugNameRepository drugNameRepository;

    private DiseaseService diseaseService;

    @Autowired
    public JumpController(DrugService drugService,DrugNameRepository drugNameRepository,DiseaseService diseaseService){
        this.drugService=drugService;
        this.drugNameRepository=drugNameRepository;
        this.diseaseService=diseaseService;
    }


    @GetMapping("/test")
    public void toTest(ModelMap modelMap){
        System.out.println(drugNameRepository.findAll());
        Collection<String> result=drugNameRepository.findIdsByAcadamicNameLike("n");
        System.out.println(result.iterator().next());
    }

    @GetMapping("/search")
    public String toDetail(@RequestParam String searcher,@RequestParam String title, ModelMap modelMap){
//        title="*"+title+"*";
        if (searcher.equals("drug")){
//            modelMap.addAttribute("host",drugService.findByID(drugService.findIDbyNameLike(title)));
            return "drug";
        }else if (searcher.equals("disease")){
//            modelMap.addAttribute("host",diseaseService.findByID(diseaseService.findIDbyNameLike(title)));
//            modelMap.addAttribute("host","hello disease");
            return "disease";
        }else if (searcher.equals("check")){
            modelMap.addAttribute("host","Hello world");
            return "check";
        }
        modelMap.addAttribute("host","Hello world");
        return "test";
    }

}
