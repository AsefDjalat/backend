package nl.workingtalent.backend;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
