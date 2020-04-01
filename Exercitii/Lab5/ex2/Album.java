package ex2;

public class Album implements Comparable<Album>{
    String nume;
    int anulPublicarii, rating;

    public Album() {
        nume = "John Doe";
        anulPublicarii = 2020;
        rating = 10;
    }

    public Album(String nume) {
        this.nume = nume;
        this.anulPublicarii = 2020;
        this.rating = 10;
    }

    public Album(String nume, int anulPublicarii) {
        this.nume = nume;
        this.anulPublicarii = anulPublicarii;
        this.rating = 10;
    }

    public Album(String nume, int anulPublicarii, int rating) {
        this.nume = nume;
        this.anulPublicarii = anulPublicarii;
        this.rating = rating;
    }

    public String getNume() {
        return nume;
    }

    public int getAnulPublicarii() {
        return anulPublicarii;
    }

    public int getRating() {
        return rating;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setAnulPublicarii(int anulPublicarii) {
        this.anulPublicarii = anulPublicarii;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public int compareTo(Album album) {
        if (this.rating == album.rating) {
            return 0;
        } else if (this.rating > album.rating) {
            return 1;
        }
        return -1;
    }
}
