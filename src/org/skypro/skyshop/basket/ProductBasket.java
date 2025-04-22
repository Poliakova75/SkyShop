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
}

