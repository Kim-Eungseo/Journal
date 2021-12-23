package HD.Journal.Domain.dto;

import HD.Journal.Domain.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleResponseDto {

    private Long id;
    private String title;
    private String description;
    private String author;
    private String blogName;
    private LocalDateTime pubDate;

    public ArticleResponseDto(Article entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.author = entity.getAuthor();
        this.blogName = entity.getBlogName();
        this.pubDate = entity.getPubDate();
    }
}

