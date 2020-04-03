# Proiect

Software casa de marcat

## Structura claselor
- __Checkout__: Clasa de serviciu. Contine lista tuturor tranzactiilor efectuate anterior(ArrayList<_Transaction_>) si o serie de operatii care pot fi facute pe baza acestora:
    - addTransaction()
    - calcTotalPrice()
    - checkPayment()
    - displayItems()
    - displayTransaction()
    - displayTransactions()
    - displayCardTransactions()
    - displayCashTransactions()
    - displayVoucherTransactions()

- __Transaction__: Contine informatii despre produsele care urmeaza a fi achizitionate(ArrayList<_Item_>), clientul caruia ii apartin(_Client_) si metoda de plata pe care planuieste sa o foloseasca(_PaymentMethod_). Include operatiile:
    - getItem(String itemName)
    - addItem(Item item)
    - removeItem(Item item)

- __Client__: Contine informatii despre un client.

- __Item__: Contine informatii despre un produs.

- __DiscountItem__: Mosteneste clasa _Item_.

- __PaymentMethod__: Clasa abstracta, reprezentand metoda de plata. Este clasa parinte pentru _Cash_ si _Card_. Contine metoda:
    - getPaymentMethod()
    - checkPaymentMethod(int price)

- __Cash__: Clasa derivata din _PaymentMethod_.

- __Card__: Clasa derivata din _PaymentMethod_. Contine informatii despre cardul utilizat si functii pentru verificarea validitatii acestora:
    - checkExpMonth()
    - checkExpYear()
    - checkCardNo()

- __MealVouchers__: Clasa derivata din _PaymentMethod_.

- __SortByPrice__, __SortByName__: doua metode de sortare a listei de produse din magazin.

- __Main__: Clasa principala in care declar o casa de marcat (_Checkout_) si initializez toate obiectele aferente.

## Alte fisiere
- produse.txt: lista produselor din magazin cu preturile aferente.
