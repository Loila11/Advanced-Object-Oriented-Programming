public class Item {
    protected String name;
    protected double price;
    protected int ID;
    private static int cnt = 0;

//    constructor
    public Item(String name, double price) {
        cnt ++;
        ID = cnt;
        this.price = price;
        this.name = name;
    }

//    setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getID() {
        return ID;
    }
}
