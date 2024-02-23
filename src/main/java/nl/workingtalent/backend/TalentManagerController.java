package nl.workingtalent.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TalentManagerController {

	@Autowired
	private TalentManagerService service;
	
	@RequestMapping("talentmanager/all")
	public Iterable<TalentManager> findAll(){
		return service.vindAlleTalentManagers();	
	}

}
