package nl.workingtalent.backend.persist;

import org.springframework.data.repository.CrudRepository;

import nl.workingtalent.backend.model.Trainee;

public interface ITraineeRepository extends CrudRepository<Trainee, Long> {
	

}
