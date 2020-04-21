package Entities;

public class Cash extends PaymentMethod {
    private double givenAmount;

//    constructor
    public Cash(double givenAmount) {
        this.givenAmount = givenAmount;
    }

//    getter
    public double getGivenAmount() {
        return givenAmount;
    }

//    setter
    public void setGivenAmount(double givenAmount) {
        this.givenAmount = givenAmount;
    }

//    other
    @Override
    public String getPaymentMethod() {
        return "Cash";
    }

    @Override
    public boolean checkPaymentMethod(double price) {
        return price <= givenAmount;
    }
}
