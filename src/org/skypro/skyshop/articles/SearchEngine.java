package org.skypro.skyshop.articles;
import org.skypro.skyshop.product.BestResultNotFound;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class SearchEngine {
    private final List<Searchable> items;
    public SearchEngine(List<Searchable> items) {
        this.items = items;
    }
    public Map<String, Searchable> findAllMatches(String search) throws BestResultNotFound {
        validateSearchTerm(search);
        Map<String, Searchable> matches = new TreeMap<>();

        for (Searchable item : items) {
            if (item != null && countOccurrences(item.getSearchTerm(), search) > 0) {
                matches.put(item.getSearchTerm(), item);
            }
        }
        if (matches.isEmpty()) {
            throw new BestResultNotFound("Не найден подходящий товар: " + search);
        }
        return  matches;
    }
    private void validateSearchTerm(String search) {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым");
        }
    }
    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.toLowerCase().indexOf(substring.toLowerCase(), index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }
}