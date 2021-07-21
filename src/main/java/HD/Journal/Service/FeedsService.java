package HD.Journal.Service;

import HD.Journal.Domain.Feeds;
import HD.Journal.Domain.dto.FeedsListResponseDto;
import HD.Journal.Domain.dto.FeedsResponseDto;
import HD.Journal.Domain.dto.FeedsSaveRequestDto;
import HD.Journal.Domain.dto.FeedsUpdateRequestDto;
import HD.Journal.Repository.FeedsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedsService {

    @Autowired
    private FeedsRepository feedsRepository;

    @Transactional
    public Long save(FeedsSaveRequestDto requestDto) {
        //{title: abc, content: 밥을 맛나게 먹어따, author: 나}
        return feedsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, FeedsUpdateRequestDto requestDto) {
        Feeds feeds = feedsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        feeds.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Feeds feeds = feedsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        feedsRepository.delete(feeds);
    }

    @Transactional
    public FeedsResponseDto findById(Long id) {
        Feeds entity = feedsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new FeedsResponseDto(entity);
    }

    @Transactional
    public List<FeedsListResponseDto> findAllDesc() {
        return feedsRepository.findAllDesc().stream()
                .map(FeedsListResponseDto::new)
                .collect(Collectors.toList());
    }
}