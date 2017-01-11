package pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stamboom  implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long   id;
	private String roepnaam;
	private String tussenvoegsel;
	private String achternaam;
	
	private Long   partnerId;
	private String partnerRoepnaam;
	private String partnerTussenvoegsel;
	private String partnerAchternaam;
	
	private Long parentId;
	
	private Long level;
	
	public Stamboom() {
		
	}
	public Stamboom(Long id, String roepnaam, String tussenvoegsel, String achternaam, Long partnerId, String partnerRoepnaam, String partnerTussenvoegsel, String partnerAchternaam, Long parentId, Long level) {
		setId(id);
		setRoepaam(roepnaam);
		setTussenvoegsel(tussenvoegsel);
		setAchternaam(achternaam);
		setPartnerId(partnerId);
		setPartnerRoepaam(partnerRoepnaam);
		setPartnerTussenvoegsel(partnerTussenvoegsel);
		setPartnerAchternaam(partnerAchternaam);
		setParentId(parentId);
		setLevel(level);
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setRoepaam(String roepnaam) {
		this.roepnaam = roepnaam;
	}
	
	public String getRoepnaam() {
		return roepnaam;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	
	public String getAchternaam() {
		return achternaam;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}
	
	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerRoepaam(String partnerRoepnaam) {
		this.partnerRoepnaam = partnerRoepnaam;
	}
	
	public String getPartnerRoepnaam() {
		return partnerRoepnaam;
	}

	public void setPartnerTussenvoegsel(String partnerTussenvoegsel) {
		this.partnerTussenvoegsel = partnerTussenvoegsel;
	}
	
	public String getPartnerTussenvoegsel() {
		return partnerTussenvoegsel;
	}

	public void setPartnerAchternaam(String partnerAchternaam) {
		this.partnerAchternaam = partnerAchternaam;
	}
	
	public String getPartnerAchternaam() {
		return partnerAchternaam;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	public Long getParentId() {
		return parentId;
	}

	public void setLevel(Long level) {
		this.level = level;
	}
	
	public Long getLevel() {
		return level;
	}

}
