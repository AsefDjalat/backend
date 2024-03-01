package nl.workingtalent.backend;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TalentManager {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(length = 100, nullable = false)
		private String voornaam;
		
		@Column(length = 100, nullable = false)
		private String achternaam;
		
		@Column(length = 100)
		private String email;
		
		@Column(length = 100)
		private String telefoonnummer;
		
		@Column(nullable = false)
		private int leeftijd;
		
		@Column()
		private boolean trainees;
		public long getId() {
			return id;
		}
		
		
		public String getVoornaam() {
			return voornaam;
		}
		public void setVoornaam(String voornaam) {
			this.voornaam = voornaam;
		}
		public String getAchternaam() {
			return achternaam;
		}
		public void setAchternaam(String achternaam) {
			this.achternaam = achternaam;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTelefoonnummer() {
			return telefoonnummer;
		}
		public void setTelefoonnummer(String telefoonnummer) {
			this.telefoonnummer = telefoonnummer;
		}
		public int getLeeftijd() {
			return leeftijd;
		}
		public void setLeeftijd(int leeftijd) {
			this.leeftijd = leeftijd;
		}
		public boolean isTrainees() {
			return trainees;
		}
		public void setTrainees(boolean trainees) {
			this.trainees = trainees;
		}
		public void setId(long id) {
			this.id = id;
		}
				
}
