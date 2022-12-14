import java.util.concurrent.ThreadLocalRandom;

public class Manager implements Employee {

    public String nameManager = "Manager";

    private int moneyForCompany = ThreadLocalRandom.current().nextInt(115000, 140000 + 1);
    public double salaryStaffManager;

    public Manager() {
        salaryStaffManager = (double) (Employee.FixedSalaryStaff + moneyForCompany * 0.05);
    }

    public Integer getMoneyForCompany() {
        return moneyForCompany;
    }

    @Override
    public Comparable<String> getNameEmployee() {
        return nameManager;
    }

    @Override
    public double setSalaryStaffTopManager(double multipler) {
        return 0;
    }

    @Override
    public double getMonthSalary() {
        return salaryStaffManager;
    }

}
