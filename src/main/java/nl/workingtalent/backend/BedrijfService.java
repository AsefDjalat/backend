package nl.workingtalent.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BedrijfService {
    @Autowired
    private BedrijfRepository repo;

    // Deze methode haalt alle bedrijven op vanuit de repository.
    public Iterable<Bedrijf> findAllBedrijf(){
        return repo.findAll();
    }
    // Deze methode haalt bedrijven op vanuit de repository op basis van ID.
    public Optional<Bedrijf> findBedrijfById(long id){
        return repo.findById(id);
    }
    // Deze methode maakt een nieuw Bedrijf aan
    public Bedrijf create(Bedrijf newBedrijf) {
        return repo.save(newBedrijf);
    }
    // Met deze methode pas je een bestaand Bedrijf aan.
    public void update(Bedrijf bedrijf){
        repo.save(bedrijf);
    }
    public void deleteBedrijfById(long id) {
        repo.deleteById(id);
    }

}
