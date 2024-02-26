package nl.workingtalent.backend;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;


@Entity
public class Vacature {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 100, nullable = false)
	private String titel;
	
	private String omschrijving;
	
	private int contractLengte ;
	
	private String locatie;
	
	private String typeWerk;
	
	private String uitStroomrichting;
	
	private int aantalUren;
//	@OneToOne
//	private Bedrijf bedrijf;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	public int getContractLengte() {
		return contractLengte;
	}
	public void setContractLengte(int contractLengte) {
		this.contractLengte = contractLengte;
	}
	public String getLocatie() {
		return locatie;
	}
	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}
	public String getTypeWerk() {
		return typeWerk;
	}
	public void setTypeWerk(String typeWerk) {
		this.typeWerk = typeWerk;
	}
	public String getUitStroomrichting() {
		return uitStroomrichting;
	}
	public void setUitStroomrichting(String uitStroomrichting) {
		this.uitStroomrichting = uitStroomrichting;
	}
	public int getAantalUren() {
		return aantalUren;
	}
	public void setAantalUren(int aantalUren) {
		this.aantalUren = aantalUren;
	}
	
	

}
