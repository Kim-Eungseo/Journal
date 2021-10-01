package HD.Journal.Service.Crawler.Implement;

import HD.Journal.Service.Crawler.CrawledDto;
import HD.Journal.Service.Crawler.Crawler;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotionCrawler implements Crawler {

    @Override
    public CrawledDto get(String url) {
        return null;
    }

    private static class InnerNotionCrawler {
        private static final NotionCrawler n = new NotionCrawler();
    }

    public static NotionCrawler getInstance() {
        return InnerNotionCrawler.n;
    }
}
