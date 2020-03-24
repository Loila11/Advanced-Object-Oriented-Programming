package ex1;

public class CounterOutTask implements Task {
    @Override
    public void execute() {
        contor ++;
        System.out.println(contor);
    }

    static int contor = 0;
}
