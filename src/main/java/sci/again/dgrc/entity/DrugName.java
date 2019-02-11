package sci.again.dgrc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author tianyi
 * @date 2018-08-02 00:57
 */
@Entity
public class DrugName {
    @Id
    private int id;

    @NotBlank
    private String acadamicName;

    @NotBlank
    private String drugbankId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcadamicName() {
        return acadamicName;
    }

    public void setAcadamicName(String acadamicName) {
        this.acadamicName = acadamicName;
    }

    public String getDrugbankId() {
        return drugbankId;
    }

    public void setDrugbankId(String drugbankId) {
        this.drugbankId = drugbankId;
    }
}
