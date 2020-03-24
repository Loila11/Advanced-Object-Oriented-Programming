package ex1;

public class RandomTask implements Task {
    @Override
    public void execute() {
        System.out.println(mesaj);
    }

    String mesaj;
    public RandomTask() {
        mesaj = "Mesaj random";
    }

    public RandomTask(String mesaj) {
        this.mesaj = mesaj;
    }
}
