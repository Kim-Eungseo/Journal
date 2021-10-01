package HD.Journal.Service.Crawler;

import HD.Journal.Service.Crawler.Implement.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class CrawlerService {

    // 크롤링 구현체 싱글턴 인스턴스.
    private BrunchCrawler b = BrunchCrawler.getInstance();
    private MediumCrawler m = MediumCrawler.getInstance();
    private NaverBlogCrawler na = NaverBlogCrawler.getInstance();
    private NotionCrawler no = NotionCrawler.getInstance();
    private TistoryCrawler t = TistoryCrawler.getInstance();

    private Crawler crawler;

    CrawledDto get(String url){

        return null;
    }
}
