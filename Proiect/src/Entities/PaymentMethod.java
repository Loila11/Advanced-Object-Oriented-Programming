package Entities;

public abstract class PaymentMethod {
    public String getPaymentMethod(){
        return "Unknown";
    }
    public boolean checkPaymentMethod(double price){
        return false;
    }
}
