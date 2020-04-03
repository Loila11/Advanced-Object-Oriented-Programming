public class DiscountItem extends Item {
    int discount = 10;

    public DiscountItem(String name, double price) {
        super(name, price);
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
