package nl.workingtalent.backend.persist;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalent.backend.model.TalentManager;
import nl.workingtalent.backend.model.Trainee;

@Service
public class TraineeService {
	@Autowired
	private ITraineeRepository repo;
	
	@Autowired
    private ITalentManagerRepository talentManagerRepository;

	public Iterable<Trainee> vindAlleTrainees() {
		//raadplegen van de database!
		return repo.findAll();

	}

	public Optional<Trainee> findById(long id) {
		// security, Permissies
		return repo.findById(id);
	}

	public Trainee create(Trainee newTrainee) {
		return repo.save(newTrainee);
	}

	public void update(Trainee trainee) {
		repo.save(trainee);
	}

	public void delete(long id) {
		repo.deleteById(id);
	}

	public List<Trainee> getAlltraineesByTalentManagerId(long talentManagerId) {
		// TODO Auto-generated method stub
		 TalentManager talentManager = talentManagerRepository.findById(talentManagerId)
	                .orElse(null);

	        if (talentManager == null) {
	            System.out.println("TalentManager with ID " + talentManagerId + " does not exist.");
	            return Collections.emptyList();
	        }

	        List<Trainee> trainees = talentManager.getTrainee();
	        if (trainees.isEmpty()) {
	            System.out.println("TalentManager with ID " + talentManagerId + " has no trainees.");
	        }
		return repo.findAllTraineesByTalentManagerId(talentManagerId);
	}

	public Trainee createTraineeForTalentManager(long talentManagerId, long traineeId) {
		// TODO Auto-generated method stub
		
		Optional<TalentManager> optionalTalentManager = talentManagerRepository.findById(talentManagerId);
		
        if(optionalTalentManager.isPresent()) {
        	TalentManager dBTalentManager = optionalTalentManager.get();
        	
        	 if (dBTalentManager.getTrainee().isEmpty()) {
                 System.out.println("TalentManager with ID " + talentManagerId + " has no trainees.");
             } else {
               
                 for (Trainee trainee : dBTalentManager.getTrainee()) {
                     if (trainee.getId() == traineeId) {
                         System.out.println("TalentManager with ID " + talentManagerId + " already has Trainee with ID " + traineeId);
                         return null;
                     }
                 }
             }
        	  Optional<Trainee> optionalTrainee = repo.findById(traineeId);
              if(optionalTrainee.isPresent()) {
              	Trainee dbTrainee = optionalTrainee.get();
              	dbTrainee.setTalentManager(dBTalentManager);
              	return repo.save(dbTrainee);
              }else {
                  System.out.println("Trainee with ID " + traineeId + " does not exist.");
                  return null;
              }
        }else {
            System.out.println("TalentManager with ID " + talentManagerId + " does not exist.");
            return null;
        }   
      
	}
}