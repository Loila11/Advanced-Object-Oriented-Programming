package Tables;

import Entities.DiscountItem;
import Entities.Item;

import java.sql.*;
import java.util.ArrayList;

public class TableDISCOUNT_ITEMS {
    private static TableDISCOUNT_ITEMS instance = null;
    private Statement statement;
    private Connection connection;

    public static TableDISCOUNT_ITEMS getInstance() {
        if (instance == null) {
            instance = new TableDISCOUNT_ITEMS();
        }
        return instance;
    }

    private TableDISCOUNT_ITEMS() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/discount_items", "root", "root");
            statement = connection.createStatement();
            System.out.println("Successfully connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createDiscountItems(ArrayList<Item> discountItems) {
        try {
            statement.execute("create table DISCOUNT_ITEMS (" +
                    "name varchar(20), " +
                    "price float, " +
                    "ID int);");
            for (Item discountItem : discountItems) {
                addDiscountItem(discountItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DiscountItem> readDiscountItems() {
        ArrayList<DiscountItem> discountItems = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select * from DISCOUNT_ITEMS;");
            while (resultSet.next()) {
                discountItems.add(new DiscountItem(
                        resultSet.getString(1),
                        resultSet.getDouble(2),
                        resultSet.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discountItems;
    }

    public void addDiscountItem(Item discountItem) {
        try {
            statement.execute(
                    "insert into DISCOUNT_ITEMS values('" +
                            discountItem.getName() + "', '" +
                            discountItem.getPrice() + "', '" +
                            discountItem.getID() + "');");
            statement.execute("commit;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeDiscountItem(DiscountItem discountItem) {
        try {
            statement.execute("delete from DISCOUNT_ITEMS where ID=" + discountItem.getID() + ";");
            statement.execute("commit;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDiscountItems(DiscountItem discountItem) {
        try {
            statement.execute(
                    "update DISCOUNT_ITEMS set name=" + discountItem.getName() +
                            " where ID=" + discountItem.getID() + ";");
            statement.execute(
                    "update DISCOUNT_ITEMS set price=" + discountItem.getPrice() +
                            " where ID=" + discountItem.getID() + ";");
            statement.execute("commit;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDiscountItems() {
        try {
            statement.execute("drop table DISCOUNT_ITEMS;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
