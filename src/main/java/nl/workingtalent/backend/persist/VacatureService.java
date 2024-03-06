package nl.workingtalent.backend.persist;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalent.backend.model.Vacature;

@Service
public class VacatureService {
	@Autowired
	private IVacatureRepository repo;
	
	public Iterable<Vacature> vindAlleVacature(){
		
		 return repo.findAll();
	}
	
	public Optional<Vacature> findById(long id){
	return repo.findById(id);	}

	public Vacature create(Vacature newVacature) {
	return repo.save(newVacature);
		}

	public void update(Vacature vacature) {
		 repo.save(vacature);
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}

}
