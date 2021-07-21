package HD.Journal;

import HD.Journal.Domain.Feeds;
import HD.Journal.Repository.FeedsRepository;
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
public class FeedsRepositoryTest {

    @Autowired
    FeedsRepository feedsRepository;

    @After
    public void cleanup() {
        feedsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        feedsRepository.save(Feeds.builder()
                .author("easy")
                .content(content)
                .title(title)
                .build());

        //when
        List<Feeds> feedsList = feedsRepository.findAll();


        //then
        Feeds feeds = feedsList.get(0);
        assertThat(feeds.getTitle()).isEqualTo(title);
        assertThat(feeds.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2021, 7, 18, 0, 0, 0);
        feedsRepository.save(Feeds.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        //when
        List<Feeds> feedsList = feedsRepository.findAll();

        //then
        Feeds feeds = feedsList.get(0);

        System.out.println(">>>>>>>>> createDate=" + feeds.getCreatedDate() + ", modifiedDate=" + feeds.getModifiedDate());

        assertThat(feeds.getCreatedDate()).isAfter(now);
        assertThat(feeds.getModifiedDate()).isAfter(now);
    }
}
