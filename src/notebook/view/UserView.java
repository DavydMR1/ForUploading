package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.util.Commands;

import java.util.Scanner;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run(){
        Commands com;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    userController.saveUser(prompt("Введите данные в следующем формате:<Имя> <Фамилия> <Отчество> <Дата_рождения(дд,мм,гггг)> <номер_телефона> <пол>\n"));
                    break;
                case READ:
                    String id = prompt("Фамилия пользователя: ");
                    try {
                        userController.readUser(id);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}