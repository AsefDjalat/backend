package nl.workingtalent.backend.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import nl.workingtalent.backend.model.Trainee;
import nl.workingtalent.backend.persist.TraineeService;

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

			//stap 2- update/aanpassen
			if (updateTrainee.getVoornaam() != null) dbTrainee.setVoornaam(updateTrainee.getVoornaam());
			if (updateTrainee.getAchternaam() != null) dbTrainee.setAchternaam(updateTrainee.getAchternaam());
			if (updateTrainee.getLeeftijd() != 0) dbTrainee.setLeeftijd(updateTrainee.getLeeftijd());
			if (updateTrainee.getSpecialisatie() != null) dbTrainee.setSpecialisatie(updateTrainee.getSpecialisatie());
			if (updateTrainee.getWoonplaats() != null) dbTrainee.setWoonplaats(updateTrainee.getWoonplaats());
			if (updateTrainee.getBio() != null) dbTrainee.setBio(updateTrainee.getBio());
			if (updateTrainee.getStatus() != null) dbTrainee.setStatus(updateTrainee.getStatus());

			//stap 3 -opslaan

			service.update(dbTrainee);
		}
	}
	@DeleteMapping(value = "trainee/{id}/delete")
	public void delete(@PathVariable("id") long id) {
		service.delete(id);
		System.out.println("The Trainee with an ID" + id + "has been deleted");
	}

}
