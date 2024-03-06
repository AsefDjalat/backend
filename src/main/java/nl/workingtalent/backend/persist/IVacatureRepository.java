package nl.workingtalent.backend.persist;

import org.springframework.data.repository.CrudRepository;

import nl.workingtalent.backend.model.Vacature;

public interface IVacatureRepository extends CrudRepository<Vacature,Long> {

}
