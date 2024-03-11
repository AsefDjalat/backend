package nl.workingtalent.backend.persist;

import org.springframework.data.repository.CrudRepository;

import nl.workingtalent.backend.model.TalentManager;

public interface ITalentManagerRepository extends CrudRepository<TalentManager,Long>  {
	
}
