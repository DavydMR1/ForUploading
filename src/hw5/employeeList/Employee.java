package hw5.employeeList;

public class Employee {
    private String tabNumber;
    private int phoneNumber;
    private String name;
    private int workExperience;

    public Employee(String tabNumber, int phoneNumber, String name, int workExperience) {
        this.tabNumber = tabNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.workExperience = workExperience;
    }

    public void setTabNumber(String tabNumber) {
        this.tabNumber = tabNumber;
    }

    public String getTabNumber() {
        return tabNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public String toString() {
        return "[" + "Tab number: " + tabNumber + " " +
                "Phone number: " + phoneNumber + " " +
                "Name: " + name + " " +
                "Work experience: " + workExperience + "]";
    }
}
