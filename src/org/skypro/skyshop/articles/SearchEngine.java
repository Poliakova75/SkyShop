package org.skypro.skyshop.articles;

public class SearchEngine {
    private final Searchable[] items;
    private int itemCount = 0;

    public SearchEngine(int size) {
        items = new Searchable[size];
    }
    public void add(Searchable item) {
        if (itemCount < items.length) {
            items[itemCount++] = item;
        }
    }
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultIndex = 0;

        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                if (resultIndex < 5) {
                    results[resultIndex++] = item;
                } else {
                    break;
                }
            }
        }
        return results;
    }
}
