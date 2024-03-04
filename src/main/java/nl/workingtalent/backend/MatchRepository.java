package nl.workingtalent.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByTraineeId(Long traineeId);
    List<Match> findByVacatureId(Long vacatureId);
    Optional<Match> findByTraineeIdAndVacatureId(Long traineeId, Long vacatureId);
}