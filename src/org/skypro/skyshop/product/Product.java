    package org.skypro.skyshop.product;
    import org.skypro.skyshop.articles.Searchable;
    import java.util.Objects;
    public abstract class Product implements Searchable {
        private final String name;
        private final String description;
        public Product(String name, String description) {

            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов");
            }
            this.name = name;
            this.description = description;
        }
        public String getName() {
            return name;
        }
        public abstract int getPrice();
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
            return "Product{" + "name='" + name + '\'' + ", description='" + description + '\'' + '}';
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



