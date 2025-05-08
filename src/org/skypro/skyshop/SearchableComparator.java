package org.skypro.skyshop;
import org.skypro.skyshop.articles.Searchable;
import java.util.Comparator;
    public class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            int lengthComparison = Integer.compare(o1.getName().length(), o2.getName().length());
            if (lengthComparison != 0) {
                return -lengthComparison; // от длинного к короткому
            }
            return o1.getName().compareTo(o2.getName()); // по имени в алфавитном порядке
        }
    }

