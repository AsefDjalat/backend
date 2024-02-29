package nl.workingtalent.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class BedrijfController {

    @Autowired
    private BedrijfService service;

    @RequestMapping("bedrijf/all")
    public Iterable<Bedrijf> findAll(){
        return service.findAllBedrijf();
    }

    @RequestMapping("/bedrijf/{id}")
    public Optional<Bedrijf> findById(@PathVariable ("id") long id){
        return  service.findBedrijfById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "bedrijf/create")
    public  Bedrijf create(@RequestBody Bedrijf newBedrijf){
        return service.create(newBedrijf);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "bedrijf/{id}/update")
    public void update(@PathVariable("id") long id, @RequestBody Bedrijf updateBedrijf) {
        //stap 1 - bestand selecteren/openen
        System.out.println("Update request recieved for bedrijf ID " + id);
        Optional<Bedrijf> optional = service.findBedrijfById(id);
        if (optional.isPresent()) { // kijkt of the de optional bestaat!
            Bedrijf dbBedrijf = optional.get(); //haal de trainee uit de optional

            //stap 2- updaten/aanpassen
            dbBedrijf.setNaamBedrijf(updateBedrijf.getNaamBedrijf());
            dbBedrijf.setBranche(updateBedrijf.getBranche());
            dbBedrijf.setLocatie(updateBedrijf.getLocatie());
            dbBedrijf.setBio(updateBedrijf.getBio());
            //stap 3 -opslaan

            service.update(dbBedrijf);
        }
    }
    @DeleteMapping(value = "bedrijf/{id}/delete")
    public void deleteBedrijfById(@PathVariable("id") long id) {
        service.deleteBedrijfById(id);
        System.out.println("Bedrijf ID "+ id + " was DELETED!");
    }
}
