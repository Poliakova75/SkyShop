    package org.skypro.skyshop.product;
    import org.skypro.skyshop.articles.Searchable;
    import java.util.Objects;
    public abstract class Product implements Searchable {
        private final String name;
        private final String description;
        private final boolean special;
        public Product(String name, String description, boolean special) {

            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов");
            }
            this.name = name;
            this.description = description;
            this.special = special;
        }
        public String getName() {
            return name;
        }
        public abstract int getPrice();
        public boolean isSpecial() {
            return special;
        }
        @Override
        public String getSearchTerm() {
            return name + ": " +  description;
        }
        @Override
        public String getContentType() {
            return "PRODUCT";
        }
        @Override
        public String toString() {
            return "Product{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", special=" + special + '}';
        }
        @Override
        public String getStringRepresentation() {
            return name + " — тип " + getContentType();
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Product product)) return false;
            return name.equals(product.name);
        }
        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }



