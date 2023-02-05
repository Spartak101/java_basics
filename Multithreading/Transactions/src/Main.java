import java.util.Random;

public class Main {
    private static final Random random = new Random();
    private static int countTransactions = 100;
    private static int countTread = 10;

    public static void main(String[] args) throws InterruptedException {

        Bank bank = new Bank();
        bank.accountsGenerated();
        for (int j = 0; j < countTread; j++) {
            Thread thread = new Thread(bank, countTransactions, j);
            thread.start();
        }
    }
}
