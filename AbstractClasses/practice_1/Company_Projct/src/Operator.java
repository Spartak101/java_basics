import java.util.concurrent.ThreadLocalRandom;

public class Operator implements Employee{

    public String nameOperator = "Operator";

    private int modifierSalaryStaff = ThreadLocalRandom.current().nextInt(1, 100 + 1);
    public double salaryStaffOperator;

    public Operator() {
        salaryStaffOperator =  Employee.FixedSalaryStaff + modifierSalaryStaff;
    }


    @Override
    public double getMonthSalary() {
        return salaryStaffOperator;
    }

    @Override
    public Integer getMoneyForCompany() {
        return 0;
    }

    public String getNameEmployee() {
        return nameOperator;
    }

    @Override
    public double setSalaryStaffTopManager(double multipler) {
        return 0;
    }
}
