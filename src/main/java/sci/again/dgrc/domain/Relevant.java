package sci.again.dgrc.domain;

import org.neo4j.ogm.annotation.*;

/**
 * @author Mark Angrish
 */
@RelationshipEntity(type = "RELEVANT")
public class Relevant {

    @Id
    @GeneratedValue
	private Long id;
	private double adj_p;
	private int relevant_gene_num;

	@StartNode
	private Drug drug;

	@EndNode
	private Disease disease;

	public Relevant() {
	}

	/**
	 *
	 * @param disease
	 * @param drug
	 */
	public Relevant(Disease disease, Drug drug) {
		this.disease = disease;
		this.drug = drug;
	}

	public Long getId() {
	    return id;
	}

	public double getAdj_p() {
	    return adj_p;
	}

	public int getRelevant_gene_num() {
		return relevant_gene_num;
	}

	public Drug getDrug() {
	    return drug;
	}

	public Disease getDisease() {
	    return disease;
	}

	/**
	 *
	 * @param adj_p
	 * @param relevant_gene_num
	 */
    public void setProperty(double adj_p,int relevant_gene_num) {
		this.relevant_gene_num =relevant_gene_num;
        this.adj_p =adj_p;
    }
}