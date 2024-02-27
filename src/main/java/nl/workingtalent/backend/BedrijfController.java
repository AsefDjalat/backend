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
        return  service.findByID(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "bedrijf/create")
    public  Bedrijf create(@RequestBody Bedrijf newBedrijf){
        return service.create(newBedrijf);
    }

//    @RequestMapping(method = RequestMethod.PUT, value = "bedrijf/{id}/update")
//    public void update(@PathVariable("id") long id, RequestBody Bedrijf updateBedrijf){
//        Optional<Bedrijf> optional = service.findByID(id);
//        if (optional.isPresent()){
//            Bedrijf dbBedrijf = optional.get();
//
//            dbBedrijf.setNaamBedrijf(updateBedrijf.getNaamBedrijf());
//
//            service.update(dbBedrijf);
//        }
//    }
}
