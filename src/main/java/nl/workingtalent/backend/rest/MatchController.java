package nl.workingtalent.backend.rest;

import nl.workingtalent.backend.model.Match;
import nl.workingtalent.backend.persist.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService service;

    @PostMapping("/create/{trainee_id}/{vacature_id}")
    public ResponseEntity<?> createMatch(@PathVariable("trainee_id") int tid, @PathVariable("vacature_id") int vid) {
        try {
            Match createdMatch = service.createMatch(tid, vid);
            return new ResponseEntity<>(createdMatch, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // If the RuntimeException is thrown by the service, it means a duplicate match was attempted
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            // Handle any other exceptions
            return new ResponseEntity<>("An error occurred while creating the match.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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

//    @PutMapping("/{id}/update")
//    public void update(@PathVariable("id") long id)
}
