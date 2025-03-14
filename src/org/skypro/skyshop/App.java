package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

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
        DiscountedProduct apple = new DiscountedProduct("Яблоко", 50, 5);
        FixPriceProduct banana = new FixPriceProduct("Банан");
        SimpleProduct orange = new SimpleProduct("Апельсин", 40);
        SimpleProduct grapes = new SimpleProduct("Виноград", 60);
        SimpleProduct pear = new SimpleProduct("Груша", 45);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(grapes);
        basket.addProduct(pear);

        SimpleProduct pineapple = new SimpleProduct("Ананас", 90);
        basket.addProduct(pineapple);
        return basket;
    }
}

