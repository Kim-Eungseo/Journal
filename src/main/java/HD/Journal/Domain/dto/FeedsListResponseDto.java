package HD.Journal.Domain.dto;

import HD.Journal.Domain.Feeds;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FeedsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public FeedsListResponseDto(Feeds entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
