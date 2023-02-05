import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {

    private TreeMap<String, Account> accounts = new TreeMap<>();
    private TreeMap<String, Account> bloc = new TreeMap<>();
    private ArrayList<String> arrayKeys = new ArrayList<>();

    private long allMoney = 0;
    private long allMoneyOpen = 0;
    private long allMoneyBloc = 0;
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
    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        if (bloc.containsKey(fromAccountNum) == true) {
            System.out.println("Счёт заблокирован службой безопасности банка");
            return;
        }
        if (accounts.containsKey(fromAccountNum) == false) {
            System.out.println("Счёт не обнаружен");
            return;
        }
        if (bloc.containsKey(toAccountNum) == true) {
            System.out.println("Счёт получателя заблокирован службой безопасности банка");
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
            blocAccounts(fromAccountNum, toAccountNum);
            return;
        }
        if (accounts.get(fromAccountNum).getMoney() >= amount) {
            transaction(fromAccountNum, toAccountNum, amount);
        } else {
            System.out.println("На вашем счёте недостаточно средств");
        }
        long after = allMoneyOpen + allMoneyBloc;
        if (allMoney != after) {
            System.out.println("Караул! Куда-то делись деньги!");
        }
    }

    private synchronized void transaction(String fromAccountNum, String toAccountNum, long amount) {
        accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
        accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
    }

    private synchronized void blocAccounts(String fromAccountNum, String toAccountNum) {
        bloc.put(fromAccountNum, accounts.get(fromAccountNum));
        bloc.put(toAccountNum, accounts.get(toAccountNum));
        accounts.remove(fromAccountNum);
        accounts.remove(toAccountNum);
        long moneyBlocAmount = bloc.get(fromAccountNum).getMoney() + bloc.get(toAccountNum).getMoney();
        allMoneyOpen -= moneyBlocAmount;
        allMoneyBloc += moneyBlocAmount;
        System.out.println("Операция заблокирована службой безопасности банка");
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        Account a = accounts.get(accountNum);
        return a.getMoney();
    }

 /*   public synchronized long getSumAllAccounts() {
        AtomicLong sum = new AtomicLong();
        ArrayList<Account> v = new ArrayList<>(accounts.values());
        v.forEach(s -> sum.addAndGet(s.getMoney()));
        return sum.get();
    }

    public synchronized long getSumAllBlocAccounts() {
        AtomicLong sumBloc = new AtomicLong();
        ArrayList<Account> v = new ArrayList<>(bloc.values());
        v.forEach(s -> sumBloc.addAndGet(s.getMoney()));
        return sumBloc.get();
    }*/

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
        allMoneyOpen = allMoney;
    }
}
