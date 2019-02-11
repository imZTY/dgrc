package sci.again.dgrc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author tianyi
 * @date 2018-08-02 00:58
 */
@Entity
public class Research {
    @Id
    private int id;

    @NotBlank
    private String diseaseId;

    @NotBlank
    private String drugbankId;

    @NotBlank
    private String status;

    @NotBlank
    private String title;

    @NotBlank
    private String diseaseName;

    @NotBlank
    private String drugName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDrugbankId() {
        return drugbankId;
    }

    public void setDrugbankId(String drugbankId) {
        this.drugbankId = drugbankId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }
}
