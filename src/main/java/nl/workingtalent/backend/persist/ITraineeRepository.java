package nl.workingtalent.backend.persist;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nl.workingtalent.backend.model.Trainee;

public interface ITraineeRepository extends CrudRepository<Trainee, Long> {

	List<Trainee> findAllTraineesByTalentManagerId(long talentManagerId);
	

}
