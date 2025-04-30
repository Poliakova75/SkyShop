package org.skypro.skyshop;
import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.articles.SearchEngine;
import org.skypro.skyshop.articles.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class App {
    public static void main(String[] args) {

        Product apple = new DiscountedProduct("Яблоко", "Яблоки Red Cheaf", 50, 5);
        Product banana = new FixPriceProduct("Банан", "Бананы по фиксированной цене", 99);
        Product pear = new SimpleProduct("Груша", "груша Конференц", 45);

        Article article1 = new Article("Cтатья о пользе фруктов", "Содержимое статьи 1");
        Article article2 = new Article("Короткая статья", "Содержимое статьи 2");
        Article article3 = new Article("Pro Здоровье ", "Содержимое статьи 3");


        Set<Searchable> searchableItems = new HashSet<>();
        searchableItems.add(apple);
        searchableItems.add(banana);
        searchableItems.add(pear);
        searchableItems.add(article1);
        searchableItems.add(article2);
        searchableItems.add(article3);

        SearchEngine searchEngine = new SearchEngine(searchableItems);
        try {
            Set<Searchable> matches = searchEngine.findAllMatches("Груша");
            System.out.println("Найденные товары: " + matches.size());
            for (Searchable match : matches) {
                System.out.println(match.getStringRepresentation());
            }

            Set<Searchable> articleMatches = searchEngine.findAllMatches("статья");
            System.out.println("Найденные статьи: " + articleMatches.size());
            for (Searchable match : articleMatches) {
                System.out.println(match.getStringRepresentation());
            }

            ProductBasket basket = new ProductBasket();
            basket.addProduct(apple);
            basket.addProduct(banana);
            basket.addProduct(pear);

            removeProductFromBasket(basket, "Яблоко");
            printBasketContents(basket);
            removeProductFromBasket(basket, "Киви");
            printBasketContents(basket);
        } catch (BestResultNotFound e) {
            System.err.println("Ошибка поиска: " + e.getMessage());
        }
    }
        private static void removeProductFromBasket (ProductBasket basket, String productName){
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
        private static void printBasketContents (ProductBasket basket){
                System.out.println("Содержимое корзины:");
                basket.printBasket();
    }
}








