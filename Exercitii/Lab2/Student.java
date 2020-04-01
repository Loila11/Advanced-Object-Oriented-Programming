public class Student {
    private String nume;
    private int varsta;

    public Student() {
        this.nume = "";
        this.varsta = 0;
    }
    public Student(String nume, int varsta) {
        this.nume = nume;
        this.varsta = varsta;
    }

    public String getNume() {
        return this.nume;
    }
    public int getVarsta() {
        return this.varsta;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public void cresteVarsta() {
        this.varsta ++;
    }
}
