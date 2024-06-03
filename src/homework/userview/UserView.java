package homework.userview;

import homework.calculator.Numbers;
import homework.calculator.commands.impl.Commands;
import homework.util.input;

import java.util.Scanner;

public class UserView {
    private Commands commands;
    public void run() {
        input Input;
        while (true) {
            String insert = prompt("Insert command: ");
            Input = input.valueOf(insert);
            if (Input == input.EXIT) return;
            switch (Input) {
                case INPUT:
                    commands = new Commands(numbers());
                    break;
                case PLUS:
                    commands.plus();
                    break;
                case MINUS:
                    commands.minus();
                    break;
                case MULTIPLY:
                    commands.multiply();
                    break;
                case DIVIDE:
                    commands.divide();
                    break;
            }
        }
    }
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    private Numbers numbers() {
        long a = Long.parseLong(prompt("Insert first part of the first number: "));
        long ai = Long.parseLong(prompt("Insert second part of the first number (WITHOUT 'i'): "));
        long b = Long.parseLong(prompt("Insert first part of the second number: "));
        long bi = Long.parseLong(prompt("Insert second part of the second number (WITHOUT 'i'): "));
        return new Numbers(a, ai, b, bi);
    }
}
