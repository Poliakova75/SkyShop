package org.skypro.skyshop.product;
public class SimpleProduct extends Product {
    private final int price;
    public SimpleProduct (String name, String description, int price) {
        super(name, description, false);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        this.price = price;
    }
    @Override
    public int getPrice() {
        return price;
    }
    public String toString (){
        return getName() + ": " + getPrice();
    }
}
