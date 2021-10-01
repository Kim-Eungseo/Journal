package HD.Journal.Service.Crawler;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ImageDto {
    private String imageUrl;
    private String imageCaption;

    @Builder
    public ImageDto(String imageUrl, String imageCaption) {
        this.imageUrl = imageUrl;
        this.imageCaption = imageCaption;
    }
}
