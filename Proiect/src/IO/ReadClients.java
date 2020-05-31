package IO;

import Entities.Client;
import Exceptions.CatchFNFE;
import Exceptions.WrongFormat;

import java.util.ArrayList;
import java.util.Scanner;


public class ReadClients {
    private static ReadClients instance = null;
    public ArrayList<Client> clients;

    private ReadClients() {
        while (true) {
            Scanner in = new CatchFNFE("clienti").in;
            clients = new ArrayList<>();
            try {
                while (in.hasNextLine()) {
                    String[] info = in.nextLine().split(",");
                    if (info.length != 2) {
                        throw new WrongFormat();
                    }
                    clients.add(new Client(info[0], info[1]));
                }
                in.close();
                break;
            } catch (WrongFormat | IndexOutOfBoundsException wrongFormat) {
                wrongFormat.printStackTrace();
                clients = new ArrayList<>();
                in.close();
            }
        }
    }

    public static ReadClients getInstance() {
        if (instance == null) {
            instance = new ReadClients();
        }
        return instance;
    }
}
