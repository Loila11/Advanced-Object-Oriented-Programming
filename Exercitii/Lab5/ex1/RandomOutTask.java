package ex1;

public class RandomOutTask implements Task {
    @Override
    public void execute() {
        System.out.println("Numarul generat: " + x);
    }

    double x;
    public RandomOutTask() {
        x = Math.random();
    }
}
