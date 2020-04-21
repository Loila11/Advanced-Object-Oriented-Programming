package Entities;

public class MealVouchers extends PaymentMethod{
    private double value;
    private int noVouchers;

//    constructor
    public MealVouchers(double value, int noVouchers) {
        this.value = value;
        this.noVouchers = noVouchers;
    }

//    getters
    public double getValue() {
        return value;
    }

    public int getNoVouchers() {
        return noVouchers;
    }

//    setters
    public void setValue(double value) {
        this.value = value;
    }

    public void setNoVouchers(int noVouchers) {
        this.noVouchers = noVouchers;
    }

//    other
    @Override
    public String getPaymentMethod() {
    return "Bonuri de masa";
}

    @Override
    public boolean checkPaymentMethod(double price) {
        return price <= value * noVouchers;
    }
}
