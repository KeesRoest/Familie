package pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private String geslacht;
	private String doopnaam;
	private String roepnaam;
	private String tussenvoegsel;
	private String achternaam;
	private String straatnaam;
	private int huisnr;
	private String huisnrtoev;
	private String postcode;
	private String plaatsnaam;
	private String staat;
	private String land;
	private String telefoon;
	private LocalDate geboortedatum;
	private String geboorteplaats;
	private LocalDate overlijdensdatum;
	private String email;
	private String password;
	
	public Person() {}
	
	public Person(String aGeslacht, String aDoopnaam, String aRoepnaam, String aTussenvoegsel, String aAchternaam, String aStraatnaam, 
				  int aHuisnr, String aHuisnrtoev, String aPostcode, String aPlaatsnaam, String aStaat, String aLand, String aTelefoon, 
				  String aGeboortedatum, String aGeboorteplaats, String aOverlijdensdatum, String aEmail, String aPassword) {
		setGeslacht(aGeslacht);
		setDoopnaam(aDoopnaam);
		setRoepnaam(aRoepnaam);
		setTussenvoegsel(aTussenvoegsel);
		setAchternaam(aAchternaam);
		setStraatnaam(aStraatnaam);
		setHuisnr(aHuisnr);
		setHuisnrtoev(aHuisnrtoev);
		setPostcode(aPostcode);
		setPlaatsnaam(aPlaatsnaam);
		setStaat(aStaat);
		setLand(aLand);
		setTelefoon(aTelefoon);
		setGeboortedatum(aGeboortedatum);
		setGeboorteplaats(aGeboorteplaats);
		setOverlijdensdatum(aOverlijdensdatum);
		setEmail(aEmail);
		setPassword(aPassword);
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGeslacht() {
		return geslacht;
	}

	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}

	public String getDoopnaam() {
		return doopnaam;
	}

	public void setDoopnaam(String doopnaam) {
		this.doopnaam = doopnaam;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getStraatnaam() {
		return straatnaam;
	}

	public void setStraatnaam(String straatnaam) {
		this.straatnaam = straatnaam;
	}

	public int getHuisnr() {
		return huisnr;
	}

	public void setHuisnr(int huisnr) {
		this.huisnr = huisnr;
	}

	public String getHuisnrtoev() {
		return huisnrtoev;
	}

	public void setHuisnrtoev(String huisnrtoev) {
		this.huisnrtoev = huisnrtoev;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPlaatsnaam() {
		return plaatsnaam;
	}

	public void setPlaatsnaam(String plaatsnaam) {
		this.plaatsnaam = plaatsnaam;
	}

	public String getStaat() {
		return staat;
	}

	public void setStaat(String staat) {
		this.staat = staat;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public String getTelefoon() {
		return telefoon;
	}

	public void setTelefoon(String telefoon) {
		this.telefoon = telefoon;
	}

	public String getGeboortedatum() {
		if (geboortedatum == null) {
			return "";
		}
		else {
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String strDate = dateFormat.format(geboortedatum);
			return strDate;
		}
	}

	public void setGeboortedatum(String geboortedatum) {
		this.geboortedatum = LocalDate.parse(geboortedatum);
	}

	public String getOverlijdensdatum() {
		if (overlijdensdatum == null) {
			return "";
		}
		else {
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String strDate = dateFormat.format(overlijdensdatum);
			return strDate;
		}
	}

	public void setOverlijdensdatum(String overlijdensdatum) {
		if (overlijdensdatum == "") {
			this.overlijdensdatum = null;
		}
		else {
			this.overlijdensdatum = LocalDate.parse(overlijdensdatum);
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGeboorteplaats() {
		return geboorteplaats;
	}

	public void setGeboorteplaats(String geboorteplaats) {
		this.geboorteplaats = geboorteplaats;
	}

	public String getRoepnaam() {
		return roepnaam;
	}

	public void setRoepnaam(String roepnaam) {
		this.roepnaam = roepnaam;
	}
}
