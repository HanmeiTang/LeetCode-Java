package ood;

import java.io.IOException;

// Constant value --> Constant objects
public enum NewsRSSFeedEnum {
    YAHOO_TOP_STORIES("https://rss.news.yahoo.com/rss/topstories"),
    CBS_TOP_STORIES("https://feeds.cbsnews.com/CBSNewsMain?format=xml"),
    LATIMES_TOP_STORIES("https://feeds.latimes.com/latimes/news?format=xml");

    private String rssUrl;

    private NewsRSSFeedEnum(String rss) {
        this.rssUrl = rss;
    }

//    public String fetch() {
//        // fetch from this.rssUrl
//        HttpReader myReader = new HttpReader(this.rssUrl);
//        try {
//            return myReader.fetch();
//        } catch (IOException ioe) {
//            LOG.warn(ioe);
//        } finally {
//            myReader.close();
//        }
//    }
//
//    public static void main(String[] args) {
//        List<NewsItem> results = parse(NewsRSSFeedEnum.YAHOO_TOP_STORIES.fetch());
//        itemList.add(results);
//    }
}
