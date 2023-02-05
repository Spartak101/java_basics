import java.util.Random;

public class Thread extends java.lang.Thread {
    private Bank bank;
    private int countTransactions;
    private int thread;
    private static final Random random = new Random();

    public Thread(Bank bank, int countTransactions, int thread) {
        this.bank = bank;
        this.countTransactions = countTransactions;
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < countTransactions; i++) {
                long amount = random.nextLong(0, 51000);
                String a = bank.getArrayKeys().get(random.nextInt(bank.getArrayKeys().size()));
                String b = bank.getArrayKeys().get(random.nextInt(bank.getArrayKeys().size()));
                if (a.equals(b)) {
                    countTransactions++;
                    System.out.println("____________________countTransactions");
                    continue;
                }
                bank.transfer(a, b, amount);
                System.out.println(i);
                AllTransactionsCount.incrementInteger();
                System.out.println(AllTransactionsCount.getInteger() + " Thread: " + thread);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
