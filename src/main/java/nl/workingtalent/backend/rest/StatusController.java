package nl.workingtalent.backend.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalent.backend.model.Trainee;

@RestController
public class StatusController {
	
	@RequestMapping("status")
	public String status(){
		return "OK";
	}
	
	
	@RequestMapping("status2")
	public String status2(){
		return "Heey Alles goed?";
	}
	@RequestMapping("status3")
	public String status3(){
		return "Ja lekker met jou ook?";
	}
	@RequestMapping("trainee")
	public Trainee createtrainee() {
		Trainee trainee = new Trainee();
		trainee.setVoornaam("Mario");
		trainee.setLeeftijd(36);
		return trainee;
	}
}


