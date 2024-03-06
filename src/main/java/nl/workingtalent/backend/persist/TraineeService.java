package nl.workingtalent.backend.persist;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalent.backend.model.Trainee;

@Service
public class TraineeService {
	@Autowired
	private ITraineeRepository repo;

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
}