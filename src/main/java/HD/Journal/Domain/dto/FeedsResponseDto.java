package HD.Journal.Domain.dto;

import HD.Journal.Domain.Feeds;
import lombok.Getter;

@Getter
public class FeedsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public FeedsResponseDto(Feeds entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}

