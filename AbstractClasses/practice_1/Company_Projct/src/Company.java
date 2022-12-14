import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Company {

    ArrayList<Employee> list = new ArrayList();
    ArrayList<Employee> listManager = new ArrayList<>();
    ArrayList<Employee> listTopManager = new ArrayList<>();

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        ArrayList<Employee> off;
        if (count < 0) {
            return list;
        } else if (count > (list.size() + listManager.size() + listTopManager.size())) {
            return list;
        } else {
            ArrayList<Employee> employees = new ArrayList<>();
            off = new ArrayList<>();
            for (Employee em : list) {
                employees.add(em);
            }
            for (Employee en : listManager) {
                employees.add(en);
            }
            for (Employee eb : listTopManager) {
                if (getIncome() > 10_000_000) {
                    eb.setSalaryStaffTopManager(2.5);
                    employees.add(eb);
                } else {
                    eb.setSalaryStaffTopManager(1.0);
                    employees.add(eb);
                }
            }
            Collections.sort(employees, (o1, o2) -> (o1.getMonthSalary() != o2.getMonthSalary()) ?
                    (int) (o1.getMonthSalary() - o2.getMonthSalary()) :
                    (o1.getNameEmployee().compareTo((String) o2.getNameEmployee())));
            for (int i = employees.size() - 1; i > employees.size() - count - 1; i--) {
                off.add(employees.get(i));
            }
        }
        return off;
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        ArrayList<Employee> off;
        if (count < 0) {
            return list;
        } else if (count > (list.size() + listManager.size() + listTopManager.size())) {
            return list;
        } else {
            ArrayList<Employee> employees = new ArrayList<>();
           off = new ArrayList<>();
            for (Employee em : list) {
                employees.add(em);
            }
            for (Employee en : listManager) {
                employees.add(en);
            }
            for (Employee eb : listTopManager) {
                if (getIncome() > 10_000_000) {
                    eb.setSalaryStaffTopManager(2.5);
                    employees.add(eb);
                } else {
                    eb.setSalaryStaffTopManager(1.0);
                    employees.add(eb);
                }
            }
            Collections.sort(employees, (o1, o2) -> (o1.getMonthSalary() != o2.getMonthSalary()) ?
                    (int) (o1.getMonthSalary() - o2.getMonthSalary()) :
                    (o1.getNameEmployee().compareTo((String) o2.getNameEmployee())));
            for (int i = 0; i < count; i++) {
                off.add(employees.get(i));
            }
        }
        return off;
    }


    public void hire(Operator employee) {
        list.add(employee);
    }

    public void hire(Manager employee) {
        listManager.add(employee);
    }

    public void hire(TopManager employee) {
        listTopManager.add(employee);
    }

    public void hireAll(Collection<Employee> employes) {
        list.addAll(employes);
    }

    public void fire(Operator employee) {
        list.remove(employee);
    }

    public void fire(Manager employee) {
        listManager.remove(employee);
    }

    public void fire(TopManager employee) {
        listTopManager.remove(employee);
    }


    public double getIncome() {
        int income = 0;
        ArrayList<Integer> list1 = new ArrayList<>();
        for (Employee em : listManager) {
            list1.add(em.getMoneyForCompany());
        }
        for (Employee em : listTopManager) {
            list1.add(em.getMoneyForCompany());
        }
        Collections.sort(list1);
        for (int i = list1.size() - 1; i > 0; i--) {
            income += list1.get(i);
        }
        return income;
    }
}
