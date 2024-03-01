package nl.workingtalent.backend;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TalentManagerService {
	@Autowired
	private ITalentManagerRepository repo;
	
	public Iterable<TalentManager> findAllTalentmanagers(){
		//raadplegen van de database!
		 return repo.findAll();
	}
	
	public Optional<TalentManager> findById(long id){
		return repo.findById(id);
	}
	
	public TalentManager create(TalentManager newTalentManager) {
		return repo.save(newTalentManager);
	}
	
	public void update(TalentManager talentManager) {
		repo.save(talentManager);
	}
	public void delete(long id) {
		repo.deleteById(id);
	}
	

}
