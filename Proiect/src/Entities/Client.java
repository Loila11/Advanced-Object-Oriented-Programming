package Entities;

public class Client {
    private String firstName, lastName;
    private int ID;
    private static int cnt = 0;

//    constructor
    public Client(String firstName, String lastName) {
        cnt ++;
        ID = cnt;
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    setter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getID() {
        return ID;
    }
}
