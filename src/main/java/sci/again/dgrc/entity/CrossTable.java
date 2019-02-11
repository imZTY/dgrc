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
public class CrossTable {
    @Id
    private int id;

    @NotBlank
    private String diseaseId;

    @NotBlank
    private String drugbankId;

    @NotNull
    private int a;
    @NotNull
    private int b;
    @NotNull
    private int c;
    @NotNull
    private int d;

    @NotNull
    private double adjP;

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

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public double getAdjP() {
        return adjP;
    }

    public void setAdjP(double adjP) {
        this.adjP = adjP;
    }
}
