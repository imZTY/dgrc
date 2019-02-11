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
public class DiseaseName {
    @Id
    private int id;

    @NotBlank
    private String acadamicName;

    @NotBlank
    private String diseasekId;

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

    public String getDiseasekId() {
        return diseasekId;
    }

    public void setDiseasekId(String diseasekId) {
        this.diseasekId = diseasekId;
    }
}
