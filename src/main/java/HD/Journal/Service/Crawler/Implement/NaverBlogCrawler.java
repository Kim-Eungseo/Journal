package HD.Journal.Service.Crawler.Implement;

import HD.Journal.Service.Crawler.CrawledDto;
import HD.Journal.Service.Crawler.Crawler;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NaverBlogCrawler implements Crawler {

    @Override
    public CrawledDto get(String url) {
        return null;
    }

    private static class InnerNaverBlogCrawler {
        private static final NaverBlogCrawler n = new NaverBlogCrawler();
    }

    public static NaverBlogCrawler getInstance() {
        return InnerNaverBlogCrawler.n;
    }

}
