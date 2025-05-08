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
    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            for (Map.Entry<String, Set<Product>> entry : products.entrySet()) {
                Set<Product> productList = entry.getValue();
                for (Product product : productList) {
                    System.out.println(product.getName());
                }
            }
        }
    }
}