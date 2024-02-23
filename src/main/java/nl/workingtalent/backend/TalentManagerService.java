package nl.workingtalent.backend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TalentManagerService {
	@Autowired
	private ITalentManagerRepository repo;
	
	public Iterable<TalentManager> vindAlleTalentManagers(){
		//raadplegen van de database!
		 return repo.findAll();
		
	}
}
