package HD.Journal.Service.Crawler.Implement;

import HD.Journal.Service.Crawler.CrawledDto;
import HD.Journal.Service.Crawler.Crawler;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TistoryCrawler implements Crawler {

    @Override
    public CrawledDto get(String url) {
        return null;
    }

    private static class InnerTistoryCrawler {
        private static final TistoryCrawler t = new TistoryCrawler();
    }

    public static TistoryCrawler getInstance() {
        return InnerTistoryCrawler.t;
    }
}
