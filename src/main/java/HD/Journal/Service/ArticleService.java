package HD.Journal.Service;

import HD.Journal.Domain.Article;
import HD.Journal.Domain.dto.ArticleListResponseDto;
import HD.Journal.Domain.dto.ArticleResponseDto;
import HD.Journal.Domain.dto.ArticleSaveRequestDto;
import HD.Journal.Domain.dto.ArticleUpdateRequestDto;
import HD.Journal.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    public Long save(ArticleSaveRequestDto requestDto) {
        return articleRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ArticleUpdateRequestDto requestDto) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        article.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        articleRepository.delete(article);
    }

    @Transactional
    public ArticleResponseDto findById(Long id) {
        Article entity = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new ArticleResponseDto(entity);
    }

    @Transactional
    public List<ArticleListResponseDto> findAllDesc() {
        return articleRepository.findAllDesc().stream()
                .map(ArticleListResponseDto::new)
                .collect(Collectors.toList());
    }
}