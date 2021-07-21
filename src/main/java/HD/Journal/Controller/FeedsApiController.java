package HD.Journal.Controller;

import HD.Journal.Domain.dto.FeedsListResponseDto;
import HD.Journal.Domain.dto.FeedsResponseDto;
import HD.Journal.Domain.dto.FeedsSaveRequestDto;
import HD.Journal.Domain.dto.FeedsUpdateRequestDto;
import HD.Journal.Service.FeedsService;
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
public class FeedsApiController {


    private final FeedsService feedsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody FeedsSaveRequestDto requestDto) {
        // {title: abc, content: 밥을 맛나게 먹어따, author: 나}
        return feedsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody FeedsUpdateRequestDto requestDto) {
        return feedsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        feedsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public FeedsResponseDto findById(@PathVariable Long id) {
        return feedsService.findById(id);
    }

    @GetMapping("/api/v1/posts/list")
    public List<FeedsListResponseDto> findAll() {
        return feedsService.findAllDesc();
    }
}
