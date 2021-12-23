package HD.Journal.Controller;

import HD.Journal.Domain.dto.ArticleResponseDto;
import HD.Journal.Repository.ArticleRepository;
import HD.Journal.Service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ArticleApiController {

    private final ArticleService articleService;
    private final ArticleRepository articleRepository;

    @GetMapping("/api/v1/article/{id}")
    public ArticleResponseDto findById(@PathVariable Long id) {
        System.out.println(articleService.findById(id).getAuthor());
        System.out.println(articleService.findById(id).getDescription());
        return articleService.findById(id);
    }

}
