package org.skypro.skyshop.articles;
import org.skypro.skyshop.SearchableComparator;
import org.skypro.skyshop.product.BestResultNotFound;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;
public class SearchEngine {
    private final Set<Searchable> items;
    public SearchEngine(Set<Searchable> items) {
        this.items = items;
    }
    public Set<Searchable> findAllMatches(String search) throws BestResultNotFound {
        validateSearchTerm(search);
        Supplier<TreeSet<Searchable>> treeSetSupplier = () -> new TreeSet<>(new SearchableComparator());

        Set<Searchable> matches = items.stream()
                .filter(item -> item != null && countOccurrences(item.getSearchTerm(), search) > 0)
                .collect(Collectors.toCollection(treeSetSupplier));

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