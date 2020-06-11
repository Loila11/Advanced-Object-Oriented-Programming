package Tables;

import Entities.Item;

import java.sql.*;
import java.util.ArrayList;

public class TableITEMS {
    private static TableITEMS instance = null;
    private Statement statement;
    private Connection connection;

    public static TableITEMS getInstance() {
        if (instance == null) {
            instance = new TableITEMS();
        }
        return instance;
    }

    private TableITEMS() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/items", "root", "root");
            statement = connection.createStatement();
            System.out.println("Successfully connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createItems(ArrayList<Item> items) {
        try {
            statement.execute("create table ITEMS (" +
                    "name varchar(20), " +
                    "price float, " +
                    "ID int);");
            for (Item item : items) {
                addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Item> readItems() {
        ArrayList<Item> items = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select * from ITEMS;");
            while (resultSet.next()) {
                items.add(new Item(resultSet.getString(1), resultSet.getDouble(2), resultSet.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void addItem(Item item) {
        try {
            statement.execute(
                    "insert into ITEMS values('" +
                            item.getName() + "', '" +
                            item.getPrice() + "', '" +
                            item.getID() + "');");
            statement.execute("commit;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeItem(Item item) {
        try {
            statement.execute("delete from ITEMS where ID=" + item.getID() + ";");
            statement.execute("commit;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateItems(Item item) {
        try {
            statement.execute(
                    "update ITEMS set name=" + item.getName() +
                            " where ID=" + item.getID() + ";");
            statement.execute(
                    "update ITEMS set price=" + item.getPrice() +
                            " where ID=" + item.getID() + ";");
            statement.execute("commit;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteItems() {
        try {
            statement.execute("drop table ITEMS;");
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
