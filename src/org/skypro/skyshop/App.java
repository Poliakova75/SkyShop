package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.articles.SearchEngine;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = getProductBasket();
        basket.printContents();

        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());
        System.out.println("Корзина содержит яблоко: " + basket.containsProduct("Яблоко"));
        System.out.println("Корзина содержит манго: " + basket.containsProduct("Манго"));

        basket.clear();
        basket.printContents();

        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalCost());
        System.out.println("Корзина содержит яблоко: " + basket.containsProduct("Яблоко"));
        testSearch();
    }

    private static ProductBasket getProductBasket() {
        DiscountedProduct apple = new DiscountedProduct("Яблоко", "Яблоки Red Cheaf", 50, 5);
        FixPriceProduct banana = new FixPriceProduct("Банан", "Бананы по фиксированной цене");
        SimpleProduct orange = new SimpleProduct("Апельсин", "Красные апельсины", 40);
        SimpleProduct grapes = new SimpleProduct("Виноград", "Красный виноград сорта Гренаш", 60);
        SimpleProduct pear = new SimpleProduct("Груша", "груша Конференц", 45);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(grapes);
        basket.addProduct(pear);

        SimpleProduct pineapple = new SimpleProduct("Ананас", "",  90);
        basket.addProduct(pineapple);
        return basket;
    }

    private static void testSearch() {
        SearchEngine searchEngine = new SearchEngine(5);

        searchEngine.add(new DiscountedProduct("Яблоко", "Яблоки Red Cheaf", 50, 5));
        searchEngine.add(new FixPriceProduct("Банан", "Бананы по фиксированной цене"));
        searchEngine.add(new SimpleProduct("Виноград", "Красный виноград сорта Гренаш", 60));

        searchEngine.add(new Article("Польза винограда", "Какой сорт винограда выбрать"));
        searchEngine.add(new Article("Pro Здоровье", "Топ 5 фруктов для укрепления иммунитета"));

        System.out.println(Arrays.toString(searchEngine.search("Яблоко")));
        System.out.println(Arrays.toString(searchEngine.search("Польза винограда")));
        System.out.println(Arrays.toString(searchEngine.search("Pro Здоровье")));
    }
}




