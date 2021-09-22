package HD.Journal.Domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleUpdateRequestDto {
    private String title;
    private String content;
    private String tag;

    @Builder
    public ArticleUpdateRequestDto(String title, String content, String tag) {
        this.title = title;
        this.content = content;
        this.tag = tag;
    }
}
