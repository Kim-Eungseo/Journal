package HD.Journal.Domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public FeedsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
