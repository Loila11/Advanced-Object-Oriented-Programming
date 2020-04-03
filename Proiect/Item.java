public class Item {
    protected String name;
    protected float price;
    protected int ID;
    private static int cnt = 0;

//    constructor
    public Item(String name, float price) {
        cnt ++;
        ID = cnt;
        this.price = price;
        this.name = name;
    }

//    setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

//    getters
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getID() {
        return ID;
    }
}
