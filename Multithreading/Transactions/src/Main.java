import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    private static final Random random = new Random();
    private static int countTread = 100;

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        bank.accountsGenerated();
        AtomicLong before = bank.getAllMoney();
        for (int j = 0; j < countTread; j++) {
            Thread thread = new Thread(bank, j);
            thread.start();
        }
        AtomicLong after = bank.getAllMoney();
        if (Objects.equals(before, after)){
            System.out.println("Караул! Куда-то делись деньги!" + "before: " + before + " - " + "after: " + after);
        }
    }
}
