package Exceptions;

public class WrongFormat extends Exception {
    public WrongFormat() {
        super("Fisierul nu are formatul corect.");
    }
}
