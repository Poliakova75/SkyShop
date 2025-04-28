package org.skypro.skyshop.product;
public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 99;
    private final int price;
    public FixPriceProduct(String name, String description, int price) {
        super(name, description);
        this.price = price;
        if (this.price < 0) throw new IllegalArgumentException("Цена не может быть отрицательной");
    }
    @Override
    public int getPrice() {
        return FIX_PRICE;
    }
    public String toString (){
        return getName() + ": Фиксированная цена " + getPrice();
    }
}
