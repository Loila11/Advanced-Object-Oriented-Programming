package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import static java.lang.Integer.parseInt;

public class Card extends PaymentMethod {
    private String name, cardNo;
    private int expMonth, expYear;

//    constructor
    public Card(String name, String cardNo, int expMonth, int expYear) {
        this.name = name;
        this.cardNo = cardNo;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

//    getters
    public String getName() {
        return name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public int getExpYear() {
        return expYear;
    }

//    setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public void setExpMonth(int expMonth) {
        this.expMonth = expMonth;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

//    checkers
    public boolean checkExpMonth() {
        SimpleDateFormat format = new SimpleDateFormat("YYYY");
        int thisYr = parseInt(format.format(new Date()));
        format = new SimpleDateFormat("MM");
        int thisMth = parseInt(format.format(new Date()));

        if (thisYr == expYear && thisMth < expMonth) {
            return false;
        }
        return 0 < expMonth && expMonth < 13;
    }

    public boolean checkExpYear() {
        SimpleDateFormat format = new SimpleDateFormat("YYYY");
        int thisYr = parseInt(format.format(new Date()));

        if (expYear > 99 && expYear / 100 != thisYr / 100) {
            return false;
        }
        expYear %= 100;
        return expYear < thisYr % 100;
    }
    
    public boolean checkCardNo() {
        int chNum = 0;
        String[] cardNo = this.cardNo.split("\\s+");
        for (String s : cardNo) {
            for (int j = 0; j < s.length(); j++) {
                if (!Character.isDigit(s.charAt(j))) {
                    return false;
                }
                chNum ++;
            }
        }
        return chNum == 16;
    }

//    other
    @Override
    public String getPaymentMethod() {
        return "Card";
    }

    @Override
    public boolean checkPaymentMethod(double price) {
        return checkCardNo() && checkExpYear() && checkExpMonth();
    }
}
