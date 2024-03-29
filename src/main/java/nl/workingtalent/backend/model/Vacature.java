package nl.workingtalent.backend.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

enum UitStroomRichting {
    DevOps,
    Java,
    BigData,
    LowCode,
    InformatieAnalyst,
    CSharp,
    SoftwareTester,
    NietGekozen
}

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
	
	@Column(nullable = false)
	private UitStroomRichting uitStroomRichting = UitStroomRichting.NietGekozen;
	
	private int aantalUren;
	@ManyToOne
	private Bedrijf bedrijf;
	
	private StatusVacature deStatusVacature = StatusVacature.OPEN;
	
	public Bedrijf getBedrijf() {
		return bedrijf;
	}

	public StatusVacature getDeStatusVacature() {
		return deStatusVacature;
	}

	public void setDeStatusVacature(StatusVacature deStatusVacature) {
		this.deStatusVacature = deStatusVacature;
	}

	public void setBedrijf(Bedrijf bedrijf) {
		this.bedrijf = bedrijf;
	}

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


	public UitStroomRichting getUitStroomRichting() {
		return uitStroomRichting;
	}

	public void setUitStroomRichting(UitStroomRichting uitStroomRichting) {
		this.uitStroomRichting = uitStroomRichting;
	}

	public int getAantalUren() {
		return aantalUren;
	}
	public void setAantalUren(int aantalUren) {
		this.aantalUren = aantalUren;
	}
	
	

}
