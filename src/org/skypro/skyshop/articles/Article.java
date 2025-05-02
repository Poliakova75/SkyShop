package org.skypro.skyshop.articles;
import java.util.Objects;
public class Article implements Searchable {
    private final String title;
    private final String content;
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
    @Override
    public String getSearchTerm() {
        return title + content;
    }
    @Override
    public String getContentType() {
        return "ARTICLE";
    }
    @Override
    public String getName() {
        return title;
    }
    @Override
    public String getStringRepresentation() {
        return Searchable.super.getStringRepresentation();
    }@Override
    public String toString() {
        return title + ": " + content;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article;
        article = (Article) o;
        return title.equals(article.title);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
