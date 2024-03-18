package nl.workingtalent.backend.persist;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalent.backend.model.Bedrijf;
import nl.workingtalent.backend.model.Vacature;

@Service
public class VacatureService {
	@Autowired
	private IVacatureRepository repo;
	
	 @Autowired
	  private BedrijfRepository bedrijfRepository;
	
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

public List<Vacature> findByBedrijfId(Long bedrijfId) {

return repo.findByBedrijfId(bedrijfId);

}

public Vacature createVacatureForBedrijf(long bedrijfId, Vacature vacature) {
	// TODO Auto-generated method stub
	Bedrijf bedrijf = bedrijfRepository.findById(bedrijfId)
            .orElseThrow(() -> new RuntimeException("Bedrijf not found with ID: " + bedrijfId));


	vacature.setBedrijf(bedrijf);


	return repo.save(vacature);
}
	}


