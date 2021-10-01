package HD.Journal.Controller;

import HD.Journal.Domain.dto.ArticleListResponseDto;
import HD.Journal.Domain.dto.ArticleResponseDto;
import HD.Journal.Domain.dto.ArticleSaveRequestDto;
import HD.Journal.Domain.dto.ArticleUpdateRequestDto;
import HD.Journal.Repository.ArticleRepository;
import HD.Journal.Service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleApiController {

    private final ArticleService articleService;
    private final ArticleRepository articleRepository;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody ArticleSaveRequestDto requestDto) {
        return articleService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody ArticleUpdateRequestDto requestDto) {
        return articleService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        articleService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public ArticleResponseDto findById(@PathVariable Long id) {
        return articleService.findById(id);
    }

    @GetMapping("/api/v1/posts/list")
    public List<ArticleListResponseDto> findAll() {
        return articleService.findAllDesc();
    }
}
