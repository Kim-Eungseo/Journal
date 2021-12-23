package HD.Journal.Domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleUpdateRequestDto {
    private String title;
    private String author;
    private String description;
    private String tag;

    @Builder
    public ArticleUpdateRequestDto(String title, String author, String description, String tag) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.tag = tag;
    }
}
