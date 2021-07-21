package HD.Journal.Domain.dto;

import HD.Journal.Domain.Feeds;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public FeedsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Feeds toEntity() {
        return Feeds.builder()
                .content(content)
                .author(author)
                .title(title)
                .build();
    }

}