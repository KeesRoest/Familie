package pojo;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Relation
 *
 */
@Entity
public class Relation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;

	private String relatieType;
	
	private Boolean partner;

	@ManyToOne
	private Person person1;

	@ManyToOne
	private Person person2;

	public Relation() {
	}

	public Relation(String relatieType, Boolean partner, Person person1, Person person2) {
		setRelatieType(relatieType);
		setPartner(partner);
		setPerson1(person1);
		setPerson2(person2);
	}

	public String getRelatieType() {
		return this.relatieType;
	}

	public void setRelatieType(String relatieType) {
		this.relatieType = relatieType;
	}

	public Boolean isPartner() {
		return this.partner;
	}

	public void setPartner(Boolean partner) {
		this.partner = partner;
	}

	public Person getPerson1() {
		return this.person1;
	}

	public void setPerson1(Person person1) {
		this.person1 = person1;
	}

	public Person getPerson2() {
		return this.person2;
	}

	public void setPerson2(Person person2) {
		this.person2 = person2;
	}

}
