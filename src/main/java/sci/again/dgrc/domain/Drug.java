package sci.again.dgrc.domain;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author Mark Angrish
 */
@NodeEntity
public class Drug {

    @Id
    @GeneratedValue
	private Long id;
	private String academicName;
	private String drugbankId;

	@JsonIgnoreProperties("drug")
	@Relationship(type = "RELEVANT", direction = Relationship.OUTGOING)
	private List<Relevant> relevants;

	public Drug() {
	}

	/**
	 *
	 * @param academicName
	 * @param drugbankId
	 */
	public Drug(String academicName, String drugbankId) {
		this.academicName = academicName;
		this.drugbankId = drugbankId;
	}

	public Long getId() {
		return id;
	}

	public String getAcademicName() {
		return academicName;
	}

	public String getDrugbankId() {
		return drugbankId;
	}


	public List<Relevant> getRelevants() {
		return relevants;
	}

	public void addDisease(Relevant relevant) {
		if (this.relevants == null) {
			this.relevants = new ArrayList<>();
		}
		this.relevants.add(relevant);
	}

	public void dropRelevant(){
		this.relevants=new ArrayList<>();
	}
}