import java.util.Objects;

public class Account {

    private long money;
    private boolean bloc = false;
    private String accNumber;

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isBloc() {
        return bloc;
    }

    public void setBloc(boolean bloc) {
        this.bloc = bloc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return getMoney() == account.getMoney() && getAccNumber().equals(account.getAccNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMoney(), getAccNumber());
    }
}
