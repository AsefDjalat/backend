package nl.workingtalent.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;



@Entity
public class Trainee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 100, nullable = false)
	private String voornaam;
	@Column(length = 100, nullable = false)
	private String achternaam;
	@Column(length = 250, nullable = false)
	private String specialisatie;
	@Column(length = 100, nullable = false)
	private String woonplaats;
	@Column(length = 2500 , nullable = false)
	private String bio;
	@Column(nullable = false)
	private int leeftijd;
	
	@ManyToOne
	 private TalentManager talentManager;
	
	public TalentManager getTalentManager() {
		return talentManager;
	}
	public void setTalentManager(TalentManager talentManager) {
		this.talentManager = talentManager;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public int getLeeftijd() {
		return leeftijd;
	}
	public void setLeeftijd(int leeftijd) {
		this.leeftijd = leeftijd;
	}
	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getSpecialisatie() {
		return specialisatie;
	}

	public void setSpecialisatie(String specialisatie) {
		this.specialisatie = specialisatie;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

}
