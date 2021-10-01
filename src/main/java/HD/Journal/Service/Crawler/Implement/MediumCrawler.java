package HD.Journal.Service.Crawler.Implement;

import HD.Journal.Service.Crawler.CrawledDto;
import HD.Journal.Service.Crawler.Crawler;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MediumCrawler implements Crawler {

    @Override
    public CrawledDto get(String url) {
        return null;
    }

    private static class InnerMediumCrawler {
        private static final MediumCrawler m = new MediumCrawler();
    }

    public static MediumCrawler getInstance() {
        return InnerMediumCrawler.m;
    }

}
