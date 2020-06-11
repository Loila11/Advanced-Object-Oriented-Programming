import Entities.*;
import IO.*;
import Services.Checkout;
import Services.GUI;
import Tables.TableCARDS;
import Tables.TableCLIENTS;
import Tables.TableDISCOUNT_ITEMS;
import Tables.TableITEMS;

public class Main {
    public static void main(String[] args) {
        TableCARDS tableCARDS = TableCARDS.getInstance();
        TableCLIENTS tableCLIENTS = TableCLIENTS.getInstance();
        TableITEMS tableITEMS = TableITEMS.getInstance();
        TableDISCOUNT_ITEMS tableDISCOUNT_ITEMS = TableDISCOUNT_ITEMS.getInstance();

        tableCLIENTS.createClients(ReadClients.getInstance().clients);
        tableCARDS.createCards(ReadCards.getInstance().cards);
        tableITEMS.createItems(ReadItems.getInstance().items);
        tableDISCOUNT_ITEMS.createDiscountItems(ReadDiscountItems.getInstance().discountItems);

        System.out.println("Interfata grafica a fost configurata!");

        Checkout checkout = new Checkout(new Transaction(tableCLIENTS.readClients().get(0),
                tableITEMS.readItems(),
                new Cash(50)));
        checkout.addTransaction(new Transaction(tableCLIENTS.readClients().get(1),
                tableITEMS.readItems().get(3),
                tableCARDS.readCards().get(0)));
        tableITEMS.addItem(tableDISCOUNT_ITEMS.readDiscountItems().get(0));
        checkout.addTransaction(new Transaction(tableCLIENTS.readClients().get(2),
                tableITEMS.readItems(),
                new MealVouchers(15.18, 2)));

        GUI image = new GUI(checkout);
        image.setVisible(true);

        tableCLIENTS.deleteClients();
        tableCARDS.deleteCards();
        tableITEMS.deleteItems();
        tableDISCOUNT_ITEMS.deleteDiscountItems();
    }
}
