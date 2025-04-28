package org.skypro.skyshop;
import org.skypro.skyshop.articles.SearchEngine;
import org.skypro.skyshop.articles.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import java.util.Arrays;
import java.util.List;
public class App {
    public static void main(String[] args) {

        Product apple = new DiscountedProduct("Яблоко", "Яблоки Red Cheaf", 50, 5);
        Product banana = new FixPriceProduct("Банан", "Бананы по фиксированной цене", 99);
        Product pear = new SimpleProduct("Груша", "груша Конференц", 45);

        List<Searchable> productList = Arrays.asList(apple, banana, pear);
        SearchEngine searchEngine = new SearchEngine(productList);
        try {
            List<Searchable> matches = searchEngine.findAllMatches("Груша");
            System.out.println("Найденные товары: " + matches.size());

            ProductBasket basket = new ProductBasket();
            basket.addProduct(apple);
            basket.addProduct(banana);
            basket.addProduct(pear);
            // Удаляем существующий продукт
            removeProductFromBasket(basket, "Яблоко");
            // Выводим содержимое корзины
            printBasketContents(basket);
            // Удаляем несуществующий продукт
            removeProductFromBasket(basket, "Киви");

            printBasketContents(basket);
        } catch (BestResultNotFound e) {
            System.err.println("Ошибка поиска: " + e.getMessage());
        }
    }
    private static void removeProductFromBasket(ProductBasket basket, String productName) {
        List<Product> removedProducts = basket.removeProductsByName(productName);
        System.out.println("Удаленные продукты:");
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст: " + productName);
        } else {
            for (Product removedProduct : removedProducts) {
                System.out.println(removedProduct.getName());
            }
        }
    }
    private static void printBasketContents(ProductBasket basket) {
        System.out.println("Содержимое корзины:");
        basket.printBasket();
    }
}




