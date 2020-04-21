package Input;

import Entities.Card;
import Exceptions.CatchFNFE;
import Exceptions.WrongFormat;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ReadCards {
    private static ReadCards instance = null;
    public ArrayList<Card> cards;

    private ReadCards() {
        while (true) {
            Scanner in = new CatchFNFE("carduri").in;
            cards = new ArrayList<>();
            try {
                while (in.hasNextLine()) {
                    String[] info = in.nextLine().split(",");
                    if (info.length != 4) {
                        throw new WrongFormat();
                    }
                    cards.add(new Card(info[0], info[1], parseInt(info[2]), parseInt(info[3])));
                }
                in.close();
                break;
            } catch (WrongFormat | IndexOutOfBoundsException | NumberFormatException wrongFormat) {
                wrongFormat.printStackTrace();
                cards = new ArrayList<>();
                in.close();
            }
        }
    }

    public static ReadCards getInstance() {
        if (instance == null) {
            instance = new ReadCards();
        }

        return instance;
    }
}
