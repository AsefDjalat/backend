package nl.workingtalent.backend.persist;

import nl.workingtalent.backend.model.Match;
import nl.workingtalent.backend.model.Trainee;
import nl.workingtalent.backend.model.Vacature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private MatchRepository repo;
    @Autowired
    private ITraineeRepository tRepo;
    @Autowired
    private IVacatureRepository vRepo;

    public Iterable<Match> findAllMatch(){return repo.findAll();}

    public Optional<Match> findMatchById(long id){ return repo.findById(id);}

    public List<Match> findMatchesByTraineeId(long traineeId) {
        return repo.findByTraineeId(traineeId);
    }

    public List<Match> findMatchesByVacatureId(long vacatureId) {
        return repo.findByVacatureId(vacatureId);
    }
    public Match createMatch(long tid, long vid) {
        Trainee T = tRepo.findById(tid).get();
        Vacature V = vRepo.findById(vid).get();
        //hier de check of bestaat.
        Optional<Match> existingMatch = repo.findByTraineeIdAndVacatureId(tid, vid);
        if (existingMatch.isPresent()) {
            // If such a match exists, throw an exception or handle it as per your business logic
            throw new RuntimeException("A match with the given trainee and vacature IDs already exists.");
        }
        Match match = new Match();
        match.setTimestamp(LocalDateTime.now());
        match.setTrainee(T);
        match.setVacature(V);

        return repo.save(match);
    }

    public void updateMatch(Match match){repo.save(match);}

    public void deleteMatchbyId(long id){repo.deleteById(id);}
}
