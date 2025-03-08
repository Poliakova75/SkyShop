package org.skypro.skyshop;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args){
        ProductBasket basket = getProductBasket();
        basket.printContents();

        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());
        System.out.println("Корзина содержит яблоко: " + basket.containsProduct("Яблоко"));
        System.out.println("Корзина содержит манго: " + basket.containsProduct("Манго"));

        basket.clear();
        basket.printContents();

        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalCost());
        System.out.println("Корзина содержит яблоко: " + basket.containsProduct("Яблоко"));
    }

    private static ProductBasket getProductBasket() {
        Product apple = new Product("Яблоко", 50);
        Product banana = new Product("Банан", 30);
        Product orange = new Product("Апельсин", 40);
        Product grapes = new Product("Виноград", 60);
        Product pear = new Product("Груша", 45);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(grapes);
        basket.addProduct(pear);

        Product pineapple = new Product("Ананас", 90);
        basket.addProduct(pineapple);
        return basket;
    }
}

