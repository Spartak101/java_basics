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
        System.out.println("___________________________Поток " + thread + " открыт");
        int countUpdate = 0;
        try {
            for (int i = 0; i < countTransactions; i++) {
                long amount = random.nextLong(0, 55000);
                String a = bank.getArrayKeys().get(random.nextInt(bank.getArrayKeys().size()));
                String b = bank.getArrayKeys().get(random.nextInt(bank.getArrayKeys().size()));
                if (a.equals(b)) {
                    i--;
                    countUpdate++;
                    System.out.println("____________________countTransactions");
                    continue;
                }
                bank.transfer(a, b, amount, thread);
                System.out.println(i);
                AllTransactionsCount.incrementInteger();
                System.out.println(AllTransactionsCount.getInteger() + " Thread: " + thread + "    CountUpdate: " + countUpdate);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("___________________________Поток " + thread + " закрыт");
    }
}
