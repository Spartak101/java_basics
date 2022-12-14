import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        for (int i = 0; i < 180; i++) {
            company.hire(new Operator());
        }
        for (int i = 0; i < 80; i++) {
            company.hire(new Manager());
        }
        for (int i = 0; i < 10; i++) {
            company.hire(new TopManager());
        }
        System.out.println(company.listManager.size());
        System.out.println(company.listTopManager.size());
      /*  System.out.println(company.getIncome());*/
        for (Employee c : company.getTopSalaryStaff(5)) {
            System.out.println(c.getMonthSalary());
        }
        for (Employee c : company.getLowestSalaryStaff(5)) {
            System.out.println(c.getMonthSalary());
        }



        for (int i = 0; i < 90; i++) {
            company.fire((Operator) company.list.get(i));
        }
        for (int i = 0; i < 40; i++) {
            company.fire((Manager) company.listManager.get(i));
        }
        for (int i = 0; i < 5; i++) {
            company.fire((TopManager) company.listTopManager.get(i));
        }
        System.out.println(company.listManager.size());
        System.out.println(company.listTopManager.size());
      /*  System.out.println(company.getIncome());*/
        for (Employee c : company.getTopSalaryStaff(5)) {
            System.out.println(c.getMonthSalary());
        }
        for (Employee c : company.getLowestSalaryStaff(5)) {
            System.out.println(c.getMonthSalary());
        }





    }
}