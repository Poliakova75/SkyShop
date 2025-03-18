package org.skypro.skyshop.product;
import org.skypro.skyshop.articles.Searchable;
public abstract class Product implements Searchable {
    private final String name;
    private final String description;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public abstract int getPrice();
    public abstract boolean isSpecial();
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

}



