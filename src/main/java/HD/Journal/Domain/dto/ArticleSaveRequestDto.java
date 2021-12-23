package HD.Journal.Domain.dto;

import HD.Journal.Domain.Article;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleSaveRequestDto {
    private String title;
    private String description;
    private String author;

    @Builder
    public ArticleSaveRequestDto(String title, String description, String author) {
        this.title = title;
        this.description = description;
        this.author = author;

    }

    public Article toEntity() {
        return Article.builder()
                .description(description)
                .author(author)
                .title(title)
                .build();
    }

}