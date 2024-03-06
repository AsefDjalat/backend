package nl.workingtalent.backend.persist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.workingtalent.backend.model.Foto;
@Component
public interface IFotoRepository extends CrudRepository<Foto,Long> {

}
