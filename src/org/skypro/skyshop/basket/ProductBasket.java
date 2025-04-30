package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.*;
public class ProductBasket {
    private final Map<String, List<Product>> products;
    public ProductBasket() {
        products = new HashMap<>();
    }
    public void addProduct(Product product) {
        String name = product.getName();
        products.putIfAbsent(name, new ArrayList<>());
        products.get(name).add(product);
    }
    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        List<Product> productList = products.get(name);

        if (productList != null) {
            removedProducts.addAll(productList);
            products.remove(name);
        }
        return removedProducts;
    }
    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
                List<Product> productList = entry.getValue();
                for (Product product : productList) {
                    System.out.println(product.getName());
                }
            }
        }
    }
}