package nl.workingtalent.backend;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
public class TraineeController {
	
	@Autowired
	private TraineeService service;
	
	@RequestMapping("trainee/all")
	public Iterable<Trainee> findAll(){
		return service.vindAlleTrainees();	
	}
	
	@RequestMapping("trainee/{id}")
	public Optional<Trainee > findById(@PathVariable ("id") long id){
		return service.findById(id);
	}
	@RequestMapping(method = RequestMethod.POST, value= "trainee/create")
	public Trainee create(@RequestBody Trainee newTrainee) {
		return service.create(newTrainee);
		
		
	}
	@RequestMapping(method = RequestMethod.PUT, value = "trainee/{id}/update")
	public void update(@PathVariable("id") long id, @RequestBody Trainee updateTrainee) {
		//stap 1 - bestand selecteren/openen
		Optional<Trainee> optional = service.findById(id);
		if (optional.isPresent()) { // kijkt of the de optional bestaat!
			Trainee dbTrainee = optional.get(); //haal de trainee uit de optional
			
			//stap 2- updaten/aanpassen
			dbTrainee.setVoornaam(updateTrainee.getVoornaam());
			dbTrainee.setLeeftijd(updateTrainee.getLeeftijd());
		//stap 3 -opslaan
			
			service.update(dbTrainee);
		}
	
		
		
		
	}
	
}
