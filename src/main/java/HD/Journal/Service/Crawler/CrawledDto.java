package HD.Journal.Service.Crawler;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
public class CrawledDto {
    private String title;
    private ArrayList<ImageDto> imageUrls;
    private ArrayList<String> texts;

    @Builder
    public CrawledDto(String title, ArrayList<ImageDto> imageUrls, ArrayList<String> texts) {
        this.title = title;
        this.imageUrls = imageUrls;
        this.texts = texts;
    }
}
