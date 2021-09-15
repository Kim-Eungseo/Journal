package HD.Journal;

import HD.Journal.Domain.Article;
import HD.Journal.Repository.ArticleRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @After
    public void cleanup() {
        articleRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        articleRepository.save(Article.builder()
                .author("easy")
                .content(content)
                .title(title)
                .build());

        //when
        List<Article> articleList = articleRepository.findAll();


        //then
        Article article = articleList.get(0);
        assertThat(article.getTitle()).isEqualTo(title);
        assertThat(article.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2021, 7, 18, 0, 0, 0);
        articleRepository.save(Article.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        //when
        List<Article> articleList = articleRepository.findAll();

        //then
        Article article = articleList.get(0);

        System.out.println(">>>>>>>>> createDate=" + article.getCreatedDate() + ", modifiedDate=" + article.getModifiedDate());

        assertThat(article.getCreatedDate()).isAfter(now);
        assertThat(article.getModifiedDate()).isAfter(now);
    }
}
