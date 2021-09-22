package HD.Journal.Domain.dto;

import HD.Journal.Domain.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;
    private String tag;

    public ArticleListResponseDto(Article entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
        this.tag = entity.getTag();
    }
}
