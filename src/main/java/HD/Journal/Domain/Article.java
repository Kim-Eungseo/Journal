package HD.Journal.Domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@NoArgsConstructor
@Entity
public class Article extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false) //VARCHAR(500)
    private String title;

    @Column(columnDefinition = "MEDIUM TEXT", nullable = false) //TEXT
    private String description;

    private String author;

    private String blogName;

    private LocalDateTime pubDate;

    @Builder
    public Article(String title, String description, String author, String blogName, LocalDateTime pubDate) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.blogName = blogName;
        this.pubDate = pubDate;
    }

    public void update(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }
}

