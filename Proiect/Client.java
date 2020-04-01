public class Client {
    private String name;
    private int ID;
    private static int cnt = 0;

//    constructor
    public Client(String name) {
        cnt ++;
        ID = cnt;
        this.name = name;
    }

//    setter
    public void setName(String name) {
        this.name = name;
    }

//    getters
    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }
}
