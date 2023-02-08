import java.util.Random;

public class Thread extends java.lang.Thread {
    private Bank bank;
    private int thread;
    private static final Random random = new Random();

    public Thread(Bank bank, int thread) {
        this.bank = bank;
        this.thread = thread;
    }

    @Override
    public void run() {
        System.out.println("___________________________Поток " + thread + " открыт");
        try {
            long amount = random.nextLong(0, 55000);
            String a = bank.getArrayKeys().get(random.nextInt(bank.getArrayKeys().size()));
            String b = bank.getArrayKeys().get(random.nextInt(bank.getArrayKeys().size()));
            if (a.equals(b)) {
                System.out.println("____________________Перевод сам себе");
                return;
            }
            bank.transfer(a, b, amount, thread);
            AllTransactionsCount.incrementInteger();
            System.out.println(AllTransactionsCount.getInteger() + " Thread: " + thread);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("___________________________Поток " + thread + " закрыт");
    }
}
