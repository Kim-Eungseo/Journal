package HD.Journal.Repository;

import HD.Journal.Domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT p FROM Article p ORDER BY p.id DESC")
    List<Article> findAllDesc();

    List<Article> findByAuthorAndTitle(String author, String title);

    // select * from FEEDS where author = '응서' and title = 'veryUniv';

    List<Article> findByCreatedDateBefore(LocalDateTime createdDate);


    List<Article> findByAuthorAndTitleOrderByAuthorDesc(String author, String title);

}
