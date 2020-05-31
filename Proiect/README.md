# Software casa de marcat

### Structura claselor
- __Main__: Clasa principala in care declar o casa de marcat (_Checkout_) si initializez toate obiectele aferente.

#### Pachetul Services
- __Checkout__: Clasa de serviciu. Contine lista tuturor tranzactiilor efectuate anterior(ArrayList<_Transaction_>) si o serie de operatii care pot fi facute pe baza acestora:
    - addTransaction(Transaction transaction)
    - calcTotalPrice(Transaction transaction)
    - checkPayment(Transaction transaction)
    - displayItems(Transaction transaction)
    - displayTransaction(Transaction transaction)
    - displayTransactions()
    - displayCardTransactions()
    - displayCashTransactions()
    - displayVoucherTransactions()
- __Audit__: Clasa de serviciu care scrie intr-un fisier de tip CSV de fiecare data cand este executata o actiune / interogare.

#### Pachetul Entities
- __Transaction__: Contine informatii despre produsele care urmeaza a fi achizitionate(ArrayList<_Item_>), clientul caruia ii apartin(_Client_) si metoda de plata pe care planuieste sa o foloseasca(_PaymentMethod_). Include operatiile:
    - getItem(String itemName)
    - addItem(Item item)
    - removeItem(Item item)

- __Client__: Contine informatii despre un client.

- __Item__: Contine informatii despre un produs.

- __DiscountItem__: Mosteneste clasa _Item_.

- __PaymentMethod__: Clasa abstracta, reprezentand metoda de plata. Este clasa parinte pentru _Cash_ si _Card_. Contine metoda:
    - getPaymentMethod()
    - checkPaymentMethod(double price)

- __Cash__: Clasa derivata din _PaymentMethod_.

- __Card__: Clasa derivata din _PaymentMethod_. Contine informatii despre cardul utilizat si functii pentru verificarea validitatii acestora:
    - checkExpMonth()
    - checkExpYear()
    - checkCardNo()

- __MealVouchers__: Clasa derivata din _PaymentMethod_.

- __SortByPrice__, __SortByName__: Doua metode de sortare a listei de produse din magazin.

#### Pachetul IO
- __ReadCards__: Clasa Singleton prin intermediul careia citesc lista de carduri dintr-un fisier de tip CSV.
- __ReadClients__: Clasa Singleton prin intermediul careia citesc lista de clienti dintr-un fisier de tip CSV.
- __ReadItems__: Clasa Singleton prin intermediul careia citesc lista de produse dintr-un fisier de tip CSV.
- __ReadDiscountItems__: Clasa Singleton prin intermediul careia citesc lista de produse aflate la reducere dintr-un fisier de tip CSV.

#### Pachetul Exceptions
- __WrongFormat__: Exceptie ridicata atunci cand fisierul de intrare nu are formatul potrivit.
- __CatchFNFE__: Clasa cu ajutorul careia abordez exceptiile de tipul FileNotFoundException la declararea unui fisier de citire.

#### Pachetul Tables
- __TableCARDS__: Se ocupa de manipularea tabelului cu obiecte din clasa _Card_.
- __TableCLIENTS__: Se ocupa de manipularea tabelului cu obiecte din clasa _Client_.
- __TableITEMS__: Se ocupa de manipularea tabelului cu obiecte din clasa _Item_.
- __TableDISCOUNT_ITEMS__: Se ocupa de manipularea tabelului cu obiecte din clasa _DiscountItem_.

### Alte fisiere
- produse.csv: lista produselor din magazin (care nu sunt la reducere) cu preturile aferente.
- reduse.csv: lista produselor din magazin cu preturile aferente inainte de reducere.
- clienti.csv: lista clientilor care viziteaza frecvent magazinul.
- carduri.csv: lista informatiilor cardurilor introduse deja in sistem de catre clienti.
