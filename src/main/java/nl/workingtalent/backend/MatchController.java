package nl.workingtalent.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService service;

    @GetMapping("/all")
    public Iterable<Match> findAll(){
        return service.findAllMatch();
    }

    @GetMapping("/{id}")
    public Optional<Match> findById(@PathVariable("id") long id){return  service.findMatchById(id);}

    @GetMapping("/trainee_id/{id}")
    public List<Match> findByTraineeId(@PathVariable("id") long id){return  service.findMatchesByTraineeId(id);}

    @GetMapping("/vacature_id/{id}")
    public List<Match> findByVacatureId(@PathVariable("id") long id){ return service.findMatchesByVacatureId(id);}

    @PutMapping("/{id}/update")
    public void update(@PathVariable("id") long id)
}
