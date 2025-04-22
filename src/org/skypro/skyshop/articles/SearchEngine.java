package org.skypro.skyshop.articles;
import org.skypro.skyshop.product.BestResultNotFound;
public class SearchEngine {
    private final Searchable[] items;
    public SearchEngine(Searchable[] items) {
        this.items = items;
    }
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        validateSearchTerm(search);
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            if (item != null) {
                int count = countOccurrences(item.getSearchTerm(), search);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = item;
                }
            }
        }
        return getBestMatchResult(bestMatch, search);
    }
    private void validateSearchTerm(String search) {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("Search term cannot be null or empty");
        }
    }
    private Searchable getBestMatchResult(Searchable bestMatch, String search) throws BestResultNotFound {
        if (bestMatch == null) {
            throw new BestResultNotFound("Не найден подходящий товар: " + search);
        }
        return bestMatch;
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
