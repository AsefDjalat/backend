package nl.workingtalent.backend;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class VacatureController {
	@Autowired
	private VacatureService service;
	
	@RequestMapping("vacature/all")
	public Iterable<Vacature> findAll(){
		return service.vindAlleVacature();	
	}
	@RequestMapping("vacature/{id}")
public Optional<Vacature> findById(@PathVariable("id") long id){
	return service.findById(id);
}
@RequestMapping(method = RequestMethod.POST, value= "vacature/create")
public Vacature create(@RequestBody Vacature newVacature) {
	return service.create(newVacature);
	}
@RequestMapping(method = RequestMethod.PUT, value = "vacature/{id}/update")
public void update(@PathVariable("id") long id, @RequestBody Vacature updateVacature) {
	
	Optional<Vacature> optional = service.findById(id);
	if (optional.isPresent()) { 
		Vacature dbVacature = optional.get();
			
	
	    if (updateVacature.getTitel() != null) {
	        dbVacature.setTitel(updateVacature.getTitel());
	    }
		    if (updateVacature.getOmschrijving() != null) {
		        dbVacature.setOmschrijving(updateVacature.getOmschrijving());
		    }
		    if (updateVacature.getContractLengte() != 0) {
	        dbVacature.setContractLengte(updateVacature.getContractLengte());
		    }
		    if (updateVacature.getLocatie() != null) {
		        dbVacature.setLocatie(updateVacature.getLocatie());
		    }
		    if (updateVacature.getTypeWerk() != null) {
		        dbVacature.setTypeWerk(updateVacature.getTypeWerk());
		    }
		    if (updateVacature.getUitStroomrichting() != null) {
		        dbVacature.setUitStroomrichting(updateVacature.getUitStroomrichting());
		    }
		    if (updateVacature.getAantalUren() != 0) {
		        dbVacature.setAantalUren(updateVacature.getAantalUren());
		    }
		
			
			
			
			service.update(dbVacature);
	}
	
		
		
		
	}
}
