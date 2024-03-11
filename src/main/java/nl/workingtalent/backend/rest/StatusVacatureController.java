package nl.workingtalent.backend.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalent.backend.model.StatusVacature;
import nl.workingtalent.backend.model.Vacature;

import nl.workingtalent.backend.persist.VacatureService;

@RestController
public class StatusVacatureController {

	
	@Autowired 
	private VacatureService vacatureService;
	
	@RequestMapping("vacature/{id}/status")
	public StatusVacature findVacatureStatusById(@PathVariable("id") long id){
		 Optional<Vacature> optionalVacature = vacatureService.findById(id);
	        if (optionalVacature.isPresent()) {
	            Vacature vacature = optionalVacature.get();
	            return vacature.getDeStatusVacature();
	        }
			return null;
	       
	    }

	


	@RequestMapping(method = RequestMethod.PUT, value = "vacature/{id}/status/update")
	public void updateVacatureStatus(@PathVariable("id") long id, @RequestBody Vacature vacature) {
		System.out.print(vacature);
		 Optional<Vacature> optionalVacature = vacatureService.findById(id);
		 if (optionalVacature.isPresent()) {
	            Vacature dbVacature = optionalVacature.get();
	            dbVacature.setDeStatusVacature(vacature.getDeStatusVacature());
	            vacatureService.update(dbVacature);
	}
	}
	

		

}
