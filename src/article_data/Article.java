package article_data;

public class Article {
    public final String title;
    public final String link;
    public final String summary;

    private Article(String title, String summary, String link) {
        this.title = title;
        this.summary = summary;
        this.link = link;
    }
}