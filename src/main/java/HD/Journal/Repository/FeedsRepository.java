package HD.Journal.Repository;

import HD.Journal.Domain.Feeds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedsRepository extends JpaRepository<Feeds, Long> {

    @Query("SELECT p FROM Feeds p ORDER BY p.id DESC")
    List<Feeds> findAllDesc();
}
