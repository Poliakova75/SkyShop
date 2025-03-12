package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
        private final Product[] products;
        private int productCount;
        public ProductBasket() {
            products = new Product[5];
            productCount = 0;
        }
        public void addProduct(Product product) {
            if (productCount < products.length) {
                products[productCount] = product;
                productCount++;
            } else {
                System.out.println("Невозможно добавить продукт");
            }
        }
        public int getTotalCost() {
            int total = 0;
            for (int i = 0; i < productCount; i++) {
                total += products[i].getPrice();
            }
            return total;
        }
        public void printContents() {
            if (productCount == 0) {
                System.out.println("В корзине пусто.");
                return;
            }
            for (int i = 0; i < productCount; i++) {
                System.out.printf(products[i].getName() + ": " + products[i].getPrice() + "\n");
            }
            System.out.println("Итого: " + getTotalCost());
        }
        public boolean containsProduct(String productName) {
            for (int i = 0; i < productCount; i++) {
                if (products[i].getName().equalsIgnoreCase(productName)) {
                    return true;
                }
            }
            return false;
        }public void clear() {
            for (int i = 0; i < productCount; i++) {
                products[i] = null;
            }
            productCount = 0;
        }
}

