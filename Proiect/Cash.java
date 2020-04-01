public class Cash extends PaymentMethod {
    int givenAmount;

//    constructor
    public Cash(int givenAmount) {
        this.givenAmount = givenAmount;
    }

//    getter
    public int getGivenAmount() {
        return givenAmount;
    }

//    setter
    public void setGivenAmount(int givenAmount) {
        this.givenAmount = givenAmount;
    }

//    other
    @Override
    public String getPaymentMethod() {
        return "Cash";
    }

    @Override
    public boolean checkPaymentMethod(int price) {
        return price <= givenAmount;
    }
}
