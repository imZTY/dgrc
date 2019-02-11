package sci.again.dgrc.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author Mark Angrish
 */
@NodeEntity
public class Disease {

    @Id
    @GeneratedValue
	private Long id;
	private String academicName;
	private String diseaseId;

	@JsonIgnoreProperties("disease")
	@org.neo4j.ogm.annotation.Relationship(type = "RELEVANT", direction = org.neo4j.ogm.annotation.Relationship.INCOMING)
	private List<Relevant> relevants;

	public Disease() {
	}

	/**
	 *
	 * @param academicName
	 * @param diseaseId
	 */
	public Disease(String academicName, String diseaseId) {
		this.academicName = academicName;
		this.diseaseId = diseaseId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getAcademicName() {
		return academicName;
	}

	public String getDiseaseId() {
		return diseaseId;
	}

	public List<Relevant> getRelevants() {
		return relevants;
	}

	public void addDrug(Relevant relevant) {
		if (this.relevants == null) {
			this.relevants = new ArrayList<>();
		}
		this.relevants.add(relevant);
	}

	public void dropRelevant(){
		this.relevants=new ArrayList<>();
	}
}