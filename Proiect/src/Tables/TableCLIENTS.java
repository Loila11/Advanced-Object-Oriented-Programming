package Tables;

import Entities.Client;

import java.sql.*;
import java.util.ArrayList;

public class TableCLIENTS {
    private static TableCLIENTS instance = null;
    private Statement statement;
    private Connection connection;

    public static TableCLIENTS getInstance() {
        if (instance == null) {
            instance = new TableCLIENTS();
        }
        return instance;
    }

    private TableCLIENTS() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clients");
            statement = connection.createStatement();
            System.out.println("Successfully connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createClients(ArrayList<Client> clients) {
        try {
            statement.execute(
                    "create table CLIENTS (" +
                            "firstName varchar2(20), " +
                            "lastName varchar2(16)" +
                            "ID number(10)");
            for (Client client : clients) {
                addClient(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Client> readClients() {
        ArrayList<Client> clients = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select * from CLIENTS");
            while (resultSet.next()) {
                clients.add(new Client(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void addClient(Client client) {
        try {
            statement.execute(
                    "insert into CLIENTS values(" +
                            client.getFirstName() +
                            client.getLastName() +
                            client.getID());
            statement.execute("commit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeClient(Client client) {
        try {
            statement.execute("delete from CLIENTS where ID=" + client.getID());
            statement.execute("commit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClients(Client client) {
        try {
            statement.execute(
                    "update CLIENTS set firstName=" + client.getFirstName() +
                            " where ID=" + client.getID());
            statement.execute(
                    "update CLIENTS set lastName=" + client.getLastName() +
                            " where ID=" + client.getID());
            statement.execute("commit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClients() {
        try {
            statement.execute("delete CLIENTS");
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
