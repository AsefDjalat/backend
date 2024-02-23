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
		private String naam;
		@Column(nullable = false)
		private int leeftijd;
		@Column()
		private boolean trainees;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getNaam() {
			return naam;
		}
		public void setNaam(String naam) {
			this.naam = naam;
		}
		public int getLeeftijd() {
			return leeftijd;
		}
		public void setLeeftijd(int leeftijd) {
			this.leeftijd = leeftijd;
		}
		public boolean getTrainees() {
			return trainees;
		}
		public void setTrainees(boolean trainees) {
			this.trainees = trainees;
		}
		
}
