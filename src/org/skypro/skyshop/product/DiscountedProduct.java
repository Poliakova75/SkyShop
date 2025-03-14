package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercentage;

    public DiscountedProduct(String name, int basePrice, int discountPercentage) {
        super(name);
        this.basePrice = basePrice;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public int getPrice() {
        int discountAmount = (basePrice * discountPercentage) / 100;
        return basePrice - discountAmount;
    }
    public String toString (){
        return getName() + ": " + getPrice() + " (" + discountPercentage + ")";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}