package hw5;

import hw5.employeeList.Commands;

public class Main {
    public static void main(String[] args) {
        Commands commands = new Commands();
        commands.add("xdx", 12220001, "banana", 2);
        commands.add("xdd", 10022311, "ananab", 1);
        commands.add("xxx", 34383221, "banana", 1);
        System.out.println(commands.searchByExperience(1));
        System.out.println(commands.searchPhoneNumberByName("banana"));
        System.out.println(commands.searchByTabNumber("xdx"));
    }
}
