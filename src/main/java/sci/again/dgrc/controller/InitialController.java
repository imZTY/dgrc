package sci.again.dgrc.controller;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sci.again.dgrc.domain.Disease;
import sci.again.dgrc.domain.Drug;
import sci.again.dgrc.domain.Relevant;
import sci.again.dgrc.repositories.DiseaseRepository;
import sci.again.dgrc.repositories.DrugRepository;

import java.io.*;

/**
 * @author tianyi
 * @date 2018-07-19 17:30
 */
@RestController
@RequestMapping("/initial")
public class InitialController {

    private DiseaseRepository diseaseRepository;

    private DrugRepository drugRepository;

    @Autowired
    public InitialController(DiseaseRepository diseaseRepository,DrugRepository drugRepository){
        this.diseaseRepository=diseaseRepository;
        this.drugRepository=drugRepository;
    }

    @GetMapping("/do")
    public String init(){
        //===============jlx方法=================
        try{
//            String realPath="F:\\study\\jidi\\2018\\知识图谱药物\\数据\\决战SCI\\导入mysql.xls";
            String realPath="../导入mysql.xls";
            File fileDes = new File(realPath);
            InputStream str = new FileInputStream(fileDes);
            // 构造Workbook（工作薄）对象
            Workbook rwb=Workbook.getWorkbook(fileDes);
            //Workbook rwb=Workbook.getWorkbook(str);
            Sheet rs=rwb.getSheet(4);//获取第5张工作表
            int rsRows=rs.getRows();//获取Sheet表中所包含的总行数
            int rsCols=rs.getColumns();//获取Sheet表中所包含的总列数
            //log.info("========行========"+rsRows+"=====列========"+rsCols);
            for(int i=1;i<rsRows;i++){//读取行
                //log.info("========执行第========"+i+"行");

                Cell dbid=rs.getCell(0, i);//定位先列后行
                Cell did=rs.getCell(1, i);//定位先列后行
                Cell adjp=rs.getCell(2, i);//定位先列后行
                Cell re=rs.getCell(3, i);//定位先列后行
                Cell dn=rs.getCell(4, i);//定位先列后行
                Cell dbn=rs.getCell(5, i);//定位先列后行

                String drugbankID=dbid.getContents();//读取内容
                String diseaseID=did.getContents();//读取内容
                double p=Double.parseDouble(adjp.getContents());//读取内容
                int gene=Integer.parseInt(re.getContents());//读取内容
                String diseaseName=dn.getContents();//读取内容
                String drugbankName=dbn.getContents();//读取内容

                //System.out.println(p);

                newNet(drugbankID,diseaseID,drugbankName,diseaseName,p,gene);
            }
            rwb.close();
            str.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "FINISH";
    }

    /**
     *
     * @param drugbankID
     * @param diseaseID
     * @param drugName
     * @param diseaseName
     * @param adjp
     * @param gene
     */
    public void newNet(String drugbankID,String diseaseID,String drugName,String diseaseName,double adjp,int gene){
        Disease disease=diseaseRepository.findByDiseaseId(diseaseID);
        Drug drug=drugRepository.findByDrugbankId(drugbankID);
        if (disease==null){
            disease=new Disease(diseaseName,diseaseID);
        }
        if (drug==null){
            drug=new Drug(drugName,drugbankID);
        }
        Relevant relevant=new Relevant(disease,drug);
        relevant.setProperty(adjp,gene);
        disease.addDrug(relevant);
        drug.addDisease(relevant);
        diseaseRepository.save(disease);
        drugRepository.save(drug);
    }

    public static void main(String[] args0){
        //===============jlx方法=================
        try{
            String realPath="F:\\study\\jidi\\2018\\知识图谱药物\\数据\\决战SCI\\导入mysql.xls";
            File fileDes = new File(realPath);
            InputStream str = new FileInputStream(fileDes);
            // 构造Workbook（工作薄）对象
            Workbook rwb=Workbook.getWorkbook(fileDes);
            //Workbook rwb=Workbook.getWorkbook(str);
            Sheet rs=rwb.getSheet(4);//获取第5张工作表
            int rsRows=rs.getRows();//获取Sheet表中所包含的总行数
            int rsCols=rs.getColumns();//获取Sheet表中所包含的总列数
            //log.info("========行========"+rsRows+"=====列========"+rsCols);
            for(int i=1;i<rsRows;i++){//读取行
                //log.info("========执行第========"+i+"行");

                Cell dbid=rs.getCell(0, i);//定位先列后行
                Cell did=rs.getCell(1, i);//定位先列后行
                Cell adjp=rs.getCell(2, i);//定位先列后行
                Cell re=rs.getCell(3, i);//定位先列后行
                Cell dn=rs.getCell(4, i);//定位先列后行
                Cell dbn=rs.getCell(5, i);//定位先列后行

                String drugbankID=dbid.getContents();//读取内容
                String diseaseID=did.getContents();//读取内容
                double p=Double.parseDouble(adjp.getContents());//读取内容
                int gene=Integer.parseInt(re.getContents());//读取内容
                String diseaseName=dn.getContents();//读取内容
                String drugbankName=dbn.getContents();//读取内容

                //System.out.println(p+"    "+gene);
            }
            rwb.close();
            str.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
