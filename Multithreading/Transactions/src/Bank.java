import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {

    private TreeMap<String, Account> accounts = new TreeMap<>();
    private ArrayList<String> arrayKeys = new ArrayList<>();

    private long allMoney = 0;

    private int thread;
    private long fraudSum = 50_000L;
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public ArrayList<String> getArrayKeys() {
        return arrayKeys;
    }

    public TreeMap<String, Account> getAccounts() {
        return accounts;
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount, int thread) throws InterruptedException {
        this.thread = thread;

        if (accounts.containsKey(fromAccountNum) == false) {
            System.out.println("Счёт не обнаружен");
            return;
        }

        if (accounts.containsKey(fromAccountNum) == false) {
            System.out.println("Счёт получателя не обнаружен");
            return;
        }

        boolean blocTransfer = false;
        if (amount > fraudSum) {
            blocTransfer = isFraud(fromAccountNum, toAccountNum, amount);
        }
        if (blocTransfer == true) {
            blocAccounts(fromAccountNum, toAccountNum, thread);
            return;
        }
        if (getBalance(fromAccountNum) >= amount) {
            transaction(fromAccountNum, toAccountNum, amount, thread);
        } else {
            System.out.println("На вашем счёте недостаточно средств" + "  Thread " + thread);
        }
        AtomicLong after = new AtomicLong();
        accounts.forEach((s, account) -> after.addAndGet(account.getMoney()));
        if (allMoney != after.get()) {
            System.out.println("Караул! Куда-то делись деньги!" + "  Thread " + thread);
        }
    }

    private void transaction(String fromAccountNum, String toAccountNum, long amount, int thread) {
        synchronized (accounts.get(fromAccountNum)) {
            synchronized (accounts.get(toAccountNum)) {
                System.out.println("Транзакция начата" + "  Thread " + thread);
                if (!accounts.get(fromAccountNum).isBloc() && !accounts.get(toAccountNum).isBloc()) {
                    accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
                    accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
                } else {
                    System.out.println("Один из счетов блокирован службой безопасности банка" + "  Thread " + thread);
                }
                System.out.println("Транзакция завершена" + "  Thread " + thread);
            }
        }
    }

    private void blocAccounts(String fromAccountNum, String toAccountNum, int thread) {
        synchronized (accounts.get(fromAccountNum)) {
            synchronized (accounts.get(toAccountNum)) {
                System.out.println("Блокировка начата" + "  Thread " + thread);
                accounts.get(fromAccountNum).setBloc(true);
                accounts.get(toAccountNum).setBloc(true);
                System.out.println("Блокировка завершена" + "  Thread " + thread);
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public synchronized long getBalance(String accountNum) {
        Account a = accounts.get(accountNum);
        return a.getMoney();
    }


    public void accountsGenerated() {
        int countAccounts = 1000;
        for (int i = 0; i < countAccounts; i++) {
            long money = random.nextLong(0, 1_000_000);
            allMoney += money;
            String accNumber = "";
            for (int j = 0; j < 20; j++) {
                accNumber += random.nextInt(0, 9);
            }
            Account account = new Account(money, accNumber);
            if (!accounts.containsKey(accNumber)) {
                accounts.put(accNumber, account);
                arrayKeys.add(accNumber);
            } else {
                countAccounts++;
            }
        }
    }
}
