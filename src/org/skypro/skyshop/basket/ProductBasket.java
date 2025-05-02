package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.*;
public class ProductBasket {
    private final Map<String, Set<Product>> products;
    public ProductBasket() {
        products = new HashMap<>();
    }
    public void addProduct(Product product) {
        String name = product.getName();
        products.putIfAbsent(name, new HashSet<>());
        products.get(name).add(product);
    }
    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Set<Product> productSet = products.get(name);

        if (productSet != null) {
            removedProducts.addAll(productSet);
            products.remove(name);
        }
        return removedProducts;
    }
    public int getTotalCost() {
        return products.values().stream()
                .flatMap(Set::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }
    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            products.values().stream()
                    .flatMap(Set::stream)
                    .forEach(product -> System.out.println(product.getName()));
        }
        int specialCount = (int) getSpecialCount();
        System.out.println("Количество специальных продуктов: " + specialCount);
    }
    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(Set::stream)
                .filter(Product::isSpecial)
                .count();
    }
}


