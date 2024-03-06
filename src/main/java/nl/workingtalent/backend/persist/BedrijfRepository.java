package nl.workingtalent.backend.persist;

import org.springframework.data.repository.CrudRepository;

import nl.workingtalent.backend.model.Bedrijf;

public interface BedrijfRepository extends CrudRepository<Bedrijf, Long> {

}
