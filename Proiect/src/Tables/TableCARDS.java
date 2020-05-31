package Tables;

import Entities.Card;

import java.sql.*;
import java.util.ArrayList;

public class TableCARDS {
    private static TableCARDS instance = null;
    private Statement statement;
    private Connection connection;

    public static TableCARDS getInstance() {
        if (instance == null) {
            instance = new TableCARDS();
        }
        return instance;
    }

    private TableCARDS() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cards");
            statement = connection.createStatement();
            System.out.println("Successfully connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCards(ArrayList<Card> cards) {
        try {
            statement.execute(
                    "create table CARDS (" +
                            "name varchar2(20), " +
                            "cardNo varchar2(16)" +
                            "expMonth number(2)" +
                            "expYear number(2)");
            for (Card card : cards) {
                addCard(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Card> readCards() {
        ArrayList<Card> cards = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select * from CARDS");
            while (resultSet.next()) {
                cards.add(new Card(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

    public void addCard(Card card) {
        try {
            statement.execute(
                    "insert into CARDS values(" +
                            card.getName() +
                            card.getCardNo() +
                            card.getExpMonth() +
                            card.getExpYear());
            statement.execute("commit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeCard(Card card) {
        try {
            statement.execute("delete from CARDS where cardNo=" + card.getCardNo());
            statement.execute("commit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCards(Card card) {
        try {
            statement.execute("update CARDS set name=" + card.getName() + " where cardNo=" + card.getCardNo());
            statement.execute("commit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCards() {
        try {
            statement.execute("delete CARDS");
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
