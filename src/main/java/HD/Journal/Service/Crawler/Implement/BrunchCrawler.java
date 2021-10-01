package HD.Journal.Service.Crawler.Implement;

import HD.Journal.Service.Crawler.CrawledDto;
import HD.Journal.Service.Crawler.Crawler;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrunchCrawler implements Crawler {

    @Override
    public CrawledDto get(String url) {
        return null;
    }

    private static class InnerBrunchCrawler {
        private static final BrunchCrawler n = new BrunchCrawler();
    }

    public static BrunchCrawler getInstance() {
        return InnerBrunchCrawler.n;
    }
}
