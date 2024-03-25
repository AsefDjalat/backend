package nl.workingtalent.backend.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalent.backend.model.TalentManager;
import nl.workingtalent.backend.model.Trainee;
import nl.workingtalent.backend.persist.TalentManagerService;

@RestController
@CrossOrigin(maxAge = 3600)
public class TalentManagerController {

	@Autowired
	private TalentManagerService service;
	
	@RequestMapping("talentmanager/all")
	public Iterable<TalentManager> findAll(){
		return service.findAllTalentmanagers();	
	}
	
	
	@RequestMapping("talentmanager/{id}")
	public Optional<TalentManager> findById(@PathVariable ("id") long id){
		return service.findById(id);
	}
	@RequestMapping(method = RequestMethod.POST, value="talentmanager/create")
	public TalentManager create(@RequestBody TalentManager newTalentManager) {
		return service.create(newTalentManager);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="talentmanager/{id}/update")
	public void update(@PathVariable("id") long id, @RequestBody TalentManager updateTalentManager) {
		
		Optional<TalentManager> optional = service.findById(id);
		
		if(optional.isPresent()) {
			TalentManager dBTalentManager = optional.get();
			dBTalentManager.setVoornaam(updateTalentManager.getVoornaam());
			dBTalentManager.setAchternaam(updateTalentManager.getAchternaam());
			dBTalentManager.setEmail(updateTalentManager.getEmail());
			dBTalentManager.setTelefoonnummer(updateTalentManager.getEmail());
			dBTalentManager.setLeeftijd(updateTalentManager.getLeeftijd());
			dBTalentManager.setTrainees(updateTalentManager.isTrainees());
			service.update(dBTalentManager);
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="talentmanager/{id}/delete")
	public void delete(@PathVariable("id") long id) {
		
		Optional<TalentManager> optional = service.findById(id);
		
		if(optional.isPresent()) {
		
			service.delete(id);
		}
	}
	
	@RequestMapping("talentmanager/{talentManagerId}/trainees")
	public List<Trainee> getAlltraineesByTalentManagerId(@PathVariable("talentManagerId")long talentManagerId){
		return service.getAlltraineesByTalentManagerId(talentManagerId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value= "/talentmanager/{talentManager_Id}/{trainee_Id}")
	public TalentManager createTraineeForTalentManager(@PathVariable("talentManager_Id") long talentManagerId, @PathVariable("trainee_Id") long traineeId) {
		
	    return service.createTraineeForTalentManager(talentManagerId, traineeId);
	}

}
