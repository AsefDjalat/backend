package nl.workingtalent.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private MatchRepository repo;

    public Iterable<Match> findAllMatch(){return repo.findAll();}

    public Optional<Match> findMatchById(long id){ return repo.findById(id);}

    public List<Match> findMatchesByTraineeId(long traineeId) {
        return repo.findByTraineeId(traineeId);
    }

    public List<Match> findMatchesByVacatureId(long vacatureId) {
        return repo.findByVacatureId(vacatureId);
    }
    public Match createMatch(Match newMatch) {
        Optional<Match> existingMatch = repo.findByTraineeIdAndVacatureId(newMatch.getTrainee().getId(), newMatch.getVacature().getId());
        if (existingMatch.isPresent()) {
            throw new RuntimeException("A match with the given trainee and vacature IDs already exists.");
        }
        return repo.save(newMatch);
    }

    public void updateMatch(Match match){repo.save(match);}

    public void deleteMatchbyId(long id){repo.deleteById(id);}
}
