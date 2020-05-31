package Entities;

public class DiscountItem extends Item {
    private int discount = 10;

//    constructor
    public DiscountItem(String name, double price) {
        super(name, price);
    }

    public DiscountItem(String name, double price, int ID) {
        super(name, price, ID);
    }

//    setter
    public void setDiscount(int discount) {
        this.discount = discount;
    }

//    getter
    public int getDiscount() {
        return discount;
    }

//    other
    @Override
    public double getPrice() {
        return super.getPrice() - super.getPrice() * discount / 100;
    }
}
