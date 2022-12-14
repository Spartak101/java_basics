import java.util.concurrent.ThreadLocalRandom;

public class TopManager implements Employee {

    public String nameTopManager = "TopManager";
    private int moneyForCompany = ThreadLocalRandom.current().nextInt(115000, 140000 + 1);
    public double salaryStaffTopManager;

    public TopManager() {
        salaryStaffTopManager = Employee.FixedSalaryStaff;
    }

    public Integer getMoneyForCompany() {
        return moneyForCompany;
    }

    public double setSalaryStaffTopManager(double multipler) {
       return salaryStaffTopManager = Employee.FixedSalaryStaff * multipler;
    }

    @Override
    public Comparable<String> getNameEmployee() {
        return nameTopManager;
    }

    @Override
    public double getMonthSalary() {
        return salaryStaffTopManager;
    }

}
