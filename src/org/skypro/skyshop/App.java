package org.skypro.skyshop;
import org.skypro.skyshop.articles.SearchEngine;
import org.skypro.skyshop.articles.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
public class App {
    public static void main(String[] args) {
        Searchable[] items = new Searchable[]{
                new SimpleProduct("Яблоко", "Яблоки Red Cheaf", 50),
                new SimpleProduct("Виноград", "Красный виноград сорта Гренаш", 60),
                new SimpleProduct("Банан", "Бананы по фиксированной цене", 99),
                new SimpleProduct("Груша", "груша Конференц", 45),
        };
        SearchEngine searchEngine = new SearchEngine(items);
        // Поиск существующего объекта
        try {
            String searchTerm = "Яблоко";
            Searchable bestMatch = searchEngine.findBestMatch(searchTerm);
            System.out.println("Лучший найденный элемент: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.err.println(e.getMessage());
        }
        // Поиск несуществующего объекта
        try {
            String searchTerm = "Киви";
            Searchable bestMatch = searchEngine.findBestMatch(searchTerm);
            System.out.println("Лучший найденный элемент: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        getProductBasket();
    }
    private static void getProductBasket() {
        ProductBasket basket = new ProductBasket();
        addProducts(basket);
    }
    private static void addProducts(ProductBasket basket) {
        try {
            // Продукт с корректными данными
            DiscountedProduct apple = new DiscountedProduct("Яблоко", "Яблоки Red Cheaf", 50, 5);
            basket.addProduct(apple);
            // Продукт с неправильной ценой (отрицательная цена)
            FixPriceProduct banana = new FixPriceProduct("Банан", "Бананы по фиксированной цене", 99);
            basket.addProduct(banana);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении продукта: " + e.getMessage());
        }
        try {
            // Другие продукты
            SimpleProduct orange = new SimpleProduct("Апельсин", "Красные апельсины", 40);
            basket.addProduct(orange);
            // Продукт с неправильным значением (отрицательная цена)
            SimpleProduct grapes = new SimpleProduct("Виноград", "Красный виноград сорта Гренаш", -60);
            basket.addProduct(grapes);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении продукта: " + e.getMessage());
        }
        try {
            SimpleProduct pear = new SimpleProduct("Груша", "груша Конференц", 45);
            basket.addProduct(pear);
            SimpleProduct pineapple = new SimpleProduct("Ананас", "", 90);
            basket.addProduct(pineapple);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении продукта: " + e.getMessage());
        }
    }
}



