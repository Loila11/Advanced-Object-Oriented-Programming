public abstract class PaymentMethod {
    public String getPaymentMethod(){
        return "Unknown";
    }
    public boolean checkPaymentMethod(int price){
        return false;
    }
}
