package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercentage;
    public DiscountedProduct(String name, String description, int basePrice, int discountPercentage) {
        super(name, description, true);
        if (basePrice < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной.");
        }
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100");
        }
        this.basePrice = basePrice;
        this.discountPercentage = discountPercentage;
    }
    @Override
    public int getPrice() {
        int discountAmount = (basePrice * discountPercentage) / 100;
        return basePrice - discountAmount;
    }
    public String toString() {
        return getSearchTerm();
    }
}