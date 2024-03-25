package nl.workingtalent.backend.persist;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import nl.workingtalent.backend.model.TalentManager;
import nl.workingtalent.backend.model.Trainee;

@Service
public class TalentManagerService {
	@Autowired
	private ITalentManagerRepository repo;
	
	@Autowired
	private ITraineeRepository repoTrainee;
	
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

	public List<Trainee> getAlltraineesByTalentManagerId(long talentManagerId) {
		// TODO Auto-generated method stub
		 Optional<TalentManager> optionalTalentManager = repo.findById(talentManagerId);
		 
		 
		 
		 if (optionalTalentManager.isPresent()) {
			 TalentManager dBTalentManager = optionalTalentManager.get();
			 List<Trainee> trainees = dBTalentManager.getTrainee();
			 return trainees;
		 }
		return null;


	}

	public TalentManager createTraineeForTalentManager(long talentManagerId, long traineeId) {
		// TODO Auto-generated method stub
		Optional<TalentManager> optionalTalentManager = repo.findById(talentManagerId);
		
        if(optionalTalentManager.isPresent()) {
        	TalentManager dBTalentManager = optionalTalentManager.get();
        	Optional<Trainee> optionalTrainee = repoTrainee.findById(traineeId);
        	if(optionalTrainee.isPresent()) {
          	Trainee dbTrainee = optionalTrainee.get();
          	dBTalentManager.getTrainee().add(dbTrainee);
          	dBTalentManager.setTrainees(true);
          	repo.save(dBTalentManager);
          	return repo.save(dBTalentManager);
	}
		return null;
        
	}
		return null;
	
	
	

}
}
