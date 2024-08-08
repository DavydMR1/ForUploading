package hw5.employeeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Commands {
    List<Employee> employeeList;

    public Commands() {
        employeeList = new ArrayList<>();
    }

    public void add(String tabNumber, int phoneNumber, String name, int workExperience) {
        employeeList.add(new Employee(tabNumber, phoneNumber, name, workExperience));
    }

    public List<Employee> searchByExperience(int experience) {
        List<Employee> returnable = new ArrayList<>();
        for (Employee e : employeeList) {
            if (e.getWorkExperience() == experience) {
                returnable.add(e);
            }
        }
        return returnable;
    }

    public List<Integer> searchPhoneNumberByName(String name) {
        List<Integer> returnable = new ArrayList<>();
        for (Employee e : employeeList) {
            if (Objects.equals(e.getName(), name)) {
                returnable.add(e.getPhoneNumber());
            }
        }
        return returnable;
    }

    public Employee searchByTabNumber(String tabNumber) {
        for (Employee e : employeeList) {
            if (Objects.equals(e.getTabNumber(), tabNumber)) {
                return e;
            }
        }
        return null;
    }
}
